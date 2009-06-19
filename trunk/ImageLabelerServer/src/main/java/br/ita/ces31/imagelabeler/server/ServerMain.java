/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.imagelabeler.server;

import br.ita.ces31.imagelabeler.common.Server;
import java.rmi.Naming;
import java.rmi.RemoteException;

/**
 *
 * @author Helder Suzuki <helder@aluno.ita.br>
 */
public class ServerMain {

    /**
     * Ponto de partida do servidor.
     * @param args
     */
    public static void main(String args[]) {
        try {
            Server server = ServerSingleton.getServer();
            java.rmi.registry.LocateRegistry.createRegistry(Server.serverPort);
            Naming.rebind(Server.referenceName, server);
        } catch (java.net.MalformedURLException e) {
            System.out.println("Malformed URL for helloServer " + e.toString());
        } catch (RemoteException e) {
            System.out.println("Communication error " + e.toString());
        }
        System.out.println("Server started");
    }
}
