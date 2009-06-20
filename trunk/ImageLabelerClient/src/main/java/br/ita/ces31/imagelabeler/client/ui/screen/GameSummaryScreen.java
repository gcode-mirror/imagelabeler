/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.imagelabeler.client.ui.screen;

import br.ita.ces31.imagelabeler.client.ui.GameSummaryUI;
import br.ita.ces31.imagelabeler.common.Player;
import java.util.List;

/**
 *
 * @author diego
 */
public interface GameSummaryScreen {
    public void setGameSummaryUI(GameSummaryUI gameSummaryUI);
    public void setRank(List<Player> topPlayers);
    public void setMatchedLabelsList(List<String> matchedLabels);
    public void setFinalPontuation(int finalScore);
    public void setPlayerName(String playerName);
    public void setActive(boolean active);
}
