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

    /**
     * Adquire nome de identificação fornecido no cliente.
     * @return
     * @throws java.rmi.RemoteException
     */
    public String getLoginName() throws RemoteException;

    /**
     * Notifica cliente da ocorrência de um match.
     * @param match
     * @throws java.rmi.RemoteException
     */
    public void notifyMatch(String match) throws RemoteException;

    /**
     * Notifica cliente de que foi solicitado penico.
     * @throws java.rmi.RemoteException
     */
    public void notifyPenico() throws RemoteException;

    /**
     * Inicia a partida.
     * @param image
     * @param seconds
     * @param partner 
     * @throws java.rmi.RemoteException
     */
    public void startGame(String image, int seconds, String partner) throws RemoteException;

    /**
     * Encerra a partida.
     * @param summary
     * @throws java.rmi.RemoteException
     */
    public void endGame(GameSummary summary) throws RemoteException;

    /**
     * Testa se o cliente está conectado.
     * @return
     * @throws java.rmi.RemoteException
     */
    public boolean isAlive() throws RemoteException;
}