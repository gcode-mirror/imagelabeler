/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.ImageLabelerCommon;

import java.io.Serializable;

/**
 *
 * @author Helder Suzuki <helder@aluno.ita.br>
 */
public class Player implements Serializable {

    private String name;
    private int score;

    public Player(String name) {
        this.name = name;
    }

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }

    public boolean equals(Player p) {
        return name.equals(p.getName());
    }
}
