/*
 * Image Labeler - Projeto de CES-31
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
        UserInterface.getController().setConnectionLostUI(this);
    }

    //Button Ok Action
    public void ok(){
        UserInterface.getController().ok();
    }

    public void setActive(boolean active){
        getScreen().setVisible(active);
    }

    public ConnectionLostScreen getScreen(){
        return screen;
    }

    public void setScreen(ConnectionLostScreen screen){
        this.screen = screen;
    }
}
