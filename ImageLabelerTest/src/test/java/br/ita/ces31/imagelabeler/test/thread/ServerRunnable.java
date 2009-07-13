/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ita.ces31.imagelabeler.test.thread;

import br.ita.ces31.imagelabeler.server.ServerMain;

/**
 *
 * @author diego
 */
public class ServerRunnable implements Runnable{
    private boolean done = false;

    public void done(){
        done = true;
    }

    public void run() {
                    System.out.println("OIIII");
        ServerMain.main(new String[1]);
            System.out.println("OIIII");
        while(!done){
            System.out.println("OIIII");
        }
    }
}
