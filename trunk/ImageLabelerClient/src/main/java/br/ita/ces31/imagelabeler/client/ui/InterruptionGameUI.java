/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.imagelabeler.client.ui;

import br.ita.ces31.imagelabeler.client.ui.screen.InterruptionGameScreen;

/**
 *
 * @author diego
 */
public class InterruptionGameUI extends UserInterface {
    private InterruptionGameScreen screen;

    public InterruptionGameUI(InterruptionGameScreen screen) {
        setScreen(screen);
        controller.setInterruptionGameUI(this);
    }

    public void playAgain() {
        InterruptionGameUI.controller.playAgain();
    }

    public void exit() {
        InterruptionGameUI.controller.exit();
    }

    public void setVisible(boolean visible){
        this.screen.setVisible(visible);
    }

    public void setScreen(InterruptionGameScreen screen){
        this.screen = screen;
    }
}
