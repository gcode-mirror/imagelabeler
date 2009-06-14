/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.imagelabeler.server;

import br.ita.ces31.imagelabeler.common.Client;
import br.ita.ces31.imagelabeler.server.scorer.ScoreCalculator;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Helder Suzuki <helder@aluno.ita.br>
 */
public class Game {

    /**
     * Duração da partida em segundos.
     */
    public static int duration = 70;
    private List<String> labels;
    private List<String> matches;
    private int score;
    private ScoreCalculator scorer;
    private Client client1,  client2;

    /**
     * Cria instância de Game.
     * @param scorer
     * @param player1
     * @param player2
     */
    public Game(ScoreCalculator scorer, Client player1, Client player2) {
        this.scorer = scorer;
        this.client1 = player1;
        this.client2 = player2;
        this.score = 0;
        this.labels = new ArrayList<String>();
        this.matches = new ArrayList<String>();
    }

    private boolean addMatch(String match) {
        if (!matches.contains(match)) {
            matches.add(match);
            this.score += scorer.calculateScore(match);
            
            return true;
        }
        return false;
    }

    /**
     * Caso de uso 1.4.2.2.1 c) Identificar Rótulo
     * Registra rótulo na partida.
     * @param label
     * @return
     */
    public boolean addLabel(String label) {
        if (labels.contains(label)) {
            return addMatch(label);
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
