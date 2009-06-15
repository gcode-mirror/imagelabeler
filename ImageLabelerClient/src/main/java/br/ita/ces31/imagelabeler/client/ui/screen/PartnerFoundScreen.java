/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PartnerFoundScreen.java
 *
 * Created on May 31, 2009, 5:04:30 PM
 */

package br.ita.ces31.imagelabeler.client.ui.screen;

import br.ita.ces31.imagelabeler.client.ui.PartnerFoundUI;

/**
 *
 * @author diego
 */
public class PartnerFoundScreen extends javax.swing.JFrame {
    private PartnerFoundUI partnerFoundUI = new PartnerFoundUI(this);

    /** Creates new form PartnerFoundScreen */
    public PartnerFoundScreen() {
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

        btnPenico = new javax.swing.JButton();
        lblCountingMessage1 = new javax.swing.JLabel();
        lblPartnerFound = new javax.swing.JLabel();
        lblPartnerName = new javax.swing.JLabel();
        lblRegressiveCounting = new javax.swing.JLabel();
        lblCountingMessage2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Image Labeler");
        setResizable(false);

        btnPenico.setText("Penico");
        btnPenico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPenicoActionPerformed(evt);
            }
        });

        lblCountingMessage1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCountingMessage1.setText("The game will start in");
        lblCountingMessage1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblCountingMessage1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblCountingMessage1.setMaximumSize(new java.awt.Dimension(300, 14));
        lblCountingMessage1.setPreferredSize(new java.awt.Dimension(300, 16));
        lblCountingMessage1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        lblPartnerFound.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPartnerFound.setText("Partner Found:");
        lblPartnerFound.setName(""); // NOI18N

        lblPartnerName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblRegressiveCounting.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRegressiveCounting.setText("10");

        lblCountingMessage2.setText("seconds!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnPenico, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(114, 114, 114))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblPartnerFound, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(lblPartnerName, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCountingMessage1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRegressiveCounting)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblCountingMessage2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(34, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblPartnerFound, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblPartnerName, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCountingMessage2)
                    .addComponent(lblRegressiveCounting)
                    .addComponent(lblCountingMessage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(btnPenico)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPenicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPenicoActionPerformed
        penico();
}//GEN-LAST:event_btnPenicoActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PartnerFoundScreen().setVisible(true);
            }
        });
    }

    private void penico(){
        getPartnerFoundUI().penico();
    }

    public void setPartnerName(String partnerName) {
        this.lblPartnerName.setText(partnerName);
    }

    public int getLblRegressiveCounting() {
        return Integer.parseInt(lblRegressiveCounting.getText());
    }

    public void setLblRegressiveCounting(int lblRegressiveCounting) {
        this.lblRegressiveCounting.setText(String.valueOf(lblRegressiveCounting));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPenico;
    private javax.swing.JLabel lblCountingMessage1;
    private javax.swing.JLabel lblCountingMessage2;
    private javax.swing.JLabel lblPartnerFound;
    private javax.swing.JLabel lblPartnerName;
    private javax.swing.JLabel lblRegressiveCounting;
    // End of variables declaration//GEN-END:variables

    public PartnerFoundUI getPartnerFoundUI() {
        return partnerFoundUI;
    }

    public void setPartnerFoundUI(PartnerFoundUI partnerFoundUI) {
        this.partnerFoundUI = partnerFoundUI;
    }
}
