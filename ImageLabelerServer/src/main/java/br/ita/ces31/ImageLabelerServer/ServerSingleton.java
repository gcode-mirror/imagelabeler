/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.ImageLabelerServer;

import br.ita.ces31.ImageLabelerCommon.Server;
import br.ita.ces31.ImageLabelerServer.persistence.PlayerPersistenceSingleton;
import br.ita.ces31.ImageLabelerServer.timer.TimerImpl;
import java.rmi.RemoteException;

/**
 *
 * @author Helder Suzuki <helder@aluno.ita.br>
 */
public class ServerSingleton {

    private static ServerImpl server;

    public synchronized static Server getServer() throws RemoteException {
        if (server == null) {
            server = new ServerImpl();
            server.setTimer(new TimerImpl());
            server.setPlayerPersistence(
                    PlayerPersistenceSingleton.getPlayerPersistence());
            server.setImageServer(new ImageServerImpl());
        }

        return server;
    }
}
