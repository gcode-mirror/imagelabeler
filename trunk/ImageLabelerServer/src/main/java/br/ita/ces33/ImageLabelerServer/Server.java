/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ita.ces33.ImageLabelerServer;

import br.ita.ces33.ImageLabelerCommon.Hello;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Helder Suzuki <helder@aluno.ita.br>
 */
public class Server extends UnicastRemoteObject implements Hello {

    public Server() throws RemoteException {
    }

    public String sayHello() {
        System.out.println("Returning message Hello");
        return "Hello, world!";
    }

    public static void main(String args[]) {
        System.out.println(" Codebase: " + System.getProperty("java.rmi.server.codebase"));
        try {
            Server helloServer = new Server();
            
            java.rmi.registry.LocateRegistry.createRegistry (1099);
            Naming.rebind("Hello", helloServer);
        } catch (java.net.MalformedURLException e) {
            System.out.println("Malformed URL for helloServer " + e.toString());
        } catch (RemoteException e) {
            System.out.println("Communication error " + e.toString());
        }
    }
}
