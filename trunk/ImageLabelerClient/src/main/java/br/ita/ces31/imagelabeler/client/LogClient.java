/*
 *  Copyright 2009 Helder Suzuki <heldersuzuki@gmail.com>.
 */

package br.ita.ces31.imagelabeler.client;

import br.ita.ces31.imagelabeler.client.communicator.CommunicatorObserver;
import br.ita.ces31.imagelabeler.common.GameSummary;

/**
 *
 * @author Helder Suzuki <heldersuzuki@gmail.com>
 */
class LogClient implements CommunicatorObserver{

    public LogClient() {
    }

    public void endGameByPenico() {
        System.out.println("----------------------------------");
        System.out.println("endGameByPenico()");
       System.out.println("----------------------------------");
    }

    public void notifyLabelMatch(String match, int score) {
        System.out.println("----------------------------------");
        System.out.println("notifyLabelMatch");
        System.out.println("----------------------------------");
    }

    public void startGame(String image, int seconds, String partner) {
        System.out.println("----------------------------------");
        System.out.println("startGame");
        System.out.println("----------------------------------");
    }

    public void endGame(GameSummary summary) {
        System.out.println("endGame");
    }

}
