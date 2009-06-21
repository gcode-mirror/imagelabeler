/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ita.ces31.imagelabeler.client;

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
import br.ita.ces31.imagelabeler.client.ui.screen.ConnectionFailedScreen;
import br.ita.ces31.imagelabeler.client.ui.screen.ConnectionLostScreen;
import br.ita.ces31.imagelabeler.client.ui.screen.GameScreen;
import br.ita.ces31.imagelabeler.client.ui.screen.GameSummaryScreen;
import br.ita.ces31.imagelabeler.client.ui.screen.InterruptionGameScreen;
import br.ita.ces31.imagelabeler.client.ui.screen.LoginScreen;
import br.ita.ces31.imagelabeler.client.ui.screen.PartnerFoundScreen;
import br.ita.ces31.imagelabeler.client.ui.screen.ServerBusyScreen;
import br.ita.ces31.imagelabeler.client.ui.screen.WaitScreen;
import br.ita.ces31.imagelabeler.client.ui.screen.swing.ConnectionFailedScreenSwing;
import br.ita.ces31.imagelabeler.client.ui.screen.swing.ConnectionLostScreenSwing;
import br.ita.ces31.imagelabeler.client.ui.screen.swing.GameScreenSwing;
import br.ita.ces31.imagelabeler.client.ui.screen.swing.GameSummaryScreenSwing;
import br.ita.ces31.imagelabeler.client.ui.screen.swing.InterruptionGameScreenSwing;
import br.ita.ces31.imagelabeler.client.ui.screen.swing.LoginScreenSwing;
import br.ita.ces31.imagelabeler.client.ui.screen.swing.PartnerFoundScreenSwing;
import br.ita.ces31.imagelabeler.client.ui.screen.swing.ServerBusyScreenSwing;
import br.ita.ces31.imagelabeler.client.ui.screen.swing.WaitScreenSwing;

/**
 *
 * @author diego
 */
public class ClientUIFactory {

    public static void createSwingUI(){
        setUIController(new Controller());
        setConnectionFailedUI(new ConnectionFailedScreenSwing());
        setConnectionLostUI(new ConnectionLostScreenSwing());
        setGameSummaryUI(new GameSummaryScreenSwing());
        setGameUI(new GameScreenSwing());
        setInterruptionGameUI(new InterruptionGameScreenSwing());
        setLoginUI(new LoginScreenSwing());
        setPartnerFoundUI(new PartnerFoundScreenSwing());
        setServerBusyUI(new ServerBusyScreenSwing());
        setWaitUI(new WaitScreenSwing());
    }

    private static  void setUIController(Controller controller){
        UserInterface.setController(controller);
    }
    
    private static void setConnectionFailedUI(ConnectionFailedScreen connectionFailedScreen){
        if (UserInterface.getController() != null){
            UserInterface.getController().setConnectionFailedUI(new ConnectionFailedUI(connectionFailedScreen));
        }
    }

    private static void setConnectionLostUI(ConnectionLostScreen connectionLostScreen){
        if (UserInterface.getController() != null){
            UserInterface.getController().setConnectionLostUI(new ConnectionLostUI(connectionLostScreen));
        }
    }

    private  static void setGameSummaryUI(GameSummaryScreen gameSummaryScreen){
        if (UserInterface.getController() != null){
            UserInterface.getController().setGameSummaryUI(new GameSummaryUI(gameSummaryScreen));
        }
    }

    private static void setGameUI(GameScreen gameScreen){
        if (UserInterface.getController() != null){
            UserInterface.getController().setGameUI(new GameUI(gameScreen));
        }
    }

    private static void setInterruptionGameUI(InterruptionGameScreen interruptionGameScreen){
        if (UserInterface.getController() != null){
            UserInterface.getController().setInterruptionGameUI(new InterruptionGameUI(interruptionGameScreen));
        }
    }

    private static void setLoginUI(LoginScreen loginScreen){
        if (UserInterface.getController() != null){
            UserInterface.getController().setLoginUI(new LoginUI(loginScreen));
        }
    }

    private static void setPartnerFoundUI(PartnerFoundScreen partnerFoundScreen){
        if (UserInterface.getController() != null){
            UserInterface.getController().setPartnerFoundUI(new PartnerFoundUI(partnerFoundScreen));
        }
    }

    private static void setServerBusyUI(ServerBusyScreen serverBusyScreen){
        if (UserInterface.getController() != null){
            UserInterface.getController().setServerBusyUI(new ServerBusyUI(serverBusyScreen));
        }
    }

    private static void setWaitUI(WaitScreen waitScreen){
        if (UserInterface.getController() != null){
            UserInterface.getController().setWaitUI(new WaitUI(waitScreen));
        }
    }
}
