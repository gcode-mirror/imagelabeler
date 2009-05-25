/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.ImageLabelerServer;

import br.ita.ces31.ImageLabelerServer.persistence.PersistenceException;
import br.ita.ces31.ImageLabelerServer.timer.TimeoutTimer;
import br.ita.ces31.ImageLabelerCommon.Client;
import br.ita.ces31.ImageLabelerCommon.GameSummary;
import br.ita.ces31.ImageLabelerCommon.Player;
import br.ita.ces31.ImageLabelerCommon.Server;
import br.ita.ces31.ImageLabelerServer.persistence.PlayerPersistence;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

/**
 *
 * @author Helder Suzuki <helder@aluno.ita.br>
 */
public class ServerImpl extends UnicastRemoteObject implements Server {

    private List<Client> loggedClients;
    private Client wait;
    private Game game;
    private PlayerPersistence playerPersistence;
    private ImageServer imageServer;
    private TimeoutTimer timer;

    public ServerImpl(PlayerPersistence playerPersistence,
                      ImageServer imageServer,
                      TimeoutTimer timer) throws RemoteException {
        this.playerPersistence = playerPersistence;
        this.imageServer = imageServer;
        this.timer = timer;
        loggedClients = new ArrayList<Client>();
        wait = null;
    }

    private GameSummary getSummary() {
        try {
            List<Player> rank;
            rank = playerPersistence.getBestPlayers(10);
            return new GameSummary(this.game.getScore(), rank,
                                   game.getMatches());
        } catch (Exception ex) {
            return new GameSummary();
        }
    }

    private void removeDeadClients() throws RemoteException {
        for (Client c : new ArrayList<Client>(loggedClients)) {
            if (!c.isAlive()) {
                loggedClients.remove(c);
            }
        }
    }

    public synchronized boolean identify(Client client) throws RemoteException {
        // Cliente ja logado.
        if (loggedClients.contains(client)) {
            return true;
        }

        removeDeadClients();

        if (loggedClients.size() < 2) {
            loggedClients.add(client);
            return true;
        }

        return false;
    }

    public synchronized void notifyWait(Client client) throws RemoteException {
        if (wait == null) {
            wait = client;
            return;
        }

        if (wait.isAlive()) {
            startGame();
            wait = null;
        } else {
            loggedClients.remove(wait);
            wait = client;
        }
    }

    public synchronized void cancelWait(Client client) throws RemoteException {
        if (wait == client) {
            wait = null;
            loggedClients.remove(client);
        }
    }

    public synchronized void sendLabel(String label) throws RemoteException {
        if (game != null && game.addLabel(label)) {  // ocorreu match
            for (Client c : loggedClients) {
                try {
                    c.notifyMatch(label);
                } catch (RemoteException ex) {
                }
            }
        }
    }

    private void startGame() throws RemoteException {
        game = GameBuilder.createLengthGame(
            loggedClients.get(0),
            loggedClients.get(1));

        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                notifyTimeout();
            }
        }, Game.duration * 1000);

        for (Client c : loggedClients) {
            c.startGame(imageServer.getImage(), Game.duration);
        }
    }

    private void updateScore() throws PersistenceException, RemoteException {
        int score = game.getScore();
        Player p1 = playerPersistence.getPlayer(game.getClient1().getLoginName());
        Player p2 = playerPersistence.getPlayer(game.getClient2().getLoginName());

        p1.setScore(p1.getScore() + score);
        p2.setScore(p2.getScore() + score);
        playerPersistence.update(p1);
        playerPersistence.update(p2);
    }

    public synchronized void notifyTimeout() {
        try {
            updateScore();
        } catch (Exception e) {
            e.printStackTrace();
        }

        GameSummary summary = getSummary();

        if (game != null) {
            for (Client c : loggedClients) {
                try {
                    c.endGame(summary);
                } catch (RemoteException ex) {
                }
            }
        }
    }

    public synchronized void notifyPenico() throws RemoteException {
        for (Client c : loggedClients) {
            c.notifyPenico();
        }
        game = null;
    }
}
