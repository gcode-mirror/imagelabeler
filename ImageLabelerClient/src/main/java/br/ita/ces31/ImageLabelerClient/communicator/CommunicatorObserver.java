/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.ImageLabelerClient.communicator;

import br.ita.ces31.ImageLabelerCommon.GameSummary;

/**
 *
 * @author Helder Suzuki <helder@aluno.ita.br>
 */
public interface CommunicatorObserver {

    public String getLoginName();

    public void engGameByPenico();

    public void notifyMatch(String match);

    public void startGame(String image, int seconds);

    public void endGame(GameSummary summary);
}
