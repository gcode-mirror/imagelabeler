/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.imagelabeler.client.controller;

import br.ita.ces31.imagelabeler.client.communicator.ClientCommunicator;
import br.ita.ces31.imagelabeler.client.communicator.ClientCommunicatorSingleton;
import br.ita.ces31.imagelabeler.client.communicator.CommunicationException;
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
import br.ita.ces31.imagelabeler.common.Player;
import java.util.List;
import java.util.MissingResourceException;

/**
 *
 * @author diego
 */
public class Controller implements CommunicatorObserver, TimeoutNotifiable {
    private TimeoutTimer timeoutTimer;
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

    //Constructor
    public Controller(){
        setTimeoutTimer(new TimeoutTimerImpl(this));
    }

    //From interface CommunicatorObserver
    @Override
    public void startGame(String imagePath, String partnerName){
        setPartnerFoundScreenParameters(partnerName);
        setCurrentScreen(getPartnerFoundScreen());

        setGameScreenParameters(imagePath, partnerName);
        getTimeoutTimer().scheduleRegressiveCountingToStartPlaying();
    }

    private void setPartnerFoundScreenParameters(String partnerName){
        getPartnerFoundScreen().setPartnerName(partnerName);
    }
    
    private void setGameScreenParameters(String imagePath, String partnerName){
        try {
            getGameScreen().setGameImage(imagePath);
        } catch (MissingResourceException ex) {
            ex.printStackTrace();
        }
        
        getGameScreen().setPlayer1Name(getLoginName());
        getGameScreen().setPlayer2Name(partnerName);
    }

    //From interface CommunicatorObserver
    @Override
    public void notifyLabelMatch(String match, int score){
        getGameScreen().ProcessLabelMatch(match, score);
    }

    //From interface CommunicatorObserver
    @Override
    public void endGameByPenico(){
        getTimeoutTimer().cancelRegressiveCounting();
        setCurrentScreen(getInterruptionGameScreen());
    }

    //From interface CommunicatorObserver
    @Override
    public void endGame(GameSummary summary){
        setGameSummaryScreenParameters(summary.getMatches(), summary.getScore(), summary.getTopPlayers());
        setCurrentScreen(getGameSummaryScreen());
    }

    private void setGameSummaryScreenParameters(List<String> matches, int finalScore, List<Player> topPlayers){
        getGameSummaryScreen().setPlayerName(getLoginName());
        getGameSummaryScreen().setMatchedLabelsList(matches);
        getGameSummaryScreen().setFinalPontuation(finalScore);
        getGameSummaryScreen().setRank(topPlayers);
    }
    
    //From interface TimeoutNotifiable
    @Override
    public void notifySecondPassedOnRegressiveCountingToStartPlaying(){
        int counting = getPartnerFoundScreen().getRegressiveCounting();

        if(counting != 0){
            getPartnerFoundScreen().updateRegressiveCounting(ONE_SECOND);
            getTimeoutTimer().continueRegressiveCountingToStartPlaying();
        } else {
            setCurrentScreen(getGameScreen());
            getTimeoutTimer().scheduleRegressiveCountingToEndPlaying();
        }
    }

    //From interface TimeoutNotifiable
    @Override
    public void notifySecondPassedOnRegressiveCountingToEndPlaying(){
        int counting = getGameScreen().getRegressiveCounting();

        if(counting != 0){
            getGameScreen().updateRegressiveCounting(ONE_SECOND);
            getTimeoutTimer().continueRegressiveCountingToEndPlaying();
        }
    }

    private String getLoginName(){
        String loginName = "";
        try {
            ClientCommunicator communicator = (ClientCommunicator) ClientCommunicatorSingleton.getCommunicator();
            loginName = communicator.getLoginName();
        } catch (CommunicationException ex){
            ex.printStackTrace();
        }
        return loginName;
    }

    public void startClient(){
        setCurrentScreen(getLoginScreen());
    }

    public void notifyConnectionFailed(){
        setCurrentScreen(getConnectionFailedScreen());
    }

    private void notifyConnectionLost(){
        setCurrentScreen(getConnectionLostScreen());
    }

