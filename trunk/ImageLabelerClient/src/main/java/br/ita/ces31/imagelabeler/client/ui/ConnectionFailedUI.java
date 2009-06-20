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
        getScreen().setConnectionFailedUI(this);
    }

    //Button Ok Action
    public void ok(){
        UserInterface.getController().ok();
    }

    public void setActive(boolean active){
        getScreen().setActive(active);
    }

    public ConnectionFailedScreen getScreen(){
        return screen;
    }

    public void setScreen(ConnectionFailedScreen screen){
        this.screen = screen;
    }
}