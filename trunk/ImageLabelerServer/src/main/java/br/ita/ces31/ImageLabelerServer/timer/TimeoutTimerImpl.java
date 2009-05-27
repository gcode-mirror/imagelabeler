/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.ImageLabelerServer.timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Helder Suzuki <helder@aluno.ita.br>
 */
public class TimeoutTimerImpl implements TimeoutTimer {

    private Timer timer;

    public TimeoutTimerImpl() {
        timer = new Timer();
    }

    /**
     * 1.4.3.2.1a) Caso de Uso: Temporizar
     * @param task
     * @param delay
     */
    public void schedule(TimerTask task, long delay) {
        timer.schedule(task, delay);
    }
}
