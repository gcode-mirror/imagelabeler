/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.imagelabeler.client.screen.swing;

import br.ita.ces31.imagelabeler.client.controller.Controller;
import br.ita.ces31.imagelabeler.client.screen.*;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.MissingResourceException;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author diego
 */
public class GameScreenSwing extends javax.swing.JFrame implements GameScreen {
    private Controller controller;

    public GameScreenSwing() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPlayersInThisGame = new javax.swing.JLabel();
        lblPlayer1 = new javax.swing.JLabel();
        lblAnd = new javax.swing.JLabel();
        lblPlayer2 = new javax.swing.JLabel();
        pnlImage = new javax.swing.JPanel();
        lblImage = new javax.swing.JLabel();
        lblLetsLabel = new javax.swing.JLabel();
        txtLabel = new javax.swing.JTextField();
        pnlTypedLabels = new javax.swing.JScrollPane();
        typedLabelsElements = new DefaultListModel();
        listTypedLabels = new javax.swing.JList(typedLabelsElements);
        pnlMatchedLabels = new javax.swing.JScrollPane();
        matchedLabelsElements = new DefaultListModel();
        listMatchedLabels = new javax.swing.JList(matchedLabelsElements);
        lblPoints = new javax.swing.JLabel();
        lblTimeRemaining = new javax.swing.JLabel();
        lblMatches = new javax.swing.JLabel();
        lblScore = new javax.swing.JLabel();
        lblRegressiveCounting = new javax.swing.JLabel();
        lblSeconds = new javax.swing.JLabel();
        btnPenico = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Image Labeler");

        lblPlayersInThisGame.setText("Players in this game:");

        lblPlayer1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        lblAnd.setText("and");

        lblPlayer2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        pnlImage.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout pnlImageLayout = new javax.swing.GroupLayout(pnlImage);
        pnlImage.setLayout(pnlImageLayout);
        pnlImageLayout.setHorizontalGroup(
            pnlImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
        );
        pnlImageLayout.setVerticalGroup(
            pnlImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
        );

        lblLetsLabel.setText("Let's Label!");

        txtLabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLabelActionPerformed(evt);
            }
        });

        listTypedLabels.setEnabled(false);
        pnlTypedLabels.setViewportView(listTypedLabels);

        listMatchedLabels.setEnabled(false);
        pnlMatchedLabels.setViewportView(listMatchedLabels);

        lblPoints.setText("Points:");

        lblTimeRemaining.setText("Time remaining:");

        lblMatches.setText("Matches");

        lblScore.setText("0");

        lblRegressiveCounting.setText("0");

        lblSeconds.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSeconds.setText("s");

        btnPenico.setText("Penico");
        btnPenico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPenicoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(pnlImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlTypedLabels, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblPoints)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblScore))
                            .addComponent(lblLetsLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTimeRemaining)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblRegressiveCounting)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblSeconds))
                            .addComponent(txtLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblPlayersInThisGame)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPlayer1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblAnd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPlayer2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblMatches, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlMatchedLabels, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                    .addComponent(btnPenico))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPlayersInThisGame)
                            .addComponent(lblPlayer1)
                            .addComponent(lblAnd)
                            .addComponent(lblPlayer2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblLetsLabel)
                                    .addComponent(lblMatches))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(txtLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(pnlTypedLabels, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(pnlMatchedLabels, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lblTimeRemaining)
                                            .addComponent(lblSeconds)
                                            .addComponent(lblRegressiveCounting, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(btnPenico)))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPoints)
                            .addComponent(lblScore))
                        .addGap(31, 31, 31))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtLabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLabelActionPerformed
        if ( typedLabelValidation(getTxtLabel().getText())){
            sendLabel(getTxtLabel().getText());
            addElementOnTypedLabelsList(getTxtLabel().getText().toLowerCase());
        }

        clearTextField();
    }//GEN-LAST:event_txtLabelActionPerformed

    private void btnPenicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPenicoActionPerformed
        getController().penico();
    }//GEN-LAST:event_btnPenicoActionPerformed

    private boolean typedLabelValidation(String typedLabel){
        if(isLabelAlreadyTypedByPlayer(typedLabel)){
            return false;
        } else {
            return true;
        }
    }

    private boolean isLabelAlreadyTypedByPlayer(String typedLabel){
        if (getTypedLabelsElements().contains(typedLabel)){
            return true;
        } else {
            return false;
        }
    }

    private void sendLabel(String label){
        getController().sendLabel(label);
    }

    private void addElementOnTypedLabelsList(String label){
        getTypedLabelsElements().addElement(label);
    }

    private void clearTextField(){
        getTxtLabel().setText("");
    }

    @Override
    public void ProcessLabelMatch(String match, int score){
        addElementOnMatchedLabelsList(match.toLowerCase());
        updateScore(score);
    }

    private void addElementOnMatchedLabelsList(String label){
        getMatchedLabelsElements().addElement(label);
    }

    private void updateScore(int score){
        setLblPointsAmmount(score);
    }

    @Override
    public int getRegressiveCounting(){
        return Integer.parseInt(getLblRegressiveCounting());
    }

    @Override
    public void updateRegressiveCounting(int miliseconds){
        int currentCounting = getRegressiveCounting() - miliseconds / 1000;

        if(currentCounting == 0) {
            txtLabel.setText("");
            txtLabel.setEnabled(false);
        }

        setLblRegressiveCounting(String.valueOf(currentCounting));
    }

    @Override
    public void setGameImage(String imageFileName) throws MissingResourceException{
        ClassLoader loader = getClass().getClassLoader();
        String imagePath1 = "pictures" + File.separator + imageFileName;
        String imagePath2 = "/pictures/" + imageFileName;

        URL imgURL = loader.getResource(imagePath1);
        if (imgURL == null) {
            imgURL = this.getClass().getResource(imagePath2);
        }

        ImageIcon imageIcon = null;
        if (imgURL != null) {
            imageIcon = new ImageIcon(imgURL);

            int h = getPnlImage().getHeight();
            int w = getPnlImage().getWidth();

            getLblImage().setIcon(new ImageIcon(getScaledImage(imageIcon.getImage(), w, h)));
        } else {
            throw new MissingResourceException("No image with such path was found!",
                    String.class.getName(), imagePath2);
        }
    }

    /**
     * Resizes an image
     * @param srcImgPath - path to the source image to scale
     * @param width - desired width
     * @param heigth - desired height
     * @return - the new resized image
     */
    private Image getScaledImage(Image srcImgPath, int width, int height) {
        BufferedImage resizedImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = resizedImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImgPath, 0, 0, width, height, null);
        g2.dispose();
        return resizedImg;
    }

    @Override
    public void setPlayer1Name(String player1Name){
        setLblPlayer1(player1Name);
    }

    @Override
    public void setPlayer2Name(String player2Name){
        setLblPlayer2(player2Name);
    }

    @Override
    public void setActive(boolean isActive){
        if (isActive){
            enableTextField();
            clearTextField();
            clearTypedLabelsList();
            clearMatchedLabelsList();
            updateScore(0);
            resetRegressiveCounting();
        }

        setVisible(isActive);
    }

    private void enableTextField(){
        txtLabel.setEnabled(true);
    }

    private void clearTypedLabelsList(){
        getTypedLabelsElements().clear();
    }

    private void clearMatchedLabelsList(){
        getMatchedLabelsElements().clear();
    }

    private void resetRegressiveCounting(){
        setLblRegressiveCounting(String.valueOf(60));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPenico;
    private javax.swing.JLabel lblAnd;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblLetsLabel;
    private javax.swing.JLabel lblMatches;
    private javax.swing.JLabel lblPlayer1;
    private javax.swing.JLabel lblPlayer2;
    private javax.swing.JLabel lblPlayersInThisGame;
    private javax.swing.JLabel lblPoints;
    private javax.swing.JLabel lblRegressiveCounting;
    private javax.swing.JLabel lblScore;
    private javax.swing.JLabel lblSeconds;
    private javax.swing.JLabel lblTimeRemaining;
    private DefaultListModel matchedLabelsElements;
    private javax.swing.JList listMatchedLabels;
    private DefaultListModel typedLabelsElements;
    private javax.swing.JList listTypedLabels;
    private javax.swing.JPanel pnlImage;
    private javax.swing.JScrollPane pnlMatchedLabels;
    private javax.swing.JScrollPane pnlTypedLabels;
    private javax.swing.JTextField txtLabel;
    // End of variables declaration//GEN-END:variables

    public Controller getController() {
        return controller;
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }
    
    public JLabel getLblImage() {
        return lblImage;
    }

    public void setLblPlayer1(String lblPlayer1) {
        this.lblPlayer1.setText(lblPlayer1);
    }

    public void setLblPlayer2(String lblPlayer2) {
        this.lblPlayer2.setText(lblPlayer2);
    }

    public JPanel getPnlImage() {
        return pnlImage;
    }

    public String getLblRegressiveCounting() {
        return lblRegressiveCounting.getText();
    }

    public void setLblRegressiveCounting(String regressiveCounting) {
        this.lblRegressiveCounting.setText(regressiveCounting);
    }

    public void setLblPointsAmmount(int pointsAmmount) {
        this.lblScore.setText(String.valueOf(pointsAmmount));
    }

    public DefaultListModel getMatchedLabelsElements() {
        return matchedLabelsElements;
    }

    public DefaultListModel getTypedLabelsElements() {
        return typedLabelsElements;
    }

    public JTextField getTxtLabel() {
        return txtLabel;
    }
}
