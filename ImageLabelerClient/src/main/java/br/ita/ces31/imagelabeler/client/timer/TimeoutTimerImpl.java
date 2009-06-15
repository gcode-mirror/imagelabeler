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
    
    public void scheduleStartGameRegressiveCounting(long delay){
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                notifySecondPassedOnStartGameRegressiveCounting();
            }
        }, delay);
    }
    
    public void scheduleEndGameRegressiveCounting(long delay){
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                notifySecondPassedOnEndGameRegressiveCounting();
            }
        }, delay);
    }
    
    private void notifySecondPassedOnStartGameRegressiveCounting(){
        client.notifySecondPassedOnStartGameRegressiveCounting();
    }
    
    private void notifySecondPassedOnEndGameRegressiveCounting(){
        client.notifySecondPassedOnEndGameRegressiveCounting();
    }

    public void setClient(TimeoutNotifiable client) {
        this.client = client;
    }
}
