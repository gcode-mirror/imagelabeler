/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.ImageLabelerCommon;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Helder Suzuki <helder@aluno.ita.br>
 */
public class GameSummary {

    private int score;
    private List<Player> topPlayers;
    private List<String> matches;

    public GameSummary() {
        this.score = 0;
        this.topPlayers = new ArrayList<Player>();
        this.matches = new ArrayList<String>();
    }

    public GameSummary(int score, List<Player> topPlayers,
            List<String> matches) {
        this.score = score;
        this.topPlayers = topPlayers;
        this.matches = matches;
    }

    public int getScore() {
        return this.score;
    }

    public List<Player> getTopPlayers() {
        return this.topPlayers;
    }

    public List<String> getMatches() {
        return this.matches;
    }
}
