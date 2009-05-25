/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.ImageLabelerServer.scorer;

/**
 * Estratégia de pontuação com base no comprimento do match.
 * @author Helder Suzuki <helder@aluno.ita.br>
 */
public class LengthScoreCalculator implements ScoreCalculator {

    public int calculateScore(String match) {
        return match.length();
    }
}
