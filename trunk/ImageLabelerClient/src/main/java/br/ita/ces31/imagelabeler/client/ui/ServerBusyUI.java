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
        UserInterface.getController().setServerBusyUI(this);
    }

    //Button Ok Action
    public void ok() {
        UserInterface.getController().ok();
    }

    public void setActive(boolean active){
        getScreen().setActive(active);
    }

    public ServerBusyScreen getScreen(){
        return screen;
    }

    public void setScreen(ServerBusyScreen screen) {
        this.screen = screen;
    }
}
