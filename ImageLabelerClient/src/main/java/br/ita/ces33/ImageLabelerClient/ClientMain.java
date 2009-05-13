/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces33.ImageLabelerClient;

import br.ita.ces33.ImageLabelerClient.ui.LoginScreen;

/**
 *
 * @author Helder Suzuki <helder@aluno.ita.br>
 */
public class ClientMain{

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new LoginScreen().setVisible(true);
            }
        });

    }
}
