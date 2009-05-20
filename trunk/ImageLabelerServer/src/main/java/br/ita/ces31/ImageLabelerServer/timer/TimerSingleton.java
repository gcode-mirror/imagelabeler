/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.ImageLabelerServer.timer;

import java.util.Timer;

/**
 *
 * @author Helder Suzuki <helder@aluno.ita.br>
 */
public class TimerSingleton {

    private static Timer timer;

    public synchronized static Timer getTimer() {
        if (timer == null) {
            timer = new Timer();
        }

        return timer;
    }
}
