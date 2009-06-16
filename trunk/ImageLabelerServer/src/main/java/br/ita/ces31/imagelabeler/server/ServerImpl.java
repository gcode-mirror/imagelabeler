/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.imagelabeler.server;

import br.ita.ces31.imagelabeler.server.image.ImageServer;
import br.ita.ces31.imagelabeler.server.game.Game;
import br.ita.ces31.imagelabeler.server.game.GameBuilder;
import br.ita.ces31.imagelabeler.server.timer.TimeoutNotifiable;
import br.ita.ces31.imagelabeler.server.persistence.PersistenceException;
import br.ita.ces31.imagelabeler.server.timer.TimeoutTimer;
import br.ita.ces31.imagelabeler.common.Client;
import br.ita.ces31.imagelabeler.common.GameSummary;
import br.ita.ces31.imagelabeler.common.Player;
import br.ita.ces31.imagelabeler.common.Server;
import br.ita.ces31.imagelabeler.server.persistence.PlayerPersistence;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Helder Suzuki <helder@aluno.ita.br>
 */
public class ServerImpl extends UnicastRemoteObject
    implements Server, TimeoutNotifiable {

    private PlayerPersistence playerPersistence;
    private ImageServer imageServer;
    private TimeoutTimer timer;
    private ServerState state;
    private GameBuilder gameBuilder;

    public ServerImpl(PlayerPersistence playerPersistence,
                      ImageServer imageServer,
                      TimeoutTimer timer,
                      GameBuilder gameBuilder) throws RemoteException {
        this.playerPersistence = playerPersistence;
        this.imageServer = imageServer;
        this.timer = timer;
        this.gameBuilder = gameBuilder;
        this.state = new FreeState();
    }

    private boolean isConnected(Client c) {
        boolean test = false;

        try {
            test = c.isAlive();
        } catch (RemoteException ex) {
        }

        return test;
    }

    /*
     * Caso de uso 1.4.2.2.1 b) Identificar participante
     * Realiza identificação do cliente.
     */
    public synchronized boolean identify(Client client) throws RemoteException {
        return state.identify(client);
    }

    /*
     * Caso de uso 1.4.2.2.1 e) Aguardar Início de Partida
     */
    public synchronized void notifyWait(Client client) throws RemoteException {
        state.notifyWait(client);
    }

    /*
     * 1.4.1.2.2.1h) Caso de Uso: Notificar Cancelamento da Espera
     */
    public synchronized void cancelWait(Client client) throws RemoteException {
        state.cancelWait(client);
    }

    /*
     * Caso de uso 1.4.2.2.1 c) Registrar Rótulo
     * Envia rótulo.
     */
    public synchronized void sendLabel(String label) throws RemoteException {
        state.sendLabel(label);
    }

    /*
     * 1.4.2.2.2 a) Caso de Uso: Notificar Término
     */
    public synchronized void notifyTimeout() {
        state.notifyTimeout();
    }

    /*
     * 1.4.2.2.1f) Caso de Uso:  Notificar Desistência
     */
    public synchronized void notifyPenico() throws RemoteException {
        state.notifyPenico();
    }

    /* 0 clientes identificados, 0 em espera */
    class FreeState extends ServerState {

        @Override
        public boolean identify(Client client) throws RemoteException {
            state = new OneIdentifiedState(client);
            return true;
        }

        @Override
        public String toString() {
            return "FreeState";
        }
    }

    /* 1 cliente identificado, 0 em espera */
    class OneIdentifiedState extends ServerState {

        private Client client;

        public OneIdentifiedState(Client client) {
            this.client = client;
        }

        @Override
        public boolean identify(Client client) throws RemoteException {
            if (this.client != client) {
                state = new FullState(this.client, client);
            }
            return true;
        }

        @Override
        public void notifyWait(Client client) throws RemoteException {
            if (this.client.equals(client)) {
                state = new OneIdentifiedWaitingState(client);
            }
        }

        @Override
        public String toString() {
            return "OneIdentifiedState";
        }
    }

    /* 1 cliente identificado, 1 em espera */
    class OneIdentifiedWaitingState extends ServerState {

        private Client waitingClient;

        public OneIdentifiedWaitingState(Client waitingClient) {
            this.waitingClient = waitingClient;
        }

        @Override
        public boolean identify(Client client) throws RemoteException {
            state = new FullWaitingState(waitingClient, client);
            return true;
        }

        @Override
        public void cancelWait(Client client) throws RemoteException {
            if (waitingClient.equals(client)) {
                state = new FreeState();
            }
        }

        @Override
        public String toString() {
            return "OneIdentifiedWaitingState";
        }
    }

    /* 2 clientes identificados, 0 em espera */
    class FullState extends ServerState {

        private Client client1,  client2;

        public FullState(Client client1, Client client2) {
            this.client1 = client1;
            this.client2 = client2;
        }

        @Override
        public void notifyWait(Client client) throws RemoteException {
            if (client.equals(client1)) {
                state = new FullWaitingState(client, client2);
            } else if (client.equals(client2)) {
                state = new FullWaitingState(client, client1);
            }
        }

        @Override
        public boolean identify(Client client) throws RemoteException {
            if (!isConnected(client1)) {
                client1 = client;
                return true;
            }

            if (!isConnected(client2)) {
                client2 = client;
                return true;
            }

            return false;
        }

        @Override
        public String toString() {
            return "FullState";
        }
    }

    /* 2 clientes identificados, 1 em espera */
    class FullWaitingState extends ServerState {

        private Client waitingClient,  client;

        public FullWaitingState(Client waitingClient, Client client) {
            this.waitingClient = waitingClient;
            this.client = client;
        }

        @Override
        public void notifyWait(Client client) throws RemoteException {
            if (this.client.equals(client)) {
                if (isConnected(waitingClient)) {
                    Game game = startGame(waitingClient, client);
                    state = new InGameState(game, waitingClient, client);
                } else {
                    state = new OneIdentifiedWaitingState(client);
                }
            }
        }

        @Override
        public void cancelWait(Client client) throws RemoteException {
            if (client.equals(waitingClient)) {
                state = new OneIdentifiedState(this.client);
            }
        }

        @Override
        public boolean identify(Client client) throws RemoteException {
            if (!isConnected(waitingClient)) {
                state = new FullState(this.client, client);
                return true;
            }

            if (!isConnected(this.client)) {
                this.client = client;
                return true;
            }

            return false;
        }

        private Game startGame(Client client1, Client client2) throws RemoteException {
            Game game = gameBuilder.buildGame(client1, client2);
            timer.schedule(Game.duration * 1000);

            String image = imageServer.getImage();
            client1.startGame(image, Game.duration, client2.getLoginName());
            client2.startGame(image, Game.duration, client1.getLoginName());
            return game;
        }

        @Override
        public String toString() {
            return "FullWaitingState";
        }
    }

    /* Partida em curso */
    class InGameState extends ServerState {

        Client client1, client2;
        private Game game;

        public InGameState(Game game, Client client1, Client client2) {
            this.game = game;
            this.client1 = client1;
            this.client2 = client2;
        }

        @Override
        public void notifyPenico() throws RemoteException {
            try {
                client1.notifyPenico();
            } catch (Exception e) {
            }

            try {
                client2.notifyPenico();
            } catch (Exception e) {
            }

            timer.cancel();

            state = new FullState(client1, client2);
        }

        @Override
        public void notifyTimeout() {
            try {
                updateScore(game);
            } catch (Exception e) {
                e.printStackTrace();
            }
            GameSummary summary = getGameSummary(game);

            try {
                client1.endGame(summary);
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }

            try {
                client2.endGame(summary);
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }

            state = new FullState(client1, client2);
        }

        @Override
        public void sendLabel(String label) throws RemoteException {
            if (game.addLabel(label)) {  // ocorreu match
                try {
                    client1.notifyMatch(label, game.getScore());
                } catch (RemoteException ex) {
                    ex.printStackTrace();
                }

                try {
                    client2.notifyMatch(label, game.getScore());
                } catch (RemoteException ex) {
                    ex.printStackTrace();
                }
            }
        }

        private void updateScore(Game game) throws PersistenceException, RemoteException {
            int score = game.getScore();
            Player p1 = playerPersistence.getPlayer(game.getClient1().getLoginName());
            Player p2 = playerPersistence.getPlayer(game.getClient2().getLoginName());

            p1.setScore(p1.getScore() + score);
            p2.setScore(p2.getScore() + score);
            playerPersistence.update(p1);
            playerPersistence.update(p2);
        }

        private GameSummary getGameSummary(Game game) {
            try {
                ArrayList<Player> rank;
                rank = playerPersistence.getBestPlayers(10);
                return new GameSummary(game.getScore(), rank,
                                       game.getMatches());
            } catch (Exception ex) {
                ex.printStackTrace();
                return new GameSummary();
            }
        }

        @Override
        public String toString() {
            return "InGameState";
        }
    }

    @Override
    public String toString() {
        return state.toString();
    }
}

abstract class ServerState implements Server, TimeoutNotifiable {

    public boolean identify(Client client) throws RemoteException {
        return false;
    }

    public void notifyTimeout() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void notifyPenico() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void notifyWait(Client client) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void cancelWait(Client client) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void sendLabel(String label) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
