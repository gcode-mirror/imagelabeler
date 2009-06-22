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

    @Override
    public void cancelRegressiveCounting() {
        timer.cancel();
        timer = new Timer();
    }

    @Override
    public void scheduleRegressiveCountingToStartPlaying(){
        scheduleASecondOnRegressiveCountingToStartPlaying();
    }

    @Override
    public void continueRegressiveCountingToStartPlaying(){
        scheduleASecondOnRegressiveCountingToStartPlaying();
    }

    private void scheduleASecondOnRegressiveCountingToStartPlaying() {
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                notifySecondPassedOnRegressiveCountingToStartPlaying();
            }
        }, ONE_SECOND);
    }

    private void notifySecondPassedOnRegressiveCountingToStartPlaying() {
        client.notifySecondPassedOnRegressiveCountingToStartPlaying();
    }

    @Override
    public void scheduleRegressiveCountingToEndPlaying(){
        scheduleASecondOnRegressiveCountingToEndPlaying();
    }

    @Override
    public void continueRegressiveCountingToEndPlaying(){
        scheduleASecondOnRegressiveCountingToEndPlaying();
    }

    private void scheduleASecondOnRegressiveCountingToEndPlaying() {
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                notifySecondPassedOnRegressiveCountingToEndPlaying();
            }
        }, ONE_SECOND);
    }

    private void notifySecondPassedOnRegressiveCountingToEndPlaying() {
        client.notifySecondPassedOnRegressiveCountingToEndPlaying();
    }

    public void setClient(TimeoutNotifiable client) {
        this.client = client;
    }
}
