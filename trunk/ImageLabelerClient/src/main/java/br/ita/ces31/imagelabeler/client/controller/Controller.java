/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.imagelabeler.client.controller;

import br.ita.ces31.imagelabeler.client.communicator.ClientCommunicator;
import br.ita.ces31.imagelabeler.client.communicator.ClientCommunicatorSingleton;
import br.ita.ces31.imagelabeler.client.communicator.CommunicationException;
import br.ita.ces31.imagelabeler.client.communicator.Communicator;
import br.ita.ces31.imagelabeler.client.communicator.CommunicatorObserver;
import br.ita.ces31.imagelabeler.client.timer.TimeoutNotifiable;
import br.ita.ces31.imagelabeler.client.timer.TimeoutTimer;
import br.ita.ces31.imagelabeler.client.timer.TimeoutTimerImpl;
import br.ita.ces31.imagelabeler.client.screen.ConnectionFailedScreen;
import br.ita.ces31.imagelabeler.client.screen.ConnectionLostScreen;
import br.ita.ces31.imagelabeler.client.screen.GameScreen;
import br.ita.ces31.imagelabeler.client.screen.GameSummaryScreen;
import br.ita.ces31.imagelabeler.client.screen.InterruptionGameScreen;
import br.ita.ces31.imagelabeler.client.screen.LoginScreen;
import br.ita.ces31.imagelabeler.client.screen.PartnerFoundScreen;
import br.ita.ces31.imagelabeler.client.screen.Screen;
import br.ita.ces31.imagelabeler.client.screen.ServerBusyScreen;
import br.ita.ces31.imagelabeler.client.screen.WaitScreen;
import br.ita.ces31.imagelabeler.common.GameSummary;

/**
 *
 * @author diego
 */
public class Controller implements CommunicatorObserver, TimeoutNotifiable {

    private Communicator clientCommunicator;
    private TimeoutTimer timer;
    private Screen currentScreen;
    private ConnectionFailedScreen connectionFailedScreen;
    private ConnectionLostScreen connectionLostScreen;
    private GameScreen gameScreen;
    private InterruptionGameScreen interruptionGameScreen;
    private LoginScreen loginScreen;
    private PartnerFoundScreen partnerFoundScreen;
    private ServerBusyScreen serverBusyScreen;
    private GameSummaryScreen gameSummaryScreen;
    private WaitScreen waitScreen;
    private static final int ONE_SECOND = 1000;

    public Controller(){
        setTimer(new TimeoutTimerImpl(this));
    }

    //From interface CommunicatorObserver
    public String getLoginName(){
        return ((ClientCommunicator) getClientCommunicator()).getLoginName();
    }

    //From interface CommunicatorObserver
    public void endGameByPenico(){
        getTimer().cancelRegressiveCounting();
        setCurrentScreen(getInterruptionGameScreen());
    }

    //From interface CommunicatorObserver
    public void notifyLabelMatch(String match, int score){
        getGameScreen().ProcessLabelMatch(match, score);
    }

    //From interface CommunicatorObserver
    public void startGame(String image, String partner){
        getPartnerFoundScreen().setPartnerName(partner);
        setCurrentScreen(getPartnerFoundScreen());

        setGameScreenParameters(image, partner);
        getTimer().scheduleASecondOnRegressiveCountingToStartPlaying();
    }

    private void setGameScreenParameters(String image, String partner){
        getGameScreen().setGameImage(image);
        getGameScreen().setPlayer1Name(getLoginName());
        getGameScreen().setPlayer2Name(partner);
    }

    public void notifySecondPassedOnRegressiveCountingToStartPlaying(){
        int counting = getPartnerFoundScreen().getRegressiveCounting();

        if(counting != 0){
            getPartnerFoundScreen().updateRegressiveCounting(ONE_SECOND);
            getTimer().scheduleASecondOnRegressiveCountingToStartPlaying();
        } else {
            setCurrentScreen(getGameScreen());
            getTimer().scheduleASecondOnRegressiveCountingToEndPlaying();
        }
    }

    public void notifySecondPassedOnRegressiveCountingToEndPlaying(){
        int counting = getGameScreen().getRegressiveCounting();

        if(counting != 0){
            getGameScreen().updateRegressiveCounting(ONE_SECOND);
            getTimer().scheduleASecondOnRegressiveCountingToEndPlaying();
        }
    }

    //From interface CommunicatorObserver
    public void endGame(GameSummary summary){
        getGameSummaryScreen().setPlayerName(getLoginName());
        getGameSummaryScreen().setMatchedLabelsList(summary.getMatches());
        getGameSummaryScreen().setFinalPontuation(summary.getScore());
        getGameSummaryScreen().setRank(summary.getTopPlayers());
        setCurrentScreen(getGameSummaryScreen());
    }

