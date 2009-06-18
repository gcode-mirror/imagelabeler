/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.imagelabeler.client.ui.screen;

import br.ita.ces31.imagelabeler.client.ui.ConnectionLostUI;

/**
 *
 * @author diego
 */
public class ConnectionLostScreen extends javax.swing.JFrame {
    private ConnectionLostUI connectionLostUI;
    
    public ConnectionLostScreen() {
        setConnectionLostUI(new ConnectionLostUI(this));
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

        lblVerifyConnectionMessage = new javax.swing.JLabel();
        btnOk = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Image Labeler");

        lblVerifyConnectionMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVerifyConnectionMessage.setText("Connection Lost!");
        lblVerifyConnectionMessage.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblVerifyConnectionMessage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblVerifyConnectionMessage.setMaximumSize(new java.awt.Dimension(300, 14));
        lblVerifyConnectionMessage.setPreferredSize(new java.awt.Dimension(300, 14));
        lblVerifyConnectionMessage.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

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
            .addComponent(lblVerifyConnectionMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(119, Short.MAX_VALUE)
                .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lblVerifyConnectionMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnOk)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        getConnectionLostUI().ok();
}//GEN-LAST:event_btnOkActionPerformed

    public void setActive(boolean active){
        if (active){

        }

        setVisible(active);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOk;
    private javax.swing.JLabel lblVerifyConnectionMessage;
    // End of variables declaration//GEN-END:variables

    public ConnectionLostUI getConnectionLostUI() {
        return connectionLostUI;
    }

    public void setConnectionLostUI(ConnectionLostUI connectionLostUI) {
        this.connectionLostUI = connectionLostUI;
    }
}
