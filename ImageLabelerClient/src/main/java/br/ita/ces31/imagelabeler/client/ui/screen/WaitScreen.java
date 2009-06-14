/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * WaitScreen.java
 *
 * Created on May 31, 2009, 5:04:52 PM
 */

package br.ita.ces31.imagelabeler.client.ui.screen;

import br.ita.ces31.imagelabeler.client.ui.WaitUI;

/**
 *
 * @author diego
 */
public class WaitScreen extends javax.swing.JFrame {
    private WaitUI waitUI = new WaitUI(this);
    
    /** Creates new form WaitScreen */
    public WaitScreen() {
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

        lblConnectionFailedMessage = new javax.swing.JLabel();
        lblVerifyConnectionMessage = new javax.swing.JLabel();
        btnOk = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Image Labeler");
        setResizable(false);

        lblConnectionFailedMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblConnectionFailedMessage.setName(""); // NOI18N

        lblVerifyConnectionMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVerifyConnectionMessage.setText("Finding a partner, please wait...");
        lblVerifyConnectionMessage.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblVerifyConnectionMessage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblVerifyConnectionMessage.setMaximumSize(new java.awt.Dimension(300, 14));
        lblVerifyConnectionMessage.setPreferredSize(new java.awt.Dimension(300, 14));
        lblVerifyConnectionMessage.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        btnOk.setText("cancel");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
            .addGap(0, 310, Short.MAX_VALUE)
            .addComponent(lblConnectionFailedMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
            .addComponent(lblVerifyConnectionMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(121, Short.MAX_VALUE)
                .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
            .addGap(0, 97, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblConnectionFailedMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblVerifyConnectionMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnOk)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        cancel();
    }//GEN-LAST:event_btnOkActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WaitScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOk;
    private javax.swing.JLabel lblConnectionFailedMessage;
    private javax.swing.JLabel lblVerifyConnectionMessage;
    // End of variables declaration//GEN-END:variables

    public void cancel(){
        getWaitUI().cancel();
    }

    public WaitUI getWaitUI() {
        return waitUI;
    }

    public void setWaitUI(WaitUI waitUI) {
        this.waitUI = waitUI;
    }
}
