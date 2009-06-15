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
        controller.setWaitUI(this);
    }

    public void cancel(){
        WaitUI.controller.cancel();
    }

    public void setVisible(boolean visible){
        this.screen.setVisible(visible);
    }

    public void setScreen(WaitScreen screen) {
        this.screen = screen;
    }
}
