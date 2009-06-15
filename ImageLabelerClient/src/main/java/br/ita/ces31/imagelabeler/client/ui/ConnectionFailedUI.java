/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.imagelabeler.client.ui;

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

    public void ok(){
        ConnectionFailedUI.controller.ok();
    }

    public void setVisible(boolean visible){
        this.screen.setVisible(visible);
    }

    public void setScreen(ConnectionFailedScreen screen) {
        this.screen = screen;
    }
}