/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.ImageLabelerClient.communicator;

import br.ita.ces31.ImageLabelerCommon.Client;
import br.ita.ces31.ImageLabelerCommon.Server;
import br.ita.ces31.ImageLabelerCommon.GameSummary;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Helder Suzuki <helder@aluno.ita.br>
 */
public class CommunicatorImpl extends UnicastRemoteObject implements Client, Communicator {

    private List<CommunicatorObserver> observers;
    private String loginName;
    private Registry registry;
    private Server server;

    public CommunicatorImpl(String serverURI) throws RemoteException {
        registry = LocateRegistry.getRegistry(serverURI);
        try {
            server = (Server) registry.lookup(Server.referenceName);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RemoteException();
        }
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

    public void notifyMatch(String match) throws RemoteException {
        for (CommunicatorObserver o : observers) {
            o.notifyMatch(match);
        }
    }

    public void startGame(int seconds) throws RemoteException {
        for (CommunicatorObserver o : observers) {
            o.startGame(seconds);
        }
    }

    public boolean isAlive() throws RemoteException {
        return true;
    }

    public void notifyPenico() throws RemoteException {
        for (CommunicatorObserver o : observers) {
            o.engGameByPenico();
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
