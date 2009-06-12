/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.ImageLabelerServer;

import br.ita.ces31.ImageLabelerServer.timer.TimeoutTimer;

/**
 *
 * @author Helder Suzuki <helder@aluno.ita.br>
 */
public class TestTimer implements TimeoutTimer {

    public long delay = -1;

    public void schedule(long delay) {
        this.delay = delay;
    }
}
