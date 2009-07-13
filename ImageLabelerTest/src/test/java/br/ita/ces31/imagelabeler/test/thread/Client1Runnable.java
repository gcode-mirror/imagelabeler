/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ita.ces31.imagelabeler.test.thread;

import br.ita.ces31.imagelabeler.client.communicator.ClientCommunicatorSingleton;
import br.ita.ces31.imagelabeler.client.communicator.CommunicationException;
import br.ita.ces31.imagelabeler.client.communicator.Communicator;
import br.ita.ces31.imagelabeler.client.controller.Controller;
import br.ita.ces31.imagelabeler.client.controller.builder.ControllerBuilder;
import br.ita.ces31.imagelabeler.test.client.controller.builder.ControllerStubUIBuilder;

/**
 *
 * @author diego
 */
public class Client1Runnable implements Runnable{
    public Controller controller = null;

    public void run() {
        startingClient();
        controller.identify("Diego");
    }

    private void startingClient(){
        try {
            ControllerBuilder builder = new ControllerStubUIBuilder();
            controller = builder.buildController();

            //connect to client to the server
            Communicator clientCommunicator = ClientCommunicatorSingleton.getCommunicator();

            clientCommunicator.addObserver(controller);

            controller.startClient();

        } catch (CommunicationException ex) {
            ex.printStackTrace();
            controller.notifyConnectionFailed();
        }
    }
}
