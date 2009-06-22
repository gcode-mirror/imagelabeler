/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.imagelabeler.client.screen.swing;

import br.ita.ces31.imagelabeler.client.controller.Controller;
import br.ita.ces31.imagelabeler.client.screen.*;
import javax.swing.JLabel;

/**
 *
 * @author diego
 */
public class PartnerFoundScreenSwing extends javax.swing.JFrame implements PartnerFoundScreen {
    private Controller controller;

    public PartnerFoundScreenSwing(){
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
        lblGameStartAnnouncement = new javax.swing.JLabel();
        lblPartnerFound = new javax.swing.JLabel();
        lblPartnerName = new javax.swing.JLabel();
        lblRegressiveCounting = new javax.swing.JLabel();
        lblSeconds = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Image Labeler");
        setResizable(false);

        btnPenico.setText("Penico");
        btnPenico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPenicoActionPerformed(evt);
            }
        });

        lblGameStartAnnouncement.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblGameStartAnnouncement.setText("The game will start in");
        lblGameStartAnnouncement.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblGameStartAnnouncement.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblGameStartAnnouncement.setMaximumSize(new java.awt.Dimension(300, 14));
        lblGameStartAnnouncement.setPreferredSize(new java.awt.Dimension(300, 16));
        lblGameStartAnnouncement.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        lblPartnerFound.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPartnerFound.setText("Partner Found:");
        lblPartnerFound.setName(""); // NOI18N

        lblPartnerName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblRegressiveCounting.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRegressiveCounting.setText("0");

        lblSeconds.setText("seconds!");

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
                        .addComponent(lblGameStartAnnouncement, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRegressiveCounting)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblSeconds, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(40, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblPartnerFound, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblPartnerName, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSeconds)
                    .addComponent(lblRegressiveCounting)
                    .addComponent(lblGameStartAnnouncement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(btnPenico)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPenicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPenicoActionPerformed
        getController().penico();
}//GEN-LAST:event_btnPenicoActionPerformed

    @Override
    public void setPartnerName(String partnerName){
        getLblPartnerName().setText(partnerName);
    }

    @Override
    public int getRegressiveCounting(){
        return Integer.parseInt(getLblRegressiveCounting());
    }

    @Override
    public void updateRegressiveCounting(int miliseconds){
        int currentCounting = getRegressiveCounting() - miliseconds/1000;
        setLblRegressiveCounting(String.valueOf(currentCounting));
    }

    @Override
    public void setActive(boolean isActive){
        if (isActive){
            resetRegressiveCounting();
        }

        setVisible(isActive);
    }

    private void resetRegressiveCounting(){
        setLblRegressiveCounting(String.valueOf(10));
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPenico;
    private javax.swing.JLabel lblGameStartAnnouncement;
    private javax.swing.JLabel lblPartnerFound;
    private javax.swing.JLabel lblPartnerName;
    private javax.swing.JLabel lblRegressiveCounting;
    private javax.swing.JLabel lblSeconds;
    // End of variables declaration//GEN-END:variables

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public JLabel getLblPartnerName() {
        return lblPartnerName;
    }

    public String getLblRegressiveCounting() {
        return lblRegressiveCounting.getText();
    }

    public void setLblRegressiveCounting(String regressiveCounting) {
        this.lblRegressiveCounting.setText(regressiveCounting);
    }
}
