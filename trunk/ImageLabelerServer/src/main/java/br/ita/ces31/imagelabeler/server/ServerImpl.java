/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.imagelabeler.server;

import br.ita.ces31.imagelabeler.server.timer.TimeoutNotifiable;
import br.ita.ces31.imagelabeler.server.persistence.PersistenceException;
import br.ita.ces31.imagelabeler.server.timer.TimeoutTimer;
import br.ita.ces31.imagelabeler.common.Client;
import br.ita.ces31.imagelabeler.common.GameSummary;
import br.ita.ces31.imagelabeler.common.Player;
import br.ita.ces31.imagelabeler.common.Server;
import br.ita.ces31.imagelabeler.server.persistence.PlayerPersistence;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Helder Suzuki <helder@aluno.ita.br>
 */
public class ServerImpl extends UnicastRemoteObject
    implements Server, TimeoutNotifiable {

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
            ArrayList<Player> rank;
            rank = playerPersistence.getBestPlayers(10);
            return new GameSummary(this.game.getScore(), rank,
                                   game.getMatches());
        } catch (Exception ex) {
            ex.printStackTrace();
            return new GameSummary();
        }
    }

    private void removeDisconnectedClients() throws RemoteException {
        for (Client c : new ArrayList<Client>(loggedClients)) {
            if (!c.isAlive()) {
                loggedClients.remove(c);
            }
        }
    }

    /*
     * Caso de uso 1.4.2.2.1 b) Identificar participante
     * Realiza identificação do cliente.
     */
    public synchronized boolean identify(Client client) throws RemoteException {
        // Cliente ja logado.
        if (loggedClients.contains(client)) {
            return true;
        }

        removeDisconnectedClients();

        if (loggedClients.size() < 2) {
            loggedClients.add(client);
            return true;
        }

        return false;
    }

    /*
     * Caso de uso 1.4.2.2.1 e) Aguardar Início de Partida
     */
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

    /*
     * 1.4.1.2.2.1h) Caso de Uso: Notificar Cancelamento da Espera
     */
    public synchronized void cancelWait(Client client) throws RemoteException {
        if (wait == client) {
            wait = null;
            loggedClients.remove(client);
        }
    }

    /*
     * Caso de uso 1.4.2.2.1 c) Registrar Rótulo
     * Envia rótulo.
     */
    public synchronized void sendLabel(String label) throws RemoteException {
        if (game != null && game.addLabel(label)) {  // ocorreu match
            for (Client c : loggedClients) {
                try {
                    c.notifyMatch(label, game.getScore());
                } catch (RemoteException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    /*
     * Caso de uso 1.4.2.2.1 e) Aguardar Início de Partida
     * Iniciar Partida
     * Envia rótulo.
     */
    private void startGame() throws RemoteException {
        Client c1 = loggedClients.get(0);
        Client c2 = loggedClients.get(1);

        game = GameFactory.createLengthGame(c1, c2);
        timer.schedule(Game.duration * 1000);

        String image = imageServer.getImage();

        c1.startGame(image, Game.duration, c2.getLoginName());
        c2.startGame(image, Game.duration, c1.getLoginName());
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

    /*
     * 1.4.2.2.2 a) Caso de Uso: Notificar Término
     */
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
                    ex.printStackTrace();
                }
            }
        }
    }

    /*
     * 1.4.2.2.1f) Caso de Uso:  Notificar Desistência
     */
    public synchronized void notifyPenico() throws RemoteException {
        for (Client c : loggedClients) {
            c.notifyPenico();
        }
        game = null;
    }
}
