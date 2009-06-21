/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.imagelabeler.client.screen.swing;

import br.ita.ces31.imagelabeler.client.controller.Controller;
import br.ita.ces31.imagelabeler.client.screen.*;

/**
 *
 * @author diego
 */
public class ServerBusyScreenSwing extends javax.swing.JFrame implements ServerBusyScreen {
    private Controller controller;

    public ServerBusyScreenSwing(Controller controller) {
        setController(controller);
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

        lblServerIsBusy = new javax.swing.JLabel();
        lblTryAgainLater = new javax.swing.JLabel();
        btnOk = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Image Labeler");

        lblServerIsBusy.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblServerIsBusy.setText("The server is busy.");
        lblServerIsBusy.setName(""); // NOI18N

        lblTryAgainLater.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTryAgainLater.setText("Try again later!");
        lblTryAgainLater.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblTryAgainLater.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblTryAgainLater.setMaximumSize(new java.awt.Dimension(300, 14));
        lblTryAgainLater.setPreferredSize(new java.awt.Dimension(300, 14));
        lblTryAgainLater.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        btnOk.setText("ok");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblServerIsBusy, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
            .addComponent(lblTryAgainLater, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(121, Short.MAX_VALUE)
                .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblServerIsBusy, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTryAgainLater, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnOk)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        getController().ok();
}//GEN-LAST:event_btnOkActionPerformed

    @Override
    public void setActive(boolean active){
        setVisible(active);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOk;
    private javax.swing.JLabel lblServerIsBusy;
    private javax.swing.JLabel lblTryAgainLater;
    // End of variables declaration//GEN-END:variables

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
}
