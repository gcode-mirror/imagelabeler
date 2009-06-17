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

    public TimeoutTimerImpl(TimeoutNotifiable client) {
        timer = new Timer();
        setClient(client);
    }

    public void cancelRegressiveCounting(){
        timer.cancel();
    }
    
    public void scheduleRegressiveCountingToStartPlaying(long delay){
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                notifySecondPassedOnRegressiveCountingToStartPlaying();
            }
        }, delay);
    }
    
    public void scheduleRegressiveCountingToEndPlaying(long delay){
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                notifySecondPassedOnRegressiveCountingToEndPlaying();
            }
        }, delay);
    }
    
    private void notifySecondPassedOnRegressiveCountingToStartPlaying(){
        client.notifySecondPassedOnRegressiveCountingToStartPlaying();
    }
    
    private void notifySecondPassedOnRegressiveCountingToEndPlaying(){
        client.notifySecondPassedOnRegressiveCountingToEndPlaying();
    }

    public void setClient(TimeoutNotifiable client) {
        this.client = client;
    }
}
