/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.imagelabeler.client;

import br.ita.ces31.imagelabeler.client.controller.Controller;
import br.ita.ces31.imagelabeler.client.screen.ConnectionFailedScreen;
import br.ita.ces31.imagelabeler.client.screen.ConnectionLostScreen;
import br.ita.ces31.imagelabeler.client.screen.GameScreen;
import br.ita.ces31.imagelabeler.client.screen.GameSummaryScreen;
import br.ita.ces31.imagelabeler.client.screen.InterruptionGameScreen;
import br.ita.ces31.imagelabeler.client.screen.LoginScreen;
import br.ita.ces31.imagelabeler.client.screen.PartnerFoundScreen;
import br.ita.ces31.imagelabeler.client.screen.ServerBusyScreen;
import br.ita.ces31.imagelabeler.client.screen.WaitScreen;

/**
 *
 * @author diego
 */
public abstract class ControllerBuilder {

    protected abstract ConnectionFailedScreen getConnectionFailedScreen();
    protected abstract ConnectionLostScreen getConnectionLostScreen();
    protected abstract GameScreen getGameScreen();
    protected abstract GameSummaryScreen getGameSummaryScreen();
    protected abstract InterruptionGameScreen getInterruptionGameScreen();
    protected abstract LoginScreen getLoginScreen();
    protected abstract PartnerFoundScreen getPartnerFoundScreen();
    protected abstract ServerBusyScreen getServerBusyScreen();
    protected abstract WaitScreen getWaitScreen();

    public Controller buildController(){
        Controller controller = new Controller();
        controller.setConnectionFailedScreen(getConnectionFailedScreen());
        controller.setConnectionLostScreen(getConnectionLostScreen());
        controller.setGameScreen(getGameScreen());
        controller.setGameSummaryScreen(getGameSummaryScreen());
        controller.setInterruptionGameScreen(getInterruptionGameScreen());
        controller.setLoginScreen(getLoginScreen());
        controller.setPartnerFoundScreen(getPartnerFoundScreen());
        controller.setServerBusyScreen(getServerBusyScreen());
        controller.setWaitScreen(getWaitScreen());

        return controller;
    }
}
