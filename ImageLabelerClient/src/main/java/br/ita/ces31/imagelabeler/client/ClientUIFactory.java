/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ita.ces31.imagelabeler.client;

import br.ita.ces31.imagelabeler.client.controller.Controller;
import br.ita.ces31.imagelabeler.client.screen.swing.ConnectionFailedScreenSwing;
import br.ita.ces31.imagelabeler.client.screen.swing.ConnectionLostScreenSwing;
import br.ita.ces31.imagelabeler.client.screen.swing.GameScreenSwing;
import br.ita.ces31.imagelabeler.client.screen.swing.GameSummaryScreenSwing;
import br.ita.ces31.imagelabeler.client.screen.swing.InterruptionGameScreenSwing;
import br.ita.ces31.imagelabeler.client.screen.swing.LoginScreenSwing;
import br.ita.ces31.imagelabeler.client.screen.swing.PartnerFoundScreenSwing;
import br.ita.ces31.imagelabeler.client.screen.swing.ServerBusyScreenSwing;
import br.ita.ces31.imagelabeler.client.screen.swing.WaitScreenSwing;

/**
 *
 * @author diego
 */
public class ClientUIFactory {
    private static Controller controller = new Controller();

    public static void createSwingUI(){
        controller.setConnectionFailedScreen(new ConnectionFailedScreenSwing(controller));
        controller.setConnectionLostScreen(new ConnectionLostScreenSwing(controller));
        controller.setGameScreen(new GameScreenSwing(controller));
        controller.setGameSummaryScreen(new GameSummaryScreenSwing(controller));
        controller.setInterruptionGameScreen(new InterruptionGameScreenSwing(controller));
        controller.setLoginScreen(new LoginScreenSwing(controller));
        controller.setPartnerFoundScreen(new PartnerFoundScreenSwing(controller));
        controller.setServerBusyScreen(new ServerBusyScreenSwing(controller));
        controller.setWaitScreen(new WaitScreenSwing(controller));
    }

    public static Controller getController(){
        return controller;
    }
}
