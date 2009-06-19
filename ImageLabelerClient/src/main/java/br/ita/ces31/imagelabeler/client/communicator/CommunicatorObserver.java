/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.imagelabeler.client.communicator;

import br.ita.ces31.imagelabeler.common.GameSummary;

/**
 *
 * @author Helder Suzuki <helder@aluno.ita.br>
 */
public interface CommunicatorObserver {

    public void endGameByPenico();

    public void notifyLabelMatch(String match, int score);

    public void startGame(String image, int seconds, String partner);

    public void endGame(GameSummary summary);
}
