/*
 * Image Labeler - Projeto de CES-31
 */

package br.ita.ces33.ImageLabelerCommon;

import java.util.List;

/**
 *
 * @author Helder Suzuki <helder@aluno.ita.br>
 */
public interface GameSummary {
    public String getPlayerOneName();
    public List<String> getPlayerOneGuesses();
    public String getPlayerTwoName();
    public List<String> getPlayerTwoGuesses();
    public int getPoints();
    public List<RankEntry> getTopPlayers();
}
