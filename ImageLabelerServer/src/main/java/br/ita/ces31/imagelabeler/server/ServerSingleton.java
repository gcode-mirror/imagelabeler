/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.imagelabeler.server;

import br.ita.ces31.imagelabeler.server.image.ImageServerImpl;
import br.ita.ces31.imagelabeler.server.image.ImageServer;
import br.ita.ces31.imagelabeler.server.game.LengthGameBuilder;
import br.ita.ces31.imagelabeler.server.game.GameBuilder;
import br.ita.ces31.imagelabeler.common.Server;
import br.ita.ces31.imagelabeler.server.persistence.PlayerPersistence;
import br.ita.ces31.imagelabeler.server.persistence.PlayerPersistenceSingleton;
import br.ita.ces31.imagelabeler.server.scorer.ScoreCalculator;
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
            server = new ServerImpl(buildPlayerPersistence(),
                                    buildImageServer(),
                                    timer,
                                    buildGameBuilder());
            timer.setServer(server);
        }

        return server;
    }

    private static PlayerPersistence buildPlayerPersistence() {
        return PlayerPersistenceSingleton.getPlayerPersistence();
    }

    private static ImageServer buildImageServer() {
        return new ImageServerImpl();
    }

    private static GameBuilder buildGameBuilder() {
        return new LengthGameBuilder();
    }
}
