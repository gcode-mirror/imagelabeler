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
import br.ita.ces31.imagelabeler.client.ui.ConnectionFailedUI;
import br.ita.ces31.imagelabeler.client.ui.ConnectionLostUI;
import br.ita.ces31.imagelabeler.client.ui.GameUI;
import br.ita.ces31.imagelabeler.client.ui.InterruptionGameUI;
import br.ita.ces31.imagelabeler.client.ui.LoginUI;
import br.ita.ces31.imagelabeler.client.ui.PartnerFoundUI;
import br.ita.ces31.imagelabeler.client.ui.ServerBusyUI;
import br.ita.ces31.imagelabeler.client.ui.GameSummaryUI;
import br.ita.ces31.imagelabeler.client.ui.UserInterface;
import br.ita.ces31.imagelabeler.client.ui.WaitUI;
import br.ita.ces31.imagelabeler.common.GameSummary;

/**
 *
 * @author diego
 */
public class Controller implements CommunicatorObserver, TimeoutNotifiable {

    private ClientCommunicator clientCommunicator;
    private TimeoutTimer timer;
    private UserInterface currentUI;
    private ConnectionFailedUI connectionFailedUI;
    private ConnectionLostUI connectionLostUI;
    private GameUI gameUI;
    private InterruptionGameUI interruptionGameUI;
    private LoginUI loginUI;
    private PartnerFoundUI partnerFoundUI;
    private ServerBusyUI serverBusyUI;
    private GameSummaryUI gameSummaryUI;
    private WaitUI waitUI;

    public Controller(){
        this.timer =  new TimeoutTimerImpl(this);
    }

    //From interface CommunicatorObserver
    public String getLoginName(){
        return getClientCommunicator().getLoginName();
    }

    //From interface CommunicatorObserver
    public void endGameByPenico(){
        timer.cancelRegressiveCounting();
        setCurrentUI(getInterruptionGameUI());
    }

    //From interface CommunicatorObserver
    public void notifyMatch(String match, int score){
        getGameUI().notifyMatch(match, score);
    }

    //From interface CommunicatorObserver
    public void startGame(String image, int seconds, String partner){
        getPartnerFoundUI().setPartnerName(partner);
        setCurrentUI(getPartnerFoundUI());
        setGameUIInitialParameters(image, seconds, partner);
        timer.scheduleStartGameRegressiveCounting(1000);
    }

    public void setGameUIInitialParameters(String image, int seconds, String partner){
        getGameUI().setImage(image);
        getGameUI().setPlayer1Name(getLoginName());
        getGameUI().setPlayer2Name(partner);
        //verificar aonde setar esse seconds
    }

    public void notifySecondPassedOnStartGameRegressiveCounting(){
        int counting = getPartnerFoundUI().getRegressiveCounting();

        if(counting != 1){
            getPartnerFoundUI().updateRegressiveCounting();
            timer.scheduleStartGameRegressiveCounting(1000);
        } else {
            setCurrentUI(getGameUI());
            timer.scheduleEndGameRegressiveCounting(1000);
        }
    }

    public void notifySecondPassedOnEndGameRegressiveCounting(){
        int counting = getGameUI().getRegressiveCounting();

        if(counting != 1){
            getGameUI().updateRegressiveCounting();
            timer.scheduleEndGameRegressiveCounting(1000);
        }
    }

    //From interface CommunicatorObserver
    public void endGame(GameSummary summary){
        getGameSummaryUI().setListMatchedLabels(summary.getMatches());
        getGameSummaryUI().setFinalPontuation(summary.getScore());
        getGameSummaryUI().setPlayerName(getLoginName());
        getGameSummaryUI().setRank(summary.getTopPlayers());
        setCurrentUI(getGameSummaryUI());
    }

