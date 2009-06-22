/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.imagelabeler.client.timer;

/**
 *
 * @author diego
 */
public interface TimeoutNotifiable {
    void notifySecondPassedOnRegressiveCountingToStartPlaying();
    
    void notifySecondPassedOnRegressiveCountingToEndPlaying();
}
