/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ita.ces31.imagelabeler.test.client.screen.stub;

import br.ita.ces31.imagelabeler.client.controller.Controller;
import br.ita.ces31.imagelabeler.client.screen.ServerBusyScreen;

/**
 *
 * @author diego
 */
public class ServerBusyScreenStub implements ServerBusyScreen{
    private Controller controller;

    public ServerBusyScreenStub(){
    }

    public void setActive(boolean isActive) {
        if (isActive){
        }
    }
    
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public Controller getController() {
        return this.controller;
    }
}
