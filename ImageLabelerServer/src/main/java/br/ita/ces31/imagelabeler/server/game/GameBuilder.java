/*
 *  Copyright 2009 Helder Suzuki <heldersuzuki@gmail.com>.
 */
package br.ita.ces31.imagelabeler.server.game;

import br.ita.ces31.imagelabeler.common.Client;
import br.ita.ces31.imagelabeler.server.scorer.ScoreCalculator;

/**
 *
 * @author Helder Suzuki <heldersuzuki@gmail.com>
 */
public abstract class GameBuilder {

    protected abstract ScoreCalculator buildScorer();

    public Game buildGame(Client client1, Client client2) {
        return new Game(buildScorer(), client1, client2);
    }
}
