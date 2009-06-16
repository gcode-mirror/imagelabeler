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
        controller.setGameUI(this);
    }

    public void sendLabel(String label) {
        GameUI.controller.sendLabel(label);
    }

    public void penico() {
        GameUI.controller.penico();
    }

    public void notifyMatch(String match, int score){
        this.screen.ProcessMatch(match, score);
    }

    public void setVisible(boolean visible){
        this.screen.setVisible(visible);
    }

    public void setScreen(GameScreen screen){
        this.screen = screen;
    }

    public int getRegressiveCounting(){
        return Integer.parseInt(this.screen.getLblRegressiveCounting());
    }

    public void updateRegressiveCounting(){
        int pastCounting = Integer.parseInt(this.screen.getLblRegressiveCounting());
        int currentCounting = pastCounting - 1;
        this.screen.setLblRegressiveCounting(String.valueOf(currentCounting));
    }
    
    public void setImage(String image){

        String imagePath = "pictures" + File.separator + image;
        URL imgURL = ClassLoader.getSystemResource(imagePath);

        ImageIcon imageIcon = null;
        if (imgURL != null) {
            imageIcon = new ImageIcon(imgURL);

            int h = this.screen.getPnlImage().getHeight();
            int w = this.screen.getPnlImage().getWidth();
            this.screen.getLblImage().setIcon(new ImageIcon(getScaledImage(imageIcon.getImage(), w, h)));
        } else {
            System.out.println(imagePath);
        }
    }

     /**
     * Resizes an image using a Graphics2D object backed by a BufferedImage.
     * @param srcImg - source image to scale
     * @param w - desired width
     * @param h - desired height
     * @return - the new resized image
     */
    private Image getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = resizedImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();
        return resizedImg;
    }

    public void setPlayer1Name(String player1Name){
        this.screen.setLblPlayer1(player1Name);
    }

    public void setPlayer2Name(String player2Name){
        this.screen.setLblPlayer2(player2Name);
    }
}
