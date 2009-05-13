/*
 * Image Labeler - Projeto de CES-31
 */

package br.ita.ces33.ImageLabelerCommon;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Helder Suzuki <helder@aluno.ita.br>
 */
public interface Client extends Remote{
    public String getLoginName() throws RemoteException;
    public void notifyGuessMatch(String guess) throws RemoteException;
    public void startGame(Game game) throws RemoteException;
    public void endGame(GameSummary summary) throws RemoteException;
}
