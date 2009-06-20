/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.imagelabeler.client.ui;

import br.ita.ces31.imagelabeler.client.ui.screen.GameSummaryScreen;
import br.ita.ces31.imagelabeler.common.Player;
import java.util.List;

/**
 *
 * @author diego
 */
public class GameSummaryUI extends UserInterface {
    private GameSummaryScreen screen;

    public GameSummaryUI(GameSummaryScreen screen) {
        setScreen(screen);
        getScreen().setGameSummaryUI(this);
    }

    //Button "Play again" Action
    public void playAgain() {
        UserInterface.getController().playAgain();
    }

    //Button Exit Action
    public void exit() {
        UserInterface.getController().exit();
    }

    public void setRank(List<Player> topPlayers){
        getScreen().setRank(topPlayers);
    }

    public void setMatchedLabelsList(List<String> matchedLabels){
        getScreen().setMatchedLabelsList(matchedLabels);
    }

    public void setFinalPontuation(int finalScore){
        getScreen().setFinalPontuation(finalScore);
    }

    public void setPlayerName(String playerName){
        getScreen().setPlayerName(playerName);
    }

    public void setActive(boolean active){
        getScreen().setActive(active);
    }

    public GameSummaryScreen getScreen(){
        return screen;
    }

    public void setScreen(GameSummaryScreen screen){
        this.screen = screen;
    }
}
