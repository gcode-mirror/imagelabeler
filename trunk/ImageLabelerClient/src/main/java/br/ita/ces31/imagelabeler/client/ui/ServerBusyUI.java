/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.imagelabeler.client.ui;

import br.ita.ces31.imagelabeler.client.ui.screen.ServerBusyScreen;

/**
 *
 * @author diego
 */
public class ServerBusyUI extends UserInterface {
    private ServerBusyScreen screen;

    public ServerBusyUI(ServerBusyScreen screen) {
        setScreen(screen);
        controller.setServerBusyUI(this);
    }
    
    public void ok() {
        ServerBusyUI.controller.ok();
    }

    public void setVisible(boolean visible){
        this.screen.setVisible(visible);
    }

    public void setScreen(ServerBusyScreen screen) {
        this.screen = screen;
    }
}
