/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.ImageLabelerServer.timer;

import java.util.TimerTask;

/**
 *
 * @author Helder Suzuki <helder@aluno.ita.br>
 */
public class TimerImpl implements Timer {

    public void schedule(TimerTask task, long delay) {
        TimerSingleton.getTimer().schedule(task, delay);
    }
}
