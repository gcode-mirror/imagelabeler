/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.imagelabeler.server;

import br.ita.ces31.imagelabeler.common.Client;
import br.ita.ces31.imagelabeler.common.GameSummary;
import java.rmi.RemoteException;
import java.rmi.server.RemoteObject;

/**
 *
 * @author Helder Suzuki <helder@aluno.ita.br>
 */
public class TestClient extends RemoteObject implements Client {

    public String match;
    public boolean startGameCalled = false;
    public GameSummary summary;
    public String loginName = "John";
    public boolean isAlive = true;
    public boolean penicoNotified = false;
    public String image;

    public String getLoginName() throws RemoteException {
        return loginName;
    }

    public void notifyLabelMatch(String match, int score) throws RemoteException {
        this.match = match;
    }

    public void startGame(String image, String partner) throws RemoteException {
        this.image = image;
        this.startGameCalled = true;
    }

    public void endGame(GameSummary summary) throws RemoteException {
        this.summary = summary;
    }

    public boolean isAlive() throws RemoteException {
        if (isAlive) {
            return true;
        } else {
            throw new RemoteException();
        }
    }

    public void notifyPenico() throws RemoteException {
        penicoNotified = true;
    }
}
