/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.imagelabeler.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Helder Suzuki <helder@aluno.ita.br>
 */
public class GameSummary implements Serializable{

    private int score;
    private ArrayList<Player> topPlayers;
    private ArrayList<String> matches;

    public GameSummary() {
        this.score = 0;
        this.topPlayers = new ArrayList<Player>();
        this.matches = new ArrayList<String>();
    }

    /**
     *
     * @param score
     * @param topPlayers
     * @param matches
     */
    public GameSummary(int score, ArrayList<Player> topPlayers,
            ArrayList<String> matches) {
        this.score = score;
        this.topPlayers = topPlayers;
        this.matches = matches;
    }

    /**
     * Score da partida.
     * @return
     */
    public int getScore() {
        return this.score;
    }

    /**
     * Ranking com top players.
     * @return
     */
    public List<Player> getTopPlayers() {
        return this.topPlayers;
    }

    /**
     * Matches ocorridos na partida.
     * @return
     */
    public List<String> getMatches() {
        return this.matches;
    }
}
