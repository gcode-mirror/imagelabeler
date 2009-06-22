/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.imagelabeler.client.communicator;

import br.ita.ces31.imagelabeler.common.Server;
import java.rmi.Naming;

/**
 *
 * @author Helder Suzuki <helder@aluno.ita.br>
 */
public class ClientCommunicatorSingleton {
    private static ClientCommunicator communicator;
    private static String serverHost = "localhost";

    private static String getServerURL() {
        String url = ("//" + serverHost + ":" +
                      Server.serverPort + "/" + Server.referenceName);
        return url;
    }

    public static void setServerHost(String host) {
        serverHost = host;
    }

    public synchronized static ClientCommunicator getCommunicator()
        throws CommunicationException {
        if (communicator == null) {
            try {
                Server server = (Server) Naming.lookup(getServerURL());
                communicator = new ClientCommunicator(server);
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new CommunicationException();
            }
        }

        return communicator;
    }
}
