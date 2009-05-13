/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.ImageLabelerServer;

import br.ita.ces31.ImageLabelerCommon.GameServer;
import java.rmi.Naming;
import java.rmi.RemoteException;

/**
 *
 * @author Helder Suzuki <helder@aluno.ita.br>
 */
public class ServerMain{

    public static void main(String args[]) {
        System.out.println(" Codebase: " + System.getProperty("java.rmi.server.codebase"));
        try {
            GameServer server = new GameServerImpl(); 
            java.rmi.registry.LocateRegistry.createRegistry (1099);
            Naming.rebind(GameServer.referenceName, server);
        } catch (java.net.MalformedURLException e) {
            System.out.println("Malformed URL for helloServer " + e.toString());
        } catch (RemoteException e) {
            System.out.println("Communication error " + e.toString());
        }
        System.out.println("Teste");
    }
}
