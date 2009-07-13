/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ita.ces31.imagelabeler.test.client.screen.stub;

import br.ita.ces31.imagelabeler.client.controller.Controller;
import br.ita.ces31.imagelabeler.client.screen.LoginScreen;

/**
 *
 * @author diego
 */
public class LoginScreenStub implements LoginScreen{
    private Controller controller;

    public LoginScreenStub(){
    }

    public void setActive(boolean isActive) {
        if (isActive){
            System.out.println("LOGIN");
        }
    }
    
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public Controller getController() {
        return this.controller;
    }
}
