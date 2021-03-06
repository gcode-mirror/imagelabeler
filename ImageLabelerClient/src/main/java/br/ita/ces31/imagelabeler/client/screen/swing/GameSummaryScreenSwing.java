/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.imagelabeler.client.screen.swing;

import br.ita.ces31.imagelabeler.client.controller.Controller;
import br.ita.ces31.imagelabeler.client.screen.*;
import br.ita.ces31.imagelabeler.common.Player;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author diego
 */
public class GameSummaryScreenSwing extends javax.swing.JFrame implements GameSummaryScreen {
    private Controller controller;
    
    public GameSummaryScreenSwing() {
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

        lblPlayerName = new javax.swing.JLabel();
        lblPointsAnnouncement = new javax.swing.JLabel();
        lblFinalScore = new javax.swing.JLabel();
        lblPoints = new javax.swing.JLabel();
        lblMatches = new javax.swing.JLabel();
        lblTopPlayers = new javax.swing.JLabel();
        pnlMatchedLabels = new javax.swing.JScrollPane();
        matchedLabelsElements = new DefaultListModel();
        listMatchedLabels = new javax.swing.JList(matchedLabelsElements);
        btnPlayAgain = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        pnlRank = new javax.swing.JScrollPane();
        rankElements = new DefaultTableModel();
        rankElements.addColumn("Player");
        rankElements.addColumn("Score");
        tblRank = new javax.swing.JTable(rankElements);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Image Labeler");
        setResizable(false);

        lblPointsAnnouncement.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPointsAnnouncement.setText(":  You and your partner made");
        lblPointsAnnouncement.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        lblPoints.setText("Points!");

        lblMatches.setText("Label Matches");

        lblTopPlayers.setText("TopPlayers");

        listMatchedLabels.setEnabled(false);
        pnlMatchedLabels.setViewportView(listMatchedLabels);

        btnPlayAgain.setText("Play again");
        btnPlayAgain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayAgainActionPerformed(evt);
            }
        });

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        tblRank.setModel(rankElements
        );
        tblRank.setEnabled(false);
        tblRank.getTableHeader().setReorderingAllowed(false);
        pnlRank.setViewportView(tblRank);
        tblRank.getColumnModel().getColumn(0).setResizable(false);
        tblRank.getColumnModel().getColumn(1).setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblPlayerName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPointsAnnouncement)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblFinalScore)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblPoints))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblMatches)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                        .addComponent(lblTopPlayers)
                        .addGap(154, 154, 154))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(btnPlayAgain)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(pnlMatchedLabels, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(pnlRank, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPlayerName)
                    .addComponent(lblPointsAnnouncement)
                    .addComponent(lblFinalScore)
                    .addComponent(lblPoints))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMatches)
                    .addComponent(lblTopPlayers))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlRank, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(pnlMatchedLabels, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPlayAgain, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        getController().exit();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnPlayAgainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayAgainActionPerformed
        getController().playAgain();
    }//GEN-LAST:event_btnPlayAgainActionPerformed

    @Override
    public void setFinalPontuation(int finalScore){
        setLblFinalScore(finalScore);
    }
    
    @Override
    public void setPlayerName(String playerName){
        setLblPlayerName(playerName);
    }

    @Override
    public void setMatchedLabelsList(List<String> matchedLabels){
        getMatchedLabelsElements().clear();
        
        if(matchedLabels != null){
            for(String s: matchedLabels){
                addElementOnMatchedLabelsList(s);
            }
        }
    }

    private void addElementOnMatchedLabelsList(String label){
        getMatchedLabelsElements().addElement(label);
    }

    @Override
    public void setRank(List<Player> topPlayers){
        getRankElements().getDataVector().clear();
        
        if(topPlayers != null){
            for(Player p: topPlayers){
                addPlayerOnRank(p);
            }
        }
    }

    private void addPlayerOnRank(Player player){
        getRankElements().addRow(new Object[]{player.getName(), player.getScore()});
    }

    @Override
    public void setActive(boolean isActive){
        setVisible(isActive);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnPlayAgain;
    private javax.swing.JLabel lblFinalScore;
    private javax.swing.JLabel lblMatches;
    private javax.swing.JLabel lblPlayerName;
    private javax.swing.JLabel lblPoints;
    private javax.swing.JLabel lblPointsAnnouncement;
    private javax.swing.JLabel lblTopPlayers;
    private DefaultListModel matchedLabelsElements;
    private javax.swing.JList listMatchedLabels;
    private javax.swing.JScrollPane pnlMatchedLabels;
    private javax.swing.JScrollPane pnlRank;
    private DefaultTableModel rankElements;
    private javax.swing.JTable tblRank;
    // End of variables declaration//GEN-END:variables

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void setLblPlayerName(String playerName) {
        this.lblPlayerName.setText(playerName);
    }

    public void setLblFinalScore(int finalScore) {
        this.lblFinalScore.setText(String.valueOf(finalScore));
    }

    public DefaultListModel getMatchedLabelsElements() {
        return matchedLabelsElements;
    }

    public DefaultTableModel getRankElements() {
        return rankElements;
    }
}
