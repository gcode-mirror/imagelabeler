/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.ImageLabelerServer;

import br.ita.ces31.ImageLabelerCommon.Client;
import br.ita.ces31.ImageLabelerCommon.GameSummary;
import java.rmi.RemoteException;

/**
 *
 * @author Helder Suzuki <helder@aluno.ita.br>
 */
public class TestClient implements Client {

    private boolean loginNameCall = false;
    private String match;
    private int seconds = -1;
    private GameSummary summary;
    private boolean isAliveCall = false;
    private boolean isAliveResponse;
    public boolean canStartGame = false;
    public boolean canEndGame = false;
    public boolean canIsAlive = false;

    public String getLoginName() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void notifyMatch(String match) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void startGame(int seconds) throws RemoteException {
        if(canStartGame)
            throw new RemoteException("TEST: Call to startGame not expected!");
        this.seconds = seconds;
    }

    public void endGame(GameSummary summary) throws RemoteException {
        if(canEndGame)
            throw new RemoteException("TEST: Call to endGame not expected!");
        this.summary = summary;
    }

    public boolean isAlive() throws RemoteException {
        if(canIsAlive){
            throw new RemoteException("TEST: Call to isAlive not expected!");
        }
        isAliveCall = true;
        return isAliveResponse;
    }

    public void notifyPenico() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
