package br.ita.ces31.ImageLabelerClient.ui.Controller;

import br.ita.ces31.ImageLabelerClient.communicator.ClientCommunicator;
import br.ita.ces31.ImageLabelerClient.communicator.ClientCommunicatorSingleton;
import br.ita.ces31.ImageLabelerClient.communicator.CommunicationException;
import br.ita.ces31.ImageLabelerClient.communicator.Communicator;
import br.ita.ces31.ImageLabelerClient.communicator.CommunicatorObserver;
import br.ita.ces31.ImageLabelerClient.timer.TimeoutNotifiable;
import br.ita.ces31.ImageLabelerClient.timer.TimeoutTimer;
import br.ita.ces31.ImageLabelerClient.timer.TimeoutTimerImpl;
import br.ita.ces31.ImageLabelerClient.ui.ConnectionFailedUI;
import br.ita.ces31.ImageLabelerClient.ui.ConnectionLostUI;
import br.ita.ces31.ImageLabelerClient.ui.GameUI;
import br.ita.ces31.ImageLabelerClient.ui.LoginUI;
import br.ita.ces31.ImageLabelerClient.ui.PartnerFoundUI;
import br.ita.ces31.ImageLabelerClient.ui.ServerBusyUI;
import br.ita.ces31.ImageLabelerClient.ui.UserInterface;
import br.ita.ces31.ImageLabelerClient.ui.WaitUI;
import br.ita.ces31.ImageLabelerCommon.GameSummary;

/**
 *
 * @author diego
 */
public class Controller implements CommunicatorObserver, TimeoutNotifiable {

    private Communicator clientCommunicator;
    private TimeoutTimer timer;
    private UserInterface connectionFailedUI;
    private UserInterface connectionLostUI;
    private UserInterface gameUI;
    private UserInterface interruptionGameUI;
    private UserInterface loginUI;
    private UserInterface partnerFoundUI;
    private UserInterface serverBusyUI;
    private UserInterface summaryGameUI;
    private UserInterface waitUI;

    public Controller(){
        this.timer =  new TimeoutTimerImpl(this);
    }

    public String getLoginName(){
        return ((ClientCommunicator) getClientCommunicator()).getLoginName();
    }

    public void engGameByPenico(){

    }

    public void notifyMatch(String match){

    }

    public void startGame(String image, int seconds, String partner){
        ((WaitUI) getWaitUI()).setVisible(false);
        
        ((PartnerFoundUI) getPartnerFoundUI()).setPartnerName(getLoginName());
        ((PartnerFoundUI) getPartnerFoundUI()).setVisible(true);

        ((GameUI) getGameUI()).setImage(image);
        ((GameUI) getGameUI()).setPlayer1Name(getLoginName());
        ((GameUI) getGameUI()).setPlayer2Name(partner);


        timer.scheduleRegressiveCounting(1000);
    }

    public void notifySecondPassedOnRegressiveCounting(){
        int counting = ((PartnerFoundUI) getPartnerFoundUI()).getRegressiveCounting();

        if(counting != 1){
            ((PartnerFoundUI) getPartnerFoundUI()).updateRegressiveCounting();

            timer.scheduleRegressiveCounting(1000);
        } else {
            ((PartnerFoundUI) getPartnerFoundUI()).setVisible(false);
            ((GameUI) getGameUI()).setVisible(true);
        }
    }

    public void endGame(GameSummary summary){

    }

    public void connect(){
        try {
            setClientCommunicator(ClientCommunicatorSingleton.getCommunicator());
            getClientCommunicator().addObserver(this);
            ((LoginUI) getLoginUI()).setVisible(true);
        } catch (CommunicationException ex) {
            ((ConnectionFailedUI) getConnectionFailedUI()).setVisible(true);
            ex.printStackTrace();
        }
    }

    public void identify(String loginName){
        ((LoginUI) getLoginUI()).setVisible(false);
        ((WaitUI) getWaitUI()).setVisible(true);
        try {
            if( !getClientCommunicator().identify(loginName) ){
                ((ServerBusyUI) getServerBusyUI()).setVisible(true);
            }
        } catch (CommunicationException ex) {
            ex.printStackTrace();
            ((ConnectionLostUI) getConnectionLostUI()).setVisible(true);
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

    public void setConnectionFailedUI(UserInterface connectionFailedUI) {
        this.connectionFailedUI = connectionFailedUI;
    }

    public void setConnectionLostUI(UserInterface connectionLostUI) {
        this.connectionLostUI = connectionLostUI;
    }

    public void setGameUI(UserInterface gameUI) {
        this.gameUI = gameUI;
    }

    public void setInterruptionGameUI(UserInterface interruptionGameUI) {
        this.interruptionGameUI = interruptionGameUI;
    }

    public void setLoginUI(UserInterface loginUI) {
        this.loginUI = loginUI;
    }

    public void setPartnerFoundUI(UserInterface partnerFoundUI) {
        this.partnerFoundUI = partnerFoundUI;
    }

    public void setServerBusyUI(UserInterface serverBusyUI) {
        this.serverBusyUI = serverBusyUI;
    }

    public void setSummaryGameUI(UserInterface summaryGameUI) {
        this.summaryGameUI = summaryGameUI;
    }

    public void setWaitUI(UserInterface waitUI) {
        this.waitUI = waitUI;
    }

    public UserInterface getConnectionFailedUI() {
        return connectionFailedUI;
    }

    public UserInterface getConnectionLostUI() {
        return connectionLostUI;
    }

    public UserInterface getGameUI() {
        return gameUI;
    }

    public UserInterface getInterruptionGameUI() {
        return interruptionGameUI;
    }

    public UserInterface getLoginUI() {
        return loginUI;
    }

    public UserInterface getPartnerFoundUI() {
        return partnerFoundUI;
    }

    public UserInterface getServerBusyUI() {
        return serverBusyUI;
    }

    public UserInterface getSummaryGameUI() {
        return summaryGameUI;
    }

    public UserInterface getWaitUI() {
        return waitUI;
    }
}
