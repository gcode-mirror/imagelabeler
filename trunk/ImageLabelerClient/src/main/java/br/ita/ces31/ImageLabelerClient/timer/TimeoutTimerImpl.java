/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.ImageLabelerClient.timer;

import br.ita.ces31.ImageLabelerClient.timer.TimeoutNotifiable;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author diego
 */
public class TimeoutTimerImpl implements TimeoutTimer {

    private Timer timer;
    private TimeoutNotifiable client;

    public TimeoutTimerImpl(TimeoutNotifiable client) {
        timer = new Timer();
        setClient(client);
    }

    private void notifySecondPassedOnRegressiveCounting() {
        client.notifySecondPassedOnRegressiveCounting();
    }

    public void scheduleRegressiveCounting(long delay) {
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                notifySecondPassedOnRegressiveCounting();
            }
        }, delay);
    }

    public void setClient(TimeoutNotifiable client) {
        this.client = client;
    }
}
