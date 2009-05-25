/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.ImageLabelerServer;

import br.ita.ces31.ImageLabelerServer.timer.TimeoutTimer;
import java.util.TimerTask;

/**
 *
 * @author Helder Suzuki <helder@aluno.ita.br>
 */
public class TestTimer implements TimeoutTimer {

    public TimerTask task = null;
    public long delay = -1;

    public void schedule(TimerTask task, long delay) {
        this.task = task;
        this.delay = delay;
    }
}
