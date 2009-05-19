/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.ImageLabelerServer.scorer;

/**
 *
 * @author Helder Suzuki <helder@aluno.ita.br>
 */
public interface ScoreCalculator {

    public int calculateScore(String match);
}
