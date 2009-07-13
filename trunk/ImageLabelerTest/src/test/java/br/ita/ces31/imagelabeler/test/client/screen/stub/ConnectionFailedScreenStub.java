/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ita.ces31.imagelabeler.test.client.screen.stub;

import br.ita.ces31.imagelabeler.client.controller.Controller;
import br.ita.ces31.imagelabeler.client.screen.ConnectionFailedScreen;

/**
 *
 * @author diego
 */
public class ConnectionFailedScreenStub implements ConnectionFailedScreen{
    private Controller controller;

    public ConnectionFailedScreenStub(){
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
