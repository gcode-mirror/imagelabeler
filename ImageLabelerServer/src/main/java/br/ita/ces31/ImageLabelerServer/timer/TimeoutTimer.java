/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.ImageLabelerServer.timer;

import java.util.TimerTask;

/**
 *
 * @author Helder Suzuki <helder@aluno.ita.br>
 */
public interface TimeoutTimer {

    /**
     * Registra evento de tempo limite.
     * @param task
     * @param delay
     */
    public void schedule(TimerTask task, long delay);
}
