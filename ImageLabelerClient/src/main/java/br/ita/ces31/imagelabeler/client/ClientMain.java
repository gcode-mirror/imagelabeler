/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.imagelabeler.client;

import br.ita.ces31.imagelabeler.client.communicator.ClientCommunicatorSingleton;
import br.ita.ces31.imagelabeler.client.communicator.CommunicationException;

/**
 *
 * @author diego
 */
public class ClientMain {

    public static void main(final String args[]) {
        ClientUIFactory.createSwingUI();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                if (args.length == 1) {
                    ClientCommunicatorSingleton.setServerHost(args[0]);
                }

                try {
                    ClientCommunicatorSingleton.getCommunicator().addObserver(new LogClient());
                } catch (CommunicationException ex) {
                    ex.printStackTrace();
                }

                try {
                    ClientUIFactory.getController().connect();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
