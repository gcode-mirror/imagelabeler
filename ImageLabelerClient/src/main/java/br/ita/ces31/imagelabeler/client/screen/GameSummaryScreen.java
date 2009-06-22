/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.imagelabeler.client.screen;

import br.ita.ces31.imagelabeler.common.Player;
import java.util.List;

/**
 *
 * @author diego
 */
public interface GameSummaryScreen extends Screen{
    public void setRank(List<Player> topPlayers);

    public void setMatchedLabelsList(List<String> matchedLabels);

    public void setFinalPontuation(int finalScore);

    public void setPlayerName(String playerName);
}
