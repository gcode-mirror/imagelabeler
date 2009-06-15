/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
        controller.setLoginUI(this);
    }

    public void identify(String loginName) {
        LoginUI.controller.identify(loginName);
    }

    public void exit() {
        LoginUI.controller.exit();
    }

    public void setVisible(boolean visible){
        this.screen.setVisible(visible);
    }

    public void setScreen(LoginScreen screen){
        this.screen = screen;
    }
}
