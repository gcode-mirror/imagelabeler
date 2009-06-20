/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.imagelabeler.client.ui;

import br.ita.ces31.imagelabeler.client.controller.Controller;

/**
 *
 * @author diego
 */
public abstract class UserInterface {
    protected static Controller controller;
    public abstract void setActive(boolean active);
    
    public static void setController(Controller controller) {
        UserInterface.controller = controller;
    }

    public static Controller getController(){
        return UserInterface.controller;
    }
}
