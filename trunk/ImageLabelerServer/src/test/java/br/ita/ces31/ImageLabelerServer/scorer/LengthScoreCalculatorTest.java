/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.ImageLabelerServer.scorer;

import junit.framework.TestCase;

/**
 *
 * @author Helder Suzuki <helder@aluno.ita.br>
 */
public class LengthScoreCalculatorTest extends TestCase {

    private ScoreCalculator scorer;

    @Override
    public void setUp() {
        scorer = new LengthScoreCalculator();
    }

    public void testCalculareScore() {
        int score = scorer.calculateScore("test case");
        assertEquals(9, score);
    }
}
