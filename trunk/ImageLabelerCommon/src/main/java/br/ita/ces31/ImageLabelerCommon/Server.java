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

    public static String referenceName = "ImageLabelerServer";
    public static int serverPort = 1099;

    public boolean isAlive() throws RemoteException;

    public boolean identify(Client client) throws RemoteException;

    public void notifyPenico() throws RemoteException;

    public void notifyWait(Client client) throws RemoteException;

    public void cancelWait(Client client) throws RemoteException;

    public void sendLabel(String label) throws RemoteException;
}
