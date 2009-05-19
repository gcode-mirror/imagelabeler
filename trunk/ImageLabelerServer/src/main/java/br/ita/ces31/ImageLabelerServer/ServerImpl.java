/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.ImageLabelerServer;

import br.ita.ces31.ImageLabelerCommon.Client;
import br.ita.ces31.ImageLabelerCommon.Server;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Helder Suzuki <helder@aluno.ita.br>
 */
public class ServerImpl extends UnicastRemoteObject implements Server {

    private List<Client> loggedClients;
    private Client wait;
    private Game game;

    public ServerImpl() throws RemoteException {
        loggedClients = new ArrayList<Client>();
        wait = null;
    }

    private void removeDeadClients() throws RemoteException {
        for (Client c : loggedClients) {
            if (!c.isAlive()) {
                loggedClients.remove(c);
            }
        }
    }

    public synchronized boolean identify(Client client) throws RemoteException {
        System.out.println("New client " + client.getLoginName());

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

    public synchronized boolean isAlive() throws RemoteException {
        return true;
    }

    public void sendLabel(String label) throws RemoteException {
        if (game.addLabel(label)) {  // ocorreu match
            try {
                game.getClient1().notifyMatch(label);
            } catch (RemoteException ex) {
            }

            try {
                game.getClient2().notifyMatch(label);
            } catch (RemoteException ex) {
            }
        }
    }

    private void startGame() throws RemoteException {
        game = GameBuilder.createGame(
                loggedClients.get(0),
                loggedClients.get(1));

        for (Client c : loggedClients) {
            c.startGame(Game.duration);
        }
    }

    public void notifyPenico() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
