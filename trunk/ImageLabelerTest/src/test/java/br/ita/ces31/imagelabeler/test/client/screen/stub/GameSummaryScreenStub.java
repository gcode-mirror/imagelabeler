/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ita.ces31.imagelabeler.test.client.screen.stub;

import br.ita.ces31.imagelabeler.client.controller.Controller;
import br.ita.ces31.imagelabeler.client.screen.GameSummaryScreen;
import br.ita.ces31.imagelabeler.common.Player;
import java.util.List;

/**
 *
 * @author diego
 */
public class GameSummaryScreenStub implements GameSummaryScreen{
    private Controller controller;

    public GameSummaryScreenStub(){
    }

    public void setActive(boolean isActive) {
        if (isActive){
        }
    }

    public void setFinalPontuation(int finalScore) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setMatchedLabelsList(List<String> matchedLabels) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setPlayerName(String playerName) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setRank(List<Player> topPlayers) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public Controller getController() {
        return this.controller;
    }
}
