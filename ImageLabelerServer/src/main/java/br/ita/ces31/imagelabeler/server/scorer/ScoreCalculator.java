/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.imagelabeler.server.scorer;

/**
 *
 * @author Helder Suzuki <helder@aluno.ita.br>
 */
public interface ScoreCalculator {

    /**
     * Calcula score de um match.
     * @param match
     * @return
     */
    public int calculateScore(String match);
}
