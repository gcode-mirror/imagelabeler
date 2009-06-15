/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.imagelabeler.server.timer;

import br.ita.ces31.imagelabeler.server.timer.TimeoutNotifiable;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Helder Suzuki <helder@aluno.ita.br>
 */
public class TimeoutTimerImpl implements TimeoutTimer {

    private Timer timer;
    private TimeoutNotifiable server;

    public TimeoutTimerImpl() {
        timer = new Timer();
    }

    /*
     * 1.4.2.2.2 a) Caso de Uso: Notificar Término
     */
    private void notifyTimeout() {
        server.notifyTimeout();
    }

    /**
     * 1.4.3.2.1a) Caso de Uso: Temporizar
     * @param task
     * @param delay
     */
    public void schedule(long delay) {
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                notifyTimeout();
            }
        }, delay);
    }

    /**
     * @param server the server to set
     */
    public void setServer(TimeoutNotifiable server) {
        this.server = server;
    }
}
