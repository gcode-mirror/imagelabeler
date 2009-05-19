/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.ImageLabelerServer;

import br.ita.ces31.ImageLabelerCommon.Client;
import br.ita.ces31.ImageLabelerServer.scorer.ScoreCalculator;
import java.util.List;

/**
 *
 * @author Helder Suzuki <helder@aluno.ita.br>
 */
public class Game {

    public static int duration = 100;
    private List<String> labels;
    private List<String> matches;
    private int score;
    private ScoreCalculator scorer;
    private Client client1,  client2;

    public Game(ScoreCalculator scorer, Client player1, Client player2) {
        this.scorer = scorer;
        this.client1 = player1;
        this.client2 = player2;
        this.score = 0;
    }

    private void addMatch(String match) {
        if (!matches.contains(match)) {
            matches.add(match);
            this.score += scorer.calculateScore(match);
        }
    }

    public boolean addLabel(String label) {
        if (labels.contains(label)) {
            addMatch(label);
            return true;
        }

        labels.add(label);
        return false;
    }

    /**
     * @return the matches
     */
    public List<String> getMatches() {
        return matches;
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @return the player1
     */
    public Client getClient1() {
        return client1;
    }

    /**
     * @return the player2
     */
    public Client getClient2() {
        return client2;
    }
}
