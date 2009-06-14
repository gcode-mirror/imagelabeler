/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.imagelabeler.client.timer;

/**
 *
 * @author diego <helder@aluno.ita.br>
 */
public interface TimeoutTimer {

    public void scheduleRegressiveCounting(long delay);
}
