/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.ImageLabelerCommon;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Helder Suzuki <helder@aluno.ita.br>
 */
public interface Client extends Remote {

    public String getLoginName() throws RemoteException;

    public void notifyMatch(String match) throws RemoteException;

    public void notifyPenico() throws RemoteException;

    public void startGame(int seconds) throws RemoteException;

    public void endGame(GameSummary summary) throws RemoteException;

    public boolean isAlive() throws RemoteException;

}
