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
import br.ita.ces31.imagelabeler.client.ui.ConnectionFailedUI;
import br.ita.ces31.imagelabeler.client.ui.ConnectionLostUI;
import br.ita.ces31.imagelabeler.client.ui.GameUI;
import br.ita.ces31.imagelabeler.client.ui.InterruptionGameUI;
import br.ita.ces31.imagelabeler.client.ui.LoginUI;
import br.ita.ces31.imagelabeler.client.ui.PartnerFoundUI;
import br.ita.ces31.imagelabeler.client.ui.ServerBusyUI;
import br.ita.ces31.imagelabeler.client.ui.SummaryGameUI;
import br.ita.ces31.imagelabeler.client.ui.WaitUI;
import br.ita.ces31.imagelabeler.common.GameSummary;

/**
 *
 * @author diego
 */
public class Controller implements CommunicatorObserver, TimeoutNotifiable {

    private Communicator clientCommunicator;
    private TimeoutTimer timer;
    private ConnectionFailedUI connectionFailedUI;
    private ConnectionLostUI connectionLostUI;
    private GameUI gameUI;
    private InterruptionGameUI interruptionGameUI;
    private LoginUI loginUI;
    private PartnerFoundUI partnerFoundUI;
    private ServerBusyUI serverBusyUI;
    private SummaryGameUI summaryGameUI;
    private WaitUI waitUI;

    public Controller(){
        this.timer =  new TimeoutTimerImpl(this);
    }

    //From interface CommunicatorObserver
    public String getLoginName(){
        return ((ClientCommunicator) getClientCommunicator()).getLoginName();
    }

    //From interface CommunicatorObserver
    public void engGameByPenico(){

    }

    //From interface CommunicatorObserver
    public void notifyMatch(String match){

    }

    //From interface CommunicatorObserver
    public void startGame(String image, int seconds, String partner){
        getWaitUI().setVisible(false);
        
        getPartnerFoundUI().setPartnerName(partner);
        getPartnerFoundUI().setVisible(true);

        //prepare GameUI
        getGameUI().setImage(image);
        getGameUI().setPlayer1Name(getLoginName());
        getGameUI().setPlayer2Name(partner);

        timer.scheduleStartGameRegressiveCounting(1000);
    }

    public void notifySecondPassedOnStartGameRegressiveCounting(){
        int counting = getPartnerFoundUI().getRegressiveCounting();

        if(counting != 1){
            getPartnerFoundUI().updateRegressiveCounting();
            timer.scheduleStartGameRegressiveCounting(1000);
        } else {
            getPartnerFoundUI().setVisible(false);
            getGameUI().setVisible(true);
        }
    }

    //From interface CommunicatorObserver
    public void endGame(GameSummary summary){

    }

    public void notifySecondPassedOnEndGameRegressiveCounting(){
        int counting = getPartnerFoundUI().getRegressiveCounting();

        if(counting != 1){
            getPartnerFoundUI().updateRegressiveCounting();

            timer.scheduleEndGameRegressiveCounting(1000);
        } else {
            getPartnerFoundUI().setVisible(false);
            getGameUI().setVisible(true);
        }
    }

    public void connect(){
        try {
            setClientCommunicator(ClientCommunicatorSingleton.getCommunicator());
            getClientCommunicator().addObserver(this);
            getLoginUI().setVisible(true);
        } catch (CommunicationException ex) {
            getConnectionFailedUI().setVisible(true);
            ex.printStackTrace();
        }
    }

    public void identify(String loginName){
        getLoginUI().setVisible(false);
        getWaitUI().setVisible(true);
        
        try {
            if( !getClientCommunicator().identify(loginName) ){
                getServerBusyUI().setVisible(true);
            }
        } catch (CommunicationException ex) {
            ex.printStackTrace();
            getConnectionLostUI().setVisible(true);
        }
    }

    public void exit(){
        System.exit(0);
    }

    public void cancel(){
        System.exit(0);
    }

    public void penico(){
        //vai para a tela de interrupção de jogo
    }

    public void sendLabel(){
        //continua na mesma tela
    }

    public void playAgain(){
        // vai para a tela de espera
    }

    public void ok(){
        System.exit(0);
    }

    public Communicator getClientCommunicator() {
        return clientCommunicator;
    }

    public void setClientCommunicator(Communicator clientCommunicator) {
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

    public SummaryGameUI getSummaryGameUI() {
        return summaryGameUI;
    }

    public void setSummaryGameUI(SummaryGameUI summaryGameUI) {
        this.summaryGameUI = summaryGameUI;
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
}
