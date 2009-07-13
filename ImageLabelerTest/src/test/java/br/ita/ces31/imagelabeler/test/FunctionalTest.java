package br.ita.ces31.imagelabeler.test;

import br.ita.ces31.imagelabeler.test.thread.Client1Runnable;
import br.ita.ces31.imagelabeler.test.thread.Client2Runnable;
import br.ita.ces31.imagelabeler.test.thread.ServerRunnable;
import junit.framework.TestCase;

public class FunctionalTest extends TestCase{
    /*public static final String CONNECTION_FAILED = "ConnectionFailedScreen";
    public static final String CONNECTION_LOST = "ConnectionLostScreen";
    public static final String GAME = "GameScreen";
    public static final String GAME_SUMMARY = "GameSummaryScreen";
    public static final String INTERRUPTION_GAME ="InterruptionGameScreen";
    public static final String LOGIN = "LoginScreen";
    public static final String PARTNER_FOUND = "PartnerFoundScreen";
    public static final String SERVER_BUSY = "ServerBusyScreen";
    public static final String WAIT = "WaitScreen";*/

    private Thread server;
    private Thread client1;
    private Thread client2;
    private ServerRunnable sr;

    @Override
    public void setUp(){
        sr = new ServerRunnable();
        server = new Thread(sr);
        server.start();
    }

    public void testSendLabel(){

        Client1Runnable cr1 = new Client1Runnable();
        Client2Runnable cr2 = new Client2Runnable();

        client1 = new Thread(cr1);
        client2 = new Thread(cr2);

        client1.start();
        client2.start();
    }
    
    @Override
    public void tearDown(){
        sr.done();
    }
}
