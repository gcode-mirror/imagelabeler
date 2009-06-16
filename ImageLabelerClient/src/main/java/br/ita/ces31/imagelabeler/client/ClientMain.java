/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.imagelabeler.client;

import br.ita.ces31.imagelabeler.client.communicator.ClientCommunicatorSingleton;
import br.ita.ces31.imagelabeler.client.controller.Controller;
import br.ita.ces31.imagelabeler.client.ui.UserInterface;
import br.ita.ces31.imagelabeler.client.ui.screen.ConnectionFailedScreen;
import br.ita.ces31.imagelabeler.client.ui.screen.ConnectionLostScreen;
import br.ita.ces31.imagelabeler.client.ui.screen.GameScreen;
import br.ita.ces31.imagelabeler.client.ui.screen.InterruptionGameScreen;
import br.ita.ces31.imagelabeler.client.ui.screen.LoginScreen;
import br.ita.ces31.imagelabeler.client.ui.screen.PartnerFoundScreen;
import br.ita.ces31.imagelabeler.client.ui.screen.ServerBusyScreen;
import br.ita.ces31.imagelabeler.client.ui.screen.GameSummaryScreen;
import br.ita.ces31.imagelabeler.client.ui.screen.WaitScreen;
import javax.swing.JFrame;

/**
 *
 * @author diego
 */
public class ClientMain {

    private static JFrame connectionFailedScreen;
    private static JFrame connectionLostScreen;
    private static JFrame gameScreen;
    private static JFrame interruptionGameScreen;
    private static JFrame loginScreen;
    private static JFrame partnerFoundScreen;
    private static JFrame serverBusyScreen;
    private static JFrame summaryGameScreen;
    private static JFrame waitScreen;

    public static void main(final String args[]) {

        initializeUI();

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                if (args.length == 1) {
                    ClientCommunicatorSingleton.setServerHost(args[0]);
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
        setConnectionFailedScreen(new ConnectionFailedScreen());
        setConnectionLostScreen(new ConnectionLostScreen());
        setGameScreen(new GameScreen());
        setInterruptionGameScreen(new InterruptionGameScreen());
        setLoginScreen(new LoginScreen());
        setPartnerFoundScreen(new PartnerFoundScreen());
        setServerBusyScreen(new ServerBusyScreen());
        setSummaryGameScreen(new GameSummaryScreen());
        setWaitScreen(new WaitScreen());
    }

    public static JFrame getConnectionFailedScreen() {
        return connectionFailedScreen;
    }

    public static JFrame getConnectionLostScreen() {
        return connectionLostScreen;
    }

    public static JFrame getGameScreen() {
        return gameScreen;
    }

    public static JFrame getInterruptionGameScreen() {
        return interruptionGameScreen;
    }

    public static JFrame getLoginScreen() {
        return loginScreen;
    }

    public static JFrame getPartnerFoundScreen() {
        return partnerFoundScreen;
    }

    public static JFrame getServerBusyScreen() {
        return serverBusyScreen;
    }

    public static JFrame getSummaryGameScreen() {
        return summaryGameScreen;
    }

    public static JFrame getWaitScreen() {
        return waitScreen;
    }

    public static void setConnectionFailedScreen(JFrame connectionFailedScreen) {
        ClientMain.connectionFailedScreen = connectionFailedScreen;
    }

    public static void setConnectionLostScreen(JFrame connectionLostScreen) {
        ClientMain.connectionLostScreen = connectionLostScreen;
    }

    public static void setGameScreen(JFrame gameScreen) {
        ClientMain.gameScreen = gameScreen;
    }

    public static void setInterruptionGameScreen(JFrame interruptionGameScreen) {
        ClientMain.interruptionGameScreen = interruptionGameScreen;
    }

    public static void setLoginScreen(JFrame loginScreen) {
        ClientMain.loginScreen = loginScreen;
    }

    public static void setPartnerFoundScreen(JFrame partnerFoundScreen) {
        ClientMain.partnerFoundScreen = partnerFoundScreen;
    }

    public static void setServerBusyScreen(JFrame serverBusyScreen) {
        ClientMain.serverBusyScreen = serverBusyScreen;
    }

    public static void setSummaryGameScreen(JFrame summaryGameScreen) {
        ClientMain.summaryGameScreen = summaryGameScreen;
    }

    public static void setWaitScreen(JFrame waitScreen) {
        ClientMain.waitScreen = waitScreen;
    }
}
