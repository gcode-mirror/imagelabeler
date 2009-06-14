/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ita.ces31.ImageLabelerClient.ui;

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
    
    @Override
    public void ok() {
        ServerBusyUI.controller.ok();
    }

    @Override
    public void setVisible(boolean visible){
        this.screen.setVisible(visible);
    }

    public void setScreen(ServerBusyScreen screen) {
        this.screen = screen;
    }
}
