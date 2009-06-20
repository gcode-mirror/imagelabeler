/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.imagelabeler.client.ui.screen;

import br.ita.ces31.imagelabeler.client.ui.WaitUI;

/**
 *
 * @author diego
 */
public class WaitScreenImpl extends javax.swing.JFrame implements WaitScreen {
    private WaitUI waitUI;
    
    public WaitScreenImpl() {
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

        lblFindingParter = new javax.swing.JLabel();
        btnOk = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Image Labeler");
        setResizable(false);

        lblFindingParter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFindingParter.setText("Finding a partner, please wait...");
        lblFindingParter.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblFindingParter.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblFindingParter.setMaximumSize(new java.awt.Dimension(300, 14));
        lblFindingParter.setPreferredSize(new java.awt.Dimension(300, 14));
        lblFindingParter.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

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
            .addComponent(lblFindingParter, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(121, Short.MAX_VALUE)
                .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lblFindingParter, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnOk)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        getWaitUI().cancel();
    }//GEN-LAST:event_btnOkActionPerformed

    @Override
    public void setActive(boolean active){
        setVisible(active);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOk;
    private javax.swing.JLabel lblFindingParter;
    // End of variables declaration//GEN-END:variables

    public WaitUI getWaitUI() {
        return waitUI;
    }

    public void setWaitUI(WaitUI waitUI) {
        this.waitUI = waitUI;
    }
}