    public void connect(){
        try {
            setClientCommunicator(ClientCommunicatorSingleton.getCommunicator());
            getClientCommunicator().addObserver(this);
            setCurrentUI(getLoginUI());
        } catch (CommunicationException ex) {
            setCurrentUI(getConnectionFailedUI());
            ex.printStackTrace();
        }
    }

    public void identify(String loginName){
        setCurrentUI(getWaitUI());
       
        try {
            if( !getClientCommunicator().identify(loginName) ){
                setCurrentUI(getServerBusyUI());
            }
        } catch (CommunicationException ex) {
            ex.printStackTrace();
            setCurrentUI(getConnectionLostUI());
        }
    }

    public void exit(){
        System.exit(0);
    }

    public void cancel(){
        System.exit(0);
    }

    public void penico(){
        try{
            getClientCommunicator().askPenico();
        } catch (CommunicationException ex) {
            ex.printStackTrace();
        }
    }

    public void sendLabel(String label){
        try {
            getClientCommunicator().sendLabel(label);
        } catch (CommunicationException ex) {
            ex.printStackTrace();
        }
    }

    public void playAgain(){
        try {
            getClientCommunicator().notifyWait();
        } catch (CommunicationException ex) {
            ex.printStackTrace();
        }
        setCurrentUI(getWaitUI());
    }

    public void ok(){
        System.exit(0);
    }

    public ClientCommunicator getClientCommunicator() {
        return clientCommunicator;
    }

    public void setClientCommunicator(ClientCommunicator clientCommunicator) {
        this.clientCommunicator = clientCommunicator;
    }

    public ConnectionFailedUI getConnectionFailedUI() {
        return connectionFailedUI;
    }

    public void setConnectionFailedUI(ConnectionFailedUI connectionFailedUI) {
        this.connectionFailedUI = connectionFailedUI;
    }

    public ConnectionLostUI getConnectionLostUI() {
        return connectionLostUI;
    }

    public void setConnectionLostUI(ConnectionLostUI connectionLostUI) {
        this.connectionLostUI = connectionLostUI;
    }

    public GameUI getGameUI() {
        return gameUI;
    }

    public void setGameUI(GameUI gameUI) {
        this.gameUI = gameUI;
    }

    public InterruptionGameUI getInterruptionGameUI() {
        return interruptionGameUI;
    }

    public void setInterruptionGameUI(InterruptionGameUI interruptionGameUI) {
        this.interruptionGameUI = interruptionGameUI;
    }

    public LoginUI getLoginUI() {
        return loginUI;
    }

    public void setLoginUI(LoginUI loginUI) {
        this.loginUI = loginUI;
    }

    public PartnerFoundUI getPartnerFoundUI() {
        return partnerFoundUI;
    }

    public void setPartnerFoundUI(PartnerFoundUI partnerFoundUI) {
        this.partnerFoundUI = partnerFoundUI;
    }

    public ServerBusyUI getServerBusyUI() {
        return serverBusyUI;
    }

    public void setServerBusyUI(ServerBusyUI serverBusyUI) {
        this.serverBusyUI = serverBusyUI;
    }

    public GameSummaryUI getGameSummaryUI() {
        return gameSummaryUI;
    }

    public void setGameSummaryUI(GameSummaryUI gameSummaryUI) {
        this.gameSummaryUI = gameSummaryUI;
    }

    public TimeoutTimer getTimer() {
        return timer;
    }

    public void setTimer(TimeoutTimer timer) {
        this.timer = timer;
    }

    public WaitUI getWaitUI() {
        return waitUI;
    }

    public void setWaitUI(WaitUI waitUI) {
        this.waitUI = waitUI;
    }

    public UserInterface getCurrentUI() {
        return currentUI;
    }

    public void setCurrentUI(UserInterface currentUI) {
        if (this.currentUI != currentUI){
            if (this.currentUI != null) {
                this.currentUI.setVisible(false);
            }
            this.currentUI = currentUI;
            this.currentUI.setVisible(true);
        }
    }
}
