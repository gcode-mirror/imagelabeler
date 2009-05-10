/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ita.ces33.ImageLabelerClient;

import br.ita.ces33.ImageLabelerCommon.Hello;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author helder
 */
public class Client {

    private Client() {
    }

    public static void main(String[] args) {

        String host = (args.length < 1) ? null : args[0];
        try {
            Registry registry = LocateRegistry.getRegistry(host);
            Hello stub = (Hello) registry.lookup("Hello");
            String response = stub.sayHello();
            System.out.println("response: " + response);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
