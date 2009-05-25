/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.ImageLabelerServer;

import br.ita.ces31.ImageLabelerCommon.Server;
import br.ita.ces31.ImageLabelerServer.persistence.PlayerPersistenceSingleton;
import br.ita.ces31.ImageLabelerServer.timer.TimeoutTimerImpl;
import java.rmi.RemoteException;

/**
 *
 * @author Helder Suzuki <helder@aluno.ita.br>
 */
public class ServerSingleton {

    private static ServerImpl server;

    /**
     * Adquire instância de Server.
     * @return
     * @throws java.rmi.RemoteException
     */
    public synchronized static Server getServer() throws RemoteException {
        if (server == null) {
            server = new ServerImpl(
                PlayerPersistenceSingleton.getPlayerPersistence(),
                new ImageServerImpl(),
                new TimeoutTimerImpl());
        }

        return server;
    }
}
