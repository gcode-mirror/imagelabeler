/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.imagelabeler.client.screen;

/**
 *
 * @author diego
 */
public interface GameScreen extends Screen{
    public void ProcessLabelMatch(String match, int score);

    public int getRegressiveCounting();

    public void updateRegressiveCounting(int miliseconds);

    public void setGameImage(String image);

    public void setPlayer1Name(String player1Name);

    public void setPlayer2Name(String player2Name);
}
