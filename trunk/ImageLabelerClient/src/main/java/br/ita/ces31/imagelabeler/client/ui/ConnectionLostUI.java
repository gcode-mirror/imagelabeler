/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ita.ces31.imagelabeler.client.ui;

import br.ita.ces31.imagelabeler.client.ui.screen.ConnectionLostScreen;

/**
 *
 * @author diego
 */
public class ConnectionLostUI extends UserInterface {
    private ConnectionLostScreen screen;

    public ConnectionLostUI(ConnectionLostScreen screen) {
        setScreen(screen);
        controller.setConnectionLostUI(this);
    }

    public void ok(){
        ConnectionLostUI.controller.ok();
    }

    public void setVisible(boolean visible){
        this.screen.setVisible(visible);
    }

    public void setScreen(ConnectionLostScreen screen) {
        this.screen = screen;
    }
}
