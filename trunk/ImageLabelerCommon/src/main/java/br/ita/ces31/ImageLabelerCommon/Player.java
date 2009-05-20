/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.ImageLabelerCommon;

import java.io.Serializable;

/**
 *
 * @author Helder Suzuki <helder@aluno.ita.br>
 */
public class Player implements Serializable, Comparable {

    private String name;
    private int score;

    public Player(Player p) {
        this.name = p.name;
        this.score = p.score;
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

    public int compareTo(Player p) {
        if (this.score < p.score) {
            return 1;
        }
        if (this.score > p.score) {
            return -1;
        }
        return 0;
    }

    public int compareTo(Object o) {
        Player p = (Player) o;
        return compareTo(p);
    }

    @Override
    public boolean equals(Object o) {
        Player p = (Player) o;
        return (name.equals(p.getName()) && score == p.getScore());
    }

    @Override
    public String toString() {
        return "Player(" + name + ", " + score + ")";
    }
}
