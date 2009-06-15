/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.imagelabeler.server;

import br.ita.ces31.imagelabeler.common.Server;
import br.ita.ces31.imagelabeler.server.persistence.PlayerPersistenceSingleton;
import br.ita.ces31.imagelabeler.server.timer.TimeoutTimerImpl;
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
            TimeoutTimerImpl timer = new TimeoutTimerImpl();
            server = new ServerImpl(
                PlayerPersistenceSingleton.getPlayerPersistence(),
                new ImageServerImpl(),
                timer);
            timer.setServer(server);
        }

        return server;
    }
}
