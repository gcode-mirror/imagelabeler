/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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

    @Override
    public void playAgain() {
        InterruptionGameUI.controller.playAgain();
    }

    @Override
    public void exit() {
        InterruptionGameUI.controller.exit();
    }

    @Override
    public void setVisible(boolean visible){
        this.screen.setVisible(visible);
    }

    public void setScreen(InterruptionGameScreen screen){
        this.screen = screen;
    }
}
