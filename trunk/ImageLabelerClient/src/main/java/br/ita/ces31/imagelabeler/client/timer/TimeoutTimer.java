/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.imagelabeler.client.timer;

/**
 *
 * @author diego
 */
public interface TimeoutTimer {
    public void cancelRegressiveCounting();
    public void scheduleRegressiveCountingToStartPlaying(long delay);
    public void scheduleRegressiveCountingToEndPlaying(long delay);
}
