/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.imagelabeler.client.timer;

import br.ita.ces31.imagelabeler.client.timer.TimeoutNotifiable;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author diego
 */
public class TimeoutTimerImpl implements TimeoutTimer {
    private Timer timer;
    private TimeoutNotifiable client;
    private static final int ONE_SECOND = 1000;

    public TimeoutTimerImpl(TimeoutNotifiable client) {
        timer = new Timer();
        setClient(client);
    }

    public void cancelRegressiveCounting() {
        timer.cancel();
        timer = new Timer();
    }

    public void scheduleASecondOnRegressiveCountingToStartPlaying() {
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                notifySecondPassedOnRegressiveCountingToStartPlaying();
            }
        }, ONE_SECOND);
    }

    public void scheduleASecondOnRegressiveCountingToEndPlaying() {
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                notifySecondPassedOnRegressiveCountingToEndPlaying();
            }
        }, ONE_SECOND);
    }

    private void notifySecondPassedOnRegressiveCountingToStartPlaying() {
        client.notifySecondPassedOnRegressiveCountingToStartPlaying();
    }

    private void notifySecondPassedOnRegressiveCountingToEndPlaying() {
        client.notifySecondPassedOnRegressiveCountingToEndPlaying();
    }

    public void setClient(TimeoutNotifiable client) {
        this.client = client;
    }
}
