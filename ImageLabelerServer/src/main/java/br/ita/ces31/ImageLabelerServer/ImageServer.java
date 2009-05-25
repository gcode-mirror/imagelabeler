/*
 * Image Labeler - Projeto de CES-31
 */

package br.ita.ces31.ImageLabelerServer;

/**
 *
 * @author Helder Suzuki <helder@aluno.ita.br>
 */
public interface ImageServer {
    /**
     * Adquire Imagem a ser utilizada no Game.
     * @return
     */
    public String getImage();
}
