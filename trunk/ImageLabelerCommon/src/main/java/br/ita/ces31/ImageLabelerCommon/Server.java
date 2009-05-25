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
public interface Server extends Remote {

    /**
     * Nome de referência RMI do Server.
     */
    public static String referenceName = "ImageLabelerServer";
    /**
     * Porta do Server.
     */
    public static int serverPort = 1099;

    /**
     * Realiza identificação do cliente.
     * @param client
     * @return
     * @throws java.rmi.RemoteException
     */
    public boolean identify(Client client) throws RemoteException;

    /**
     * Notifica que cliente solicitou penico.
     * @throws java.rmi.RemoteException
     */
    public void notifyPenico() throws RemoteException;

    /**
     * Notifica que cliente está aguardando início da partida.
     * @param client
     * @throws java.rmi.RemoteException
     */
    public void notifyWait(Client client) throws RemoteException;

    /**
     * Notifica que cliente cancelou a espera para o início da partida.
     * @param client
     * @throws java.rmi.RemoteException
     */
    public void cancelWait(Client client) throws RemoteException;

    /**
     * Envia rótulo digitado pelo cliente.
     * @param label
     * @throws java.rmi.RemoteException
     */
    public void sendLabel(String label) throws RemoteException;
}
