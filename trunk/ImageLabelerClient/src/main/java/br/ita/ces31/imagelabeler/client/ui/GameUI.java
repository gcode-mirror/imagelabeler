/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.imagelabeler.client.ui;

import br.ita.ces31.imagelabeler.client.ui.screen.GameScreen;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author diego
 */
public class GameUI extends UserInterface {

    private GameScreen screen;

    public GameUI(GameScreen screen) {
        setScreen(screen);
        UserInterface.getController().setGameUI(this);
    }

    //Send label Action
    public void sendLabel(String label) {
        UserInterface.getController().sendLabel(label);
    }

    //Button Penico Action
    public void penico() {
        UserInterface.getController().penico();
    }

    public void notifyLabelMatch(String match, int score) {
        getScreen().ProcessLabelMatch(match, score);
    }

    public void setPlayer1Name(String player1Name) {
        getScreen().setPlayer1Name(player1Name);
    }

    public void setPlayer2Name(String player2Name) {
        getScreen().setPlayer2Name(player2Name);
    }

    public int getRegressiveCounting() {
        return getScreen().getRegressiveCounting();
    }

    public void updateRegressiveCounting(int miliseconds) {
        int currentCounting = getRegressiveCounting() - miliseconds / 1000;
        getScreen().updateRegressiveCounting(currentCounting);
    }

    public void setGameImage(String image) {
        ClassLoader loader = getClass().getClassLoader();
        String imagePath = "pictures" + File.separator + image;
        String imagePath2 = "/pictures/" + image;

        URL imgURL = loader.getResource(imagePath);
        if (imgURL == null) {
            imgURL = this.getClass().getResource(imagePath2);
        }

        ImageIcon imageIcon = null;
        if (imgURL != null) {
            imageIcon = new ImageIcon(imgURL);

            int h = getScreen().getImagePanelHeight();
            int w = getScreen().getImagePanelWidth();

            getScreen().setGameImage(new ImageIcon(getScaledImage(imageIcon.getImage(), w, h)));
        } else {
        //LANÇAR EXCEÇÃO AQUI
        }
    }

    /**
     * Resizes an image using a Graphics2D object backed by a BufferedImage.
     * @param srcImg - source image to scale
     * @param w - desired width
     * @param h - desired height
     * @return - the new resized image
     */
    private Image getScaledImage(Image srcImg, int w, int h) {
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = resizedImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();
        return resizedImg;
    }

    public void setActive(boolean active) {
        getScreen().setActive(active);
    }

    public GameScreen getScreen() {
        return screen;
    }

    public void setScreen(GameScreen screen) {
        this.screen = screen;
    }
}
