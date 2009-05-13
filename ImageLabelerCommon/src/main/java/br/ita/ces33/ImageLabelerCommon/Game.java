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
public interface Game extends Remote{
    public void sendGuess(String guess) throws RemoteException;
    public int getGameDuration() throws RemoteException;
    public void notifyTimeout() throws RemoteException;
}
