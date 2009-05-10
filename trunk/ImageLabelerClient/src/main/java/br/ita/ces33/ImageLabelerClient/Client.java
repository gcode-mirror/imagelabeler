/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ita.ces33.ImageLabelerClient;

import br.ita.ces33.ImageLabelerCommon.Hello;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Helder Suzuki <helder@aluno.ita.br>
 */
public class Client {

    private Client() {
    }

    public static void main(String[] args) {

        String host = (args.length < 1) ? null : args[0];
        Registry registry;
        try {
            registry = LocateRegistry.getRegistry(host);
            Hello stub = (Hello) registry.lookup("Hello");
            String response = stub.sayHello();
            System.out.println("response: " + response);
        } catch (RemoteException ex) {
            System.err.println("Não foi possível conectar: " + ex.toString());
            ex.printStackTrace();
        } catch (NotBoundException ex){
            System.err.println("Client exception: " + ex.toString());
            ex.printStackTrace();
        }
        
    }
}