    //Button Identify Action
    public void identify(String loginName){
        setCurrentScreen(getWaitScreen());
       
        try {
            if( !ClientCommunicatorSingleton.getCommunicator().identify(loginName) ){
                setCurrentScreen(getServerBusyScreen());
            }
        } catch (CommunicationException ex) {
            ex.printStackTrace();
            notifyConnectionLost();
        }
    }

    //Send label Action
    public void sendLabel(String label){
        try {
            ClientCommunicatorSingleton.getCommunicator().sendLabel(label);
        } catch (CommunicationException ex) {
            ex.printStackTrace();
            notifyConnectionLost();
        }
    }

    //Button Penico Action
    public void penico(){
        try{
            ClientCommunicatorSingleton.getCommunicator().askPenico();
        } catch (CommunicationException ex) {
            ex.printStackTrace();
            notifyConnectionLost();
        }
    }

    //Button "Play again" Action
    public void playAgain(){
        setCurrentScreen(getWaitScreen());
        
        try {
            ClientCommunicatorSingleton.getCommunicator().notifyWait();
        } catch (CommunicationException ex) {
            ex.printStackTrace();
            notifyConnectionLost();
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

    public TimeoutTimer getTimeoutTimer() {
        return timeoutTimer;
    }

    public void setTimeoutTimer(TimeoutTimer timeoutTimer) {
        this.timeoutTimer = timeoutTimer;
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
        if(connectionFailedScreen != null){
            connectionFailedScreen.setController(this);
        }
        this.connectionFailedScreen = connectionFailedScreen;
    }

    public ConnectionLostScreen getConnectionLostScreen() {
        return connectionLostScreen;
    }

    public void setConnectionLostScreen(ConnectionLostScreen connectionLostScreen) {
        if(connectionLostScreen != null){
            connectionLostScreen.setController(this);
        }
        this.connectionLostScreen = connectionLostScreen;
    }

    public GameScreen getGameScreen() {
        return gameScreen;
    }

    public void setGameScreen(GameScreen gameScreen) {
        if(gameScreen != null){
            gameScreen.setController(this);
        }
        this.gameScreen = gameScreen;
    }

    public GameSummaryScreen getGameSummaryScreen() {
        return gameSummaryScreen;
    }

    public void setGameSummaryScreen(GameSummaryScreen gameSummaryScreen) {
        if(gameSummaryScreen != null){
            gameSummaryScreen.setController(this);
        }
        this.gameSummaryScreen = gameSummaryScreen;
    }
    
    public InterruptionGameScreen getInterruptionGameScreen() {
        return interruptionGameScreen;
    }

    public void setInterruptionGameScreen(InterruptionGameScreen interruptionGameScreen) {
        if(interruptionGameScreen != null){
            interruptionGameScreen.setController(this);
        }
        this.interruptionGameScreen = interruptionGameScreen;
    }

    public LoginScreen getLoginScreen() {
        return loginScreen;
    }

    public void setLoginScreen(LoginScreen loginScreen) {
        if(loginScreen != null){
            loginScreen.setController(this);
        }
        this.loginScreen = loginScreen;
    }

    public PartnerFoundScreen getPartnerFoundScreen() {
        return partnerFoundScreen;
    }

    public void setPartnerFoundScreen(PartnerFoundScreen partnerFoundScreen) {
        if(partnerFoundScreen != null){
            partnerFoundScreen.setController(this);
        }
        this.partnerFoundScreen = partnerFoundScreen;
    }

    public ServerBusyScreen getServerBusyScreen() {
        return serverBusyScreen;
    }

    public void setServerBusyScreen(ServerBusyScreen serverBusyScreen) {
        if(serverBusyScreen != null){
            serverBusyScreen.setController(this);
        }
        this.serverBusyScreen = serverBusyScreen;
    }

    public WaitScreen getWaitScreen() {
        return waitScreen;
    }

    public void setWaitScreen(WaitScreen waitScreen) {
        if(waitScreen != null){
            waitScreen.setController(this);
        }
        this.waitScreen = waitScreen;
    }
}
