/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.ImageLabelerClient.communicator;

import java.rmi.RemoteException;

/**
 *
 * @author Helder Suzuki <helder@aluno.ita.br>
 */
public class CommunicatorSingleton {

    private static Communicator communicator;
    private static String serverURI = "localhost";

    public synchronized static Communicator getCommunicator()
            throws CommunicationException {
        if (communicator == null) {
            try {
                communicator = new CommunicatorImpl(serverURI);
            } catch (RemoteException ex) {
                ex.printStackTrace();
                throw new CommunicationException();
            }
        }

        return communicator;
    }
}
