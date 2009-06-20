/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.imagelabeler.client.ui;

import br.ita.ces31.imagelabeler.client.ui.screen.WaitScreen;

/**
 *
 * @author diego
 */
public class WaitUI extends UserInterface {
    private WaitScreen screen;

    public WaitUI(WaitScreen screen) {
        setScreen(screen);
        getScreen().setWaitUI(this);
    }

    //Button Cancel Action
    public void cancel(){
        UserInterface.getController().cancel();
    }

    public void setActive(boolean active){
        getScreen().setActive(active);
    }

    public WaitScreen getScreen(){
        return screen;
    }

    public void setScreen(WaitScreen screen) {
        this.screen = screen;
    }
}
