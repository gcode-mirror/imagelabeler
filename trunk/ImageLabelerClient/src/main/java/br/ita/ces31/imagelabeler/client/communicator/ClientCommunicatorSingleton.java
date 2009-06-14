/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.imagelabeler.client.communicator;

import br.ita.ces31.ImageLabelerCommon.Server;
import java.rmi.Naming;

/**
 *
 * @author Helder Suzuki <helder@aluno.ita.br>
 */
public class ClientCommunicatorSingleton {

    private static Communicator communicator;
    private static String serverURI = "localhost";

    public synchronized static Communicator getCommunicator()
        throws CommunicationException {
        if (communicator == null) {
            try {
                String name = ("//" + serverURI + ":" +
                               Server.serverPort + "/" + Server.referenceName);

                /*
                 * Caso de uso 1.4.2.2.1 a) Conectar
                 */
                Server server = (Server) Naming.lookup(name);
                communicator = new ClientCommunicator(server);
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new CommunicationException();
            }
        }

        return communicator;
    }
}
