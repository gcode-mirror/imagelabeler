/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ita.ces31.ImageLabelerClient.ui;

import br.ita.ces31.imagelabeler.client.ui.screen.ConnectionFailedScreen;

/**
 *
 * @author diego
 */
public class ConnectionFailedUI extends UserInterface {
    private ConnectionFailedScreen screen;

    public ConnectionFailedUI(ConnectionFailedScreen screen) {
        setScreen(screen);
        controller.setConnectionFailedUI(this);
    }

    @Override
    public void ok(){
        ConnectionFailedUI.controller.ok();
    }

    @Override
    public void setVisible(boolean visible){
        this.screen.setVisible(visible);
    }

    public void setScreen(ConnectionFailedScreen screen) {
        this.screen = screen;
    }
}