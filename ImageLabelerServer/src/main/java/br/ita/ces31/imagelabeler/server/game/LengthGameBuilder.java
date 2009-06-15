/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.imagelabeler.server.game;

import br.ita.ces31.imagelabeler.server.scorer.LengthScoreCalculator;
import br.ita.ces31.imagelabeler.server.scorer.ScoreCalculator;

/**
 *
 * @author Helder Suzuki <helder@aluno.ita.br>
 */
public class LengthGameBuilder extends GameBuilder {

    private static ScoreCalculator scorer = new LengthScoreCalculator();

    @Override
    protected ScoreCalculator buildScorer() {
        return scorer;
    }
}
