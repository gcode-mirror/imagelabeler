/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.ImageLabelerServer;

import br.ita.ces31.ImageLabelerCommon.Client;
import br.ita.ces31.ImageLabelerServer.scorer.LengthScoreCalculator;
import br.ita.ces31.ImageLabelerServer.scorer.ScoreCalculator;

/**
 *
 * @author Helder Suzuki <helder@aluno.ita.br>
 */
public class GameBuilder {

    private static ScoreCalculator scorer = new LengthScoreCalculator();

    /**
     * Cria instância de Game utilizando LengthScoreCalculator.
     * @param player1
     * @param player2
     * @return
     */
    public static Game createLengthGame(Client player1, Client player2) {
        return new Game(scorer, player1, player2);
    }
}