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
        getScreen().setInterruptionGameUI(this);
    }

    //Button "Play again" Action
    public void playAgain() {
        UserInterface.getController().playAgain();
    }

    //Button Exit Action
    public void exit() {
        UserInterface.getController().exit();
    }

    @Override
    public void setActive(boolean active){
        getScreen().setActive(active);
    }

    public InterruptionGameScreen getScreen(){
        return screen;
    }

    public void setScreen(InterruptionGameScreen screen){
        this.screen = screen;
    }
}
