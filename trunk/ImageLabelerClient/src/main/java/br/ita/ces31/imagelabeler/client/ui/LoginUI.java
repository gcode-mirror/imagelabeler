/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.imagelabeler.client.ui;

import br.ita.ces31.imagelabeler.client.ui.screen.LoginScreen;

/**
 *
 * @author diego
 */
public class LoginUI extends UserInterface {
    private LoginScreen screen;

    public LoginUI(LoginScreen screen) {
        setScreen(screen);
        UserInterface.getController().setLoginUI(this);
    }

    //Button Identify Action
    public void identify(String loginName) {
        UserInterface.getController().identify(loginName);
    }

    //Button Exit Action
    public void exit() {
        UserInterface.getController().exit();
    }

    public void setActive(boolean active){
        getScreen().setVisible(active);
    }

    public LoginScreen getScreen(){
        return screen;
    }
    
    public void setScreen(LoginScreen screen){
        this.screen = screen;
    }
}
