/*
 * Image Labeler - Projeto de CES-31
 */

package br.ita.ces33.ImageLabelerServer;

import br.ita.ces33.ImageLabelerCommon.Client;
import br.ita.ces33.ImageLabelerCommon.GameServer;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Helder Suzuki <helder@aluno.ita.br>
 */
public class GameServerImpl extends UnicastRemoteObject implements GameServer{
    public GameServerImpl() throws RemoteException{
    }

    public void login(Client client) throws RemoteException {
        System.out.println("New client " + client.getLoginName());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        client.notifyGuessMatch("Oi!!");
    }

    public void sendGuess(String guess) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
