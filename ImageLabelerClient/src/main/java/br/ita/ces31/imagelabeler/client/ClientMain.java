/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.imagelabeler.client;

import br.ita.ces31.imagelabeler.client.communicator.ClientCommunicatorSingleton;
import br.ita.ces31.imagelabeler.client.communicator.CommunicationException;
import br.ita.ces31.imagelabeler.client.controller.Controller;
import br.ita.ces31.imagelabeler.client.ui.ConnectionFailedUI;
import br.ita.ces31.imagelabeler.client.ui.ConnectionLostUI;
import br.ita.ces31.imagelabeler.client.ui.GameSummaryUI;
import br.ita.ces31.imagelabeler.client.ui.GameUI;
import br.ita.ces31.imagelabeler.client.ui.InterruptionGameUI;
import br.ita.ces31.imagelabeler.client.ui.LoginUI;
import br.ita.ces31.imagelabeler.client.ui.PartnerFoundUI;
import br.ita.ces31.imagelabeler.client.ui.ServerBusyUI;
import br.ita.ces31.imagelabeler.client.ui.UserInterface;
import br.ita.ces31.imagelabeler.client.ui.WaitUI;
import br.ita.ces31.imagelabeler.client.ui.screen.ConnectionFailedScreenImpl;
import br.ita.ces31.imagelabeler.client.ui.screen.ConnectionLostScreenImpl;
import br.ita.ces31.imagelabeler.client.ui.screen.GameScreenImpl;
import br.ita.ces31.imagelabeler.client.ui.screen.GameSummaryScreenImpl;
import br.ita.ces31.imagelabeler.client.ui.screen.InterruptionGameScreenImpl;
import br.ita.ces31.imagelabeler.client.ui.screen.LoginScreenImpl;
import br.ita.ces31.imagelabeler.client.ui.screen.PartnerFoundScreenImpl;
import br.ita.ces31.imagelabeler.client.ui.screen.ServerBusyScreenImpl;
import br.ita.ces31.imagelabeler.client.ui.screen.WaitScreenImpl;

/**
 *
 * @author diego
 */
public class ClientMain {

    public static void main(final String args[]) {

        initializeUI();

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                if (args.length == 1) {
                    ClientCommunicatorSingleton.setServerHost(args[0]);
                }

                try {
                    ClientCommunicatorSingleton.getCommunicator().addObserver(new LogClient());
                } catch (CommunicationException ex) {
                    ex.printStackTrace();
                }

                try {
                    UserInterface.getController().connect();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    private static void initializeUI() {
        UserInterface.setController(new Controller());

        ConnectionFailedScreenImpl connectionFailedScreen = new ConnectionFailedScreenImpl();
        ConnectionLostScreenImpl connectionLostScreen = new ConnectionLostScreenImpl();
        GameSummaryScreenImpl gameSummaryScreen = new GameSummaryScreenImpl();
        GameScreenImpl gameScreen = new GameScreenImpl();
        InterruptionGameScreenImpl interruptionGameScreen = new InterruptionGameScreenImpl();
        LoginScreenImpl loginScreen = new LoginScreenImpl();
        PartnerFoundScreenImpl partnerFoundScreen = new PartnerFoundScreenImpl();
        ServerBusyScreenImpl serverBusyScreen = new ServerBusyScreenImpl();
        WaitScreenImpl waitScreen = new WaitScreenImpl();

        UserInterface.getController().setConnectionFailedUI(new ConnectionFailedUI(connectionFailedScreen));
        UserInterface.getController().setConnectionLostUI(new ConnectionLostUI(connectionLostScreen));
        UserInterface.getController().setGameSummaryUI(new GameSummaryUI(gameSummaryScreen));
        UserInterface.getController().setGameUI(new GameUI(gameScreen));
        UserInterface.getController().setInterruptionGameUI(new InterruptionGameUI(interruptionGameScreen));
        UserInterface.getController().setLoginUI(new LoginUI(loginScreen));
        UserInterface.getController().setPartnerFoundUI(new PartnerFoundUI(partnerFoundScreen));
        UserInterface.getController().setServerBusyUI(new ServerBusyUI(serverBusyScreen));
        UserInterface.getController().setWaitUI(new WaitUI(waitScreen));
    }
}
