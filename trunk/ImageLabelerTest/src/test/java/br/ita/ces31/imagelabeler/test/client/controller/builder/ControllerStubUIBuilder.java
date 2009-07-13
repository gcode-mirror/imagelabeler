/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.imagelabeler.test.client.controller.builder;

import br.ita.ces31.imagelabeler.client.controller.builder.*;
import br.ita.ces31.imagelabeler.client.screen.ConnectionFailedScreen;
import br.ita.ces31.imagelabeler.client.screen.ConnectionLostScreen;
import br.ita.ces31.imagelabeler.client.screen.GameScreen;
import br.ita.ces31.imagelabeler.client.screen.GameSummaryScreen;
import br.ita.ces31.imagelabeler.client.screen.InterruptionGameScreen;
import br.ita.ces31.imagelabeler.client.screen.LoginScreen;
import br.ita.ces31.imagelabeler.client.screen.PartnerFoundScreen;
import br.ita.ces31.imagelabeler.client.screen.ServerBusyScreen;
import br.ita.ces31.imagelabeler.client.screen.WaitScreen;

import br.ita.ces31.imagelabeler.test.client.screen.stub.ConnectionFailedScreenStub;
import br.ita.ces31.imagelabeler.test.client.screen.stub.ConnectionLostScreenStub;
import br.ita.ces31.imagelabeler.test.client.screen.stub.GameScreenStub;
import br.ita.ces31.imagelabeler.test.client.screen.stub.GameSummaryScreenStub;
import br.ita.ces31.imagelabeler.test.client.screen.stub.InterruptionGameScreenStub;
import br.ita.ces31.imagelabeler.test.client.screen.stub.LoginScreenStub;
import br.ita.ces31.imagelabeler.test.client.screen.stub.PartnerFoundScreenStub;
import br.ita.ces31.imagelabeler.test.client.screen.stub.ServerBusyScreenStub;
import br.ita.ces31.imagelabeler.test.client.screen.stub.WaitScreenStub;

/**
 *
 * @author diego
 */
public class ControllerStubUIBuilder extends ControllerBuilder{

    public ControllerStubUIBuilder(){
    }
    
    @Override
    protected ConnectionFailedScreen getConnectionFailedScreen(){
        return new ConnectionFailedScreenStub();
    }

    @Override
    protected ConnectionLostScreen getConnectionLostScreen(){
        return new ConnectionLostScreenStub();
    }

    @Override
    protected GameScreen getGameScreen(){
        return new GameScreenStub();
    }

    @Override
    protected GameSummaryScreen getGameSummaryScreen(){
        return new GameSummaryScreenStub();
    }

    @Override
    protected InterruptionGameScreen getInterruptionGameScreen(){
        return new InterruptionGameScreenStub();
    }

    @Override
    protected LoginScreen getLoginScreen(){
        return new LoginScreenStub();
    }

    @Override
    protected PartnerFoundScreen getPartnerFoundScreen(){
        return new PartnerFoundScreenStub();
    }

    @Override
    protected ServerBusyScreen getServerBusyScreen(){
        return new ServerBusyScreenStub();
    }

    @Override
    protected WaitScreen getWaitScreen(){
        return new WaitScreenStub();
    }
}
