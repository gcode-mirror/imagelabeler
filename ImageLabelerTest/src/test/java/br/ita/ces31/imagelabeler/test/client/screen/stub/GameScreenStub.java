/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ita.ces31.imagelabeler.test.client.screen.stub;

import br.ita.ces31.imagelabeler.client.controller.Controller;
import br.ita.ces31.imagelabeler.client.screen.GameScreen;
import java.util.MissingResourceException;

/**
 *
 * @author diego
 */
public class GameScreenStub implements GameScreen{
    private Controller controller;

    public GameScreenStub(){
    }

    public void setActive(boolean isActive) {
        if (isActive){
        }
    }

    public void ProcessLabelMatch(String match, int score) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getRegressiveCounting() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setGameImage(String imageFileName) throws MissingResourceException {
        System.out.println(imageFileName);
    }

    public void setPlayer1Name(String player1Name) {
        System.out.println(player1Name);
    }

    public void setPlayer2Name(String player2Name) {
        System.out.println(player2Name);
    }

    public void updateRegressiveCounting(int miliseconds) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public Controller getController() {
        return this.controller;
    }
}
