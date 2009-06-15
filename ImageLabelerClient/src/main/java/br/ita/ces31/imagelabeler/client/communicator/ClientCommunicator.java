/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.imagelabeler.client.communicator;

import br.ita.ces31.imagelabeler.common.Client;
import br.ita.ces31.imagelabeler.common.Server;
import br.ita.ces31.imagelabeler.common.GameSummary;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 * Bridge entre interface de usuário (representado pela interface Communicator)
 * e servidor (representado pela interface Client).
 * @author Helder Suzuki <helder@aluno.ita.br>
 */
public class ClientCommunicator extends UnicastRemoteObject
    implements Client, Communicator {

    private List<CommunicatorObserver> observers;
    private String loginName;
    private Server server;

    public ClientCommunicator(Server server) throws RemoteException {
        this.server = server;
        observers = new ArrayList<CommunicatorObserver>();
    }

    public String getLoginName() {
        return this.loginName;
    }

    public void endGame(GameSummary summary) throws RemoteException {
        for (CommunicatorObserver o : observers) {
            o.endGame(summary);
        }
    }

    public void notifyMatch(String match, int score) throws RemoteException {
        for (CommunicatorObserver o : observers) {
            o.notifyMatch(match, score);
        }
    }

    public void startGame(String image, int seconds, String partner) throws RemoteException {
        for (CommunicatorObserver o : observers) {
            o.startGame(image, seconds, partner);
        }
    }

    public boolean isAlive() throws RemoteException {
        return true;
    }

    public void notifyPenico() throws RemoteException {
        for (CommunicatorObserver o : observers) {
            o.endGameByPenico();
        }
    }

    public void sendLabel(String label) throws CommunicationException {
        try {
            server.sendLabel(label);
        } catch (RemoteException ex) {
            ex.printStackTrace();
            throw new CommunicationException();
        }
    }

    public void cancelWait() throws CommunicationException {
        try {
            server.cancelWait(this);
        } catch (RemoteException ex) {
            throw new CommunicationException();
        }
    }

    public void notifyWait() throws CommunicationException {
        try {
            server.notifyWait(this);
        } catch (RemoteException ex) {
            throw new CommunicationException();
        }
    }

    public boolean identify(String loginName) throws CommunicationException {
        this.loginName = loginName;
        try {
            if (server.identify(this)) {
                notifyWait();
                return true;
            }
        } catch (RemoteException ex) {
            ex.printStackTrace();
            throw new CommunicationException();
        }
        return false;
    }

    public void askPenico() throws CommunicationException {
        try {
            server.notifyPenico();
        } catch (RemoteException ex) {
            ex.printStackTrace();
            throw new CommunicationException();
        }
    }

    public synchronized void addObserver(CommunicatorObserver observer) {
        observers.add(observer);
    }

    public synchronized void removeObserver(CommunicatorObserver observer) {
        observers.remove(observer);
    }

}
