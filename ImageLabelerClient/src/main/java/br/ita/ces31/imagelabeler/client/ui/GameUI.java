/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ita.ces31.imagelabeler.client.ui;

import br.ita.ces31.imagelabeler.client.ui.screen.GameScreen;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
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

    @Override
    public void sendLabel() {
        GameUI.controller.sendLabel();
    }

    @Override
    public void penico() {
        GameUI.controller.penico();
    }

    @Override
    public void setVisible(boolean visible){
        this.screen.setVisible(visible);
    }

    public void setScreen(GameScreen screen){
        this.screen = screen;
    }

    public void setImage(String image){
        //ImageIcon imageIcon = new ImageIcon(image);
        ImageIcon imageIcon = new ImageIcon("D:\\pictures\\Fotos\\humberto.jpg");
        int h = this.screen.getPnlImage().getHeight();
        int w = this.screen.getPnlImage().getWidth();
        this.screen.getLblImage().setIcon(new ImageIcon(getScaledImage(imageIcon.getImage(), w, h)));
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

    public String getPlayer1(){
        return this.screen.getLblPlayer1();
    }

    public String getPlayer2(){
        return this.screen.getLblPlayer2();
    }

    public void setPlayer1Name(String player1Name){
        this.screen.setLblPlayer1(player1Name);
    }

    public void setPlayer2Name(String player2Name){
        this.screen.setLblPlayer2(player2Name);
    }
}
