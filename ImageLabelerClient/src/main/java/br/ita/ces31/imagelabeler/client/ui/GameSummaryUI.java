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
        controller.setGameSummaryUI(this);
    }

    public void playAgain() {
        GameSummaryUI.controller.playAgain();
    }

    public void exit() {
        GameSummaryUI.controller.exit();
    }

    public void setRank(List<Player> topPlayers){
        this.screen.setRank(topPlayers);
    }

    public void setListMatchedLabels(List<String> matchedLabels){
        this.screen.setListMatchedLabels(matchedLabels);
    }

    public void setFinalPontuation(int finalScore){
        this.screen.setFinalPontuation(finalScore);
    }

    public void setPlayerName(String playerName){
        this.screen.setPlayerName(playerName);
    }

    public void setVisible(boolean visible){
        this.screen.setVisible(visible);
    }

    public void setScreen(GameSummaryScreen screen){
        this.screen = screen;
    }
}
