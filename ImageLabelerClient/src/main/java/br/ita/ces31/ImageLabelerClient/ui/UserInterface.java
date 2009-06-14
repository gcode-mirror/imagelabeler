/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ita.ces31.ImageLabelerClient.ui;

import br.ita.ces31.ImageLabelerClient.ui.Controller.Controller;

/**
 *
 * @author diego
 */
public abstract class UserInterface {
    
    protected static Controller controller;

    public void ok(){
        throw new UnsupportedOperationException("Operation not supported!");
    }

    public void exit(){
        throw new UnsupportedOperationException("Operation not supported!");
    }

    public void cancel(){
        throw new UnsupportedOperationException("Operation not supported!");
    }

    public void playAgain(){
        throw new UnsupportedOperationException("Operation not supported!");
    }

    public void penico(){
        throw new UnsupportedOperationException("Operation not supported!");
    }

    public void sendLabel(){
        throw new UnsupportedOperationException("Operation not supported!");
    }

    public void identify(String loginName){
        throw new UnsupportedOperationException("Operation not supported!");
    }

    public void setVisible(boolean visible){
        throw new UnsupportedOperationException("Operation not supported!");
    }

    public static void setController(Controller controller) {
        UserInterface.controller = controller;
    }

    public static Controller getController() {
        return controller;
    }
}
