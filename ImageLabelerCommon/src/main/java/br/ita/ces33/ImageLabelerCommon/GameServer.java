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
public interface GameServer extends Remote {

    public static String referenceName = "ImageLabelerServer";

    public void login(Client client) throws RemoteException;
}
