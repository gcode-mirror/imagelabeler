/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.imagelabeler.client.controller.builder;

import br.ita.ces31.imagelabeler.client.screen.ConnectionFailedScreen;
import br.ita.ces31.imagelabeler.client.screen.ConnectionLostScreen;
import br.ita.ces31.imagelabeler.client.screen.GameScreen;
import br.ita.ces31.imagelabeler.client.screen.GameSummaryScreen;
import br.ita.ces31.imagelabeler.client.screen.InterruptionGameScreen;
import br.ita.ces31.imagelabeler.client.screen.LoginScreen;
import br.ita.ces31.imagelabeler.client.screen.PartnerFoundScreen;
import br.ita.ces31.imagelabeler.client.screen.ServerBusyScreen;
import br.ita.ces31.imagelabeler.client.screen.WaitScreen;
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
public class ControllerSwingUIBuilder extends ControllerBuilder{
    @Override
    protected ConnectionFailedScreen getConnectionFailedScreen(){
        return new ConnectionFailedScreenSwing();
    }

    @Override
    protected ConnectionLostScreen getConnectionLostScreen(){
        return new ConnectionLostScreenSwing();
    }

    @Override
    protected GameScreen getGameScreen(){
        return new GameScreenSwing();
    }

    @Override
    protected GameSummaryScreen getGameSummaryScreen(){
        return new GameSummaryScreenSwing();
    }

    @Override
    protected InterruptionGameScreen getInterruptionGameScreen(){
        return new InterruptionGameScreenSwing();
    }

    @Override
    protected LoginScreen getLoginScreen(){
        return new LoginScreenSwing();
    }

    @Override
    protected PartnerFoundScreen getPartnerFoundScreen(){
        return new PartnerFoundScreenSwing();
    }

    @Override
    protected ServerBusyScreen getServerBusyScreen(){
        return new ServerBusyScreenSwing();
    }

    @Override
    protected WaitScreen getWaitScreen(){
        return new WaitScreenSwing();
    }
}