    //Connect Action
    public void connect(){
        try {
            setClientCommunicator(ClientCommunicatorSingleton.getCommunicator());
            getClientCommunicator().addObserver(this);
            setCurrentScreen(getLoginScreen());
        } catch (CommunicationException ex) {
            setCurrentScreen(getConnectionFailedScreen());
            ex.printStackTrace();
        }
    }

    //Button Identify Action
    public void identify(String loginName){
        setCurrentScreen(getWaitScreen());
       
        try {
            if( !getClientCommunicator().identify(loginName) ){
                setCurrentScreen(getServerBusyScreen());
            }
        } catch (CommunicationException ex) {
            ex.printStackTrace();
            setCurrentScreen(getConnectionLostScreen());
        }
    }

        //Send label Action
    public void sendLabel(String label){
        try {
            getClientCommunicator().sendLabel(label);
        } catch (CommunicationException ex) {
            ex.printStackTrace();
        }
    }

    //Button Penico Action
    public void penico(){
        try{
            getClientCommunicator().askPenico();
        } catch (CommunicationException ex) {
            ex.printStackTrace();
        }
    }

    //Button "Play again" Action
    public void playAgain(){
        setCurrentScreen(getWaitScreen());
        
        try {
            getClientCommunicator().notifyWait();
        } catch (CommunicationException ex) {
            ex.printStackTrace();
        }

    }

    //Button Ok Action
    public void ok(){
        System.exit(0);
    }

    //Button Cancel Action
    public void cancel(){
        System.exit(0);
    }

    //Button Exit Action
    public void exit(){
        System.exit(0);
    }

    public Communicator getClientCommunicator() {
        return clientCommunicator;
    }

    public void setClientCommunicator(Communicator clientCommunicator) {
        this.clientCommunicator = clientCommunicator;
    }

    public TimeoutTimer getTimer() {
        return timer;
    }

    public void setTimer(TimeoutTimer timer) {
        this.timer = timer;
    }

    public Screen getCurrentScreen() {
        return currentScreen;
    }

    public void setCurrentScreen(Screen currentScreen) {
        if (getCurrentScreen() != currentScreen){
            if (getCurrentScreen() != null) {
                getCurrentScreen().setActive(false);
            }
            this.currentScreen = currentScreen;
            getCurrentScreen().setActive(true);
        }
    }

    public ConnectionFailedScreen getConnectionFailedScreen() {
        return connectionFailedScreen;
    }

    public void setConnectionFailedScreen(ConnectionFailedScreen connectionFailedScreen) {
        this.connectionFailedScreen = connectionFailedScreen;
    }

    public ConnectionLostScreen getConnectionLostScreen() {
        return connectionLostScreen;
    }

    public void setConnectionLostScreen(ConnectionLostScreen connectionLostScreen) {
        this.connectionLostScreen = connectionLostScreen;
    }

    public GameScreen getGameScreen() {
        return gameScreen;
    }

    public void setGameScreen(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
    }

    public InterruptionGameScreen getInterruptionGameScreen() {
        return interruptionGameScreen;
    }

    public void setInterruptionGameScreen(InterruptionGameScreen interruptionGameScreen) {
        this.interruptionGameScreen = interruptionGameScreen;
    }

    public LoginScreen getLoginScreen() {
        return loginScreen;
    }

    public void setLoginScreen(LoginScreen loginScreen) {
        this.loginScreen = loginScreen;
    }

    public PartnerFoundScreen getPartnerFoundScreen() {
        return partnerFoundScreen;
    }

    public void setPartnerFoundScreen(PartnerFoundScreen partnerFoundScreen) {
        this.partnerFoundScreen = partnerFoundScreen;
    }

    public ServerBusyScreen getServerBusyScreen() {
        return serverBusyScreen;
    }

    public void setServerBusyScreen(ServerBusyScreen serverBusyScreen) {
        this.serverBusyScreen = serverBusyScreen;
    }

    public GameSummaryScreen getGameSummaryScreen() {
        return gameSummaryScreen;
    }

    public void setGameSummaryScreen(GameSummaryScreen gameSummaryScreen) {
        this.gameSummaryScreen = gameSummaryScreen;
    }

    public WaitScreen getWaitScreen() {
        return waitScreen;
    }

    public void setWaitScreen(WaitScreen waitScreen) {
        this.waitScreen = waitScreen;
    }
}
