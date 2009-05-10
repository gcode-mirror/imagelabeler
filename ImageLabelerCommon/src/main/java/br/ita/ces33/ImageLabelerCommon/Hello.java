/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ita.ces33.ImageLabelerCommon;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Helder Suzuki <helder@aluno.ita.br>
 */
public interface Hello extends Remote{
    String sayHello() throws RemoteException;
}
