/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.imagelabeler.client;

import br.ita.ces31.imagelabeler.client.controller.builder.ControllerBuilder;
import br.ita.ces31.imagelabeler.client.communicator.ClientCommunicatorSingleton;
import br.ita.ces31.imagelabeler.client.communicator.CommunicationException;
import br.ita.ces31.imagelabeler.client.controller.Controller;
import br.ita.ces31.imagelabeler.client.controller.builder.ControllerSwingUIBuilder;

/**
 *
 * @author diego
 */
public class ClientMain {

    public static void main(final String args[]) {
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

                Controller controller = null;
                
                try {
                    ControllerBuilder builder = new ControllerSwingUIBuilder();
                    controller = builder.buildController();

                    ClientCommunicatorSingleton.getCommunicator().addObserver(controller);
                    controller.startClient();
                } catch (CommunicationException ex) {
                    ex.printStackTrace();
                    controller.notifyConnectionFailed();
                }
            }
        });
    }
}
