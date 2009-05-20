/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.ImageLabelerServer;

import br.ita.ces31.ImageLabelerCommon.Client;
import br.ita.ces31.ImageLabelerCommon.GameSummary;
import java.rmi.RemoteException;
import java.rmi.server.RemoteObject;
import javax.management.RuntimeErrorException;

/**
 *
 * @author Helder Suzuki <helder@aluno.ita.br>
 */
public class TestClient extends RemoteObject implements Client {

    public String match = null;
    public int duration = -1;
    public GameSummary summary;
    public String loginName = "John";
    public boolean isAlive = true;
    public boolean penicoNotified = false;

    public String getLoginName() throws RemoteException {
        return loginName;
    }

    public void notifyMatch(String match) throws RemoteException {
        this.match = match;
    }

    public void startGame(int seconds) throws RemoteException {
        this.duration = seconds;
    }

    public void endGame(GameSummary summary) throws RemoteException {
        this.summary = summary;
    }

    public boolean isAlive() throws RemoteException {
        return isAlive;
    }

    public void notifyPenico() throws RemoteException {
        penicoNotified = true;
    }
}
