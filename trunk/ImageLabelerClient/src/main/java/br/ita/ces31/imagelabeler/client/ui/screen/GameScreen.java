/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.imagelabeler.client.ui.screen;

import br.ita.ces31.imagelabeler.client.ui.GameUI;
import javax.swing.ImageIcon;

/**
 *
 * @author diego
 */
public interface GameScreen {

    public void setGameUI(GameUI gameUI);
    public void ProcessLabelMatch(String match, int score);
    public int getRegressiveCounting();
    public void updateRegressiveCounting(int currentCounting);
    public int getImagePanelHeight();
    public int getImagePanelWidth();
    public void setGameImage(ImageIcon image);
    public void setPlayer1Name(String player1Name);
    public void setPlayer2Name(String player2Name);
    public void setActive(boolean active);
}
