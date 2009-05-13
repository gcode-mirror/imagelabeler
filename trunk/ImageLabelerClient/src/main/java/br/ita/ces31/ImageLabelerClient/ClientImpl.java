/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.ImageLabelerClient;

import br.ita.ces31.ImageLabelerCommon.Client;
import br.ita.ces31.ImageLabelerCommon.Game;
import br.ita.ces31.ImageLabelerCommon.GameServer;
import br.ita.ces31.ImageLabelerCommon.GameSummary;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Helder Suzuki <helder@aluno.ita.br>
 */
public class ClientImpl extends UnicastRemoteObject implements Client {
    private String loginName;
    private Registry registry;
    private GameServer gameServer;

    public ClientImpl(String loginName, String serverURI)
            throws RemoteException {
        this.loginName = loginName;

        try {
            registry = LocateRegistry.getRegistry(serverURI);
            gameServer = (GameServer) registry.lookup(GameServer.referenceName);
            gameServer.login(this);
        } catch (NotBoundException ex) {
            System.err.println("Not Bound exception: " + ex.toString());
            ex.printStackTrace();
            throw new RemoteException();
        }
    }

    public String getLoginName() {
        return this.loginName;
    }

    public void notifyGuessMatch(String guess) {
        System.out.println("Guess Match! " + guess);
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void startGame(Game game) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void endGame(GameSummary summary) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void sendGuess(String guess) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
