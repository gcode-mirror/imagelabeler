/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ita.ces31.imagelabeler.client.ui;

import br.ita.ces31.imagelabeler.client.ui.screen.SummaryGameScreen;

/**
 *
 * @author diego
 */
public class SummaryGameUI extends UserInterface {
    private SummaryGameScreen screen;

    public SummaryGameUI(SummaryGameScreen screen) {
        setScreen(screen);
        controller.setSummaryGameUI(this);
    }

    public void playAgain() {
        SummaryGameUI.controller.playAgain();
    }

    public void exit() {
        SummaryGameUI.controller.exit();
    }

    public void setVisible(boolean visible){
        this.screen.setVisible(visible);
    }

    public void setScreen(SummaryGameScreen screen){
        this.screen = screen;
    }
}
