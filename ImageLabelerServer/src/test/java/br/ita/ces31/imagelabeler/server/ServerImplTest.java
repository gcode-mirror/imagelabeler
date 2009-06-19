package br.ita.ces31.imagelabeler.server;

import br.ita.ces31.imagelabeler.server.image.ImageServerImpl;
import br.ita.ces31.imagelabeler.server.game.LengthGameBuilder;
import br.ita.ces31.imagelabeler.server.game.Game;
import br.ita.ces31.imagelabeler.server.game.GameBuilder;
import br.ita.ces31.imagelabeler.common.Player;
import java.rmi.RemoteException;
import java.util.List;
import junit.framework.TestCase;

/*
 * Image Labeler - Projeto de CES-31
 */
/**
 *
 * @author Helder Suzuki <helder@aluno.ita.br>
 */
public class ServerImplTest extends TestCase {

    private ServerImpl server;
    private TestClient client1,  client2,  client3,  client4;
    private TestPlayerPersistence playerPersistance;
    TestTimer timer;
    private ImageServerImpl imageServer;
    private GameBuilder gameBuilder;

    @Override
    public void setUp() throws RemoteException {
        client1 = new TestClient();
        client2 = new TestClient();
        client3 = new TestClient();
        client4 = new TestClient();

        playerPersistance = new TestPlayerPersistence();
        imageServer = new ImageServerImpl();
        timer = new TestTimer();
        gameBuilder = new LengthGameBuilder();

        server = new ServerImpl(playerPersistance, imageServer, timer,
                                gameBuilder);

    }

    // Exercita caso em que só podem existir 2 identificados.
    public void testIdentifyThirdClient() throws RemoteException {
        assertTrue(server.identify(client1));
        assertTrue(server.identify(client2));
        assertFalse(server.identify(client3));
    }
/*
    // Fluxo de sucesso.
    public void testStartGame() throws RemoteException {
        server.identify(client1);
        server.notifyWait(client1);

        server.identify(client2);
        server.notifyWait(client2);

        assertTrue(client1.startGameCalled);
        assertTrue(client2.startGameCalled);
    }

    public void testStartGame2() throws RemoteException {
        server.identify(client1);
        server.identify(client2);

        server.notifyWait(client1);
        server.notifyWait(client2);

        assertEquals(Game.duration, client1.duration);
        assertEquals(Game.duration, client2.duration);
    }

    public void testStartGame3() throws RemoteException {
        server.identify(client1);
        server.identify(client2);

        server.notifyWait(client2);
        server.notifyWait(client1);

        assertEquals(Game.duration, client1.duration);
        assertEquals(Game.duration, client2.duration);
        assertEquals(client1.image, client2.image);
        assertNotNull(client1.image);
    }

    // exercita casos em que client1 cai e client3 entra depois.
    public void testStartGameNotAlive() throws RemoteException {
        server.identify(client1);
        server.identify(client2);
        server.notifyWait(client1);

        client1.isAlive = false;
        server.notifyWait(client2);

        assertEquals(-1, client1.duration);
        assertEquals(-1, client2.duration);

        server.identify(client3);
        server.notifyWait(client3);
        assertEquals(Game.duration, client2.duration);
        assertEquals(Game.duration, client3.duration);
    }

    public void testStartGameNotAlive2() throws RemoteException {
        server.identify(client1);
        server.notifyWait(client1);

        server.identify(client2);
        client1.isAlive = false;
        server.notifyWait(client2);

        assertEquals(-1, client1.duration);
        assertEquals(-1, client2.duration);

        server.identify(client3);
        server.notifyWait(client3);
        assertEquals(Game.duration, client2.duration);
        assertEquals(Game.duration, client3.duration);
    }

    public void testStartGameNotAlive3() throws RemoteException {
        server.identify(client1);
        server.notifyWait(client1);
        client1.isAlive = false;

        server.identify(client2);
        server.notifyWait(client2);

        assertEquals(-1, client1.duration);
        assertEquals(-1, client2.duration);

        server.identify(client3);
        server.notifyWait(client3);
        assertEquals(Game.duration, client2.duration);
        assertEquals(Game.duration, client3.duration);
    }

    public void testThirdPlayerWithDropDuringGame() throws RemoteException {
        server.identify(client1);
        server.notifyWait(client1);

        server.identify(client2);
        server.notifyWait(client2);
        client1.isAlive = false;

        assertEquals(Game.duration, client1.duration);
        assertEquals(Game.duration, client2.duration);

        assertFalse(server.identify(client3));
    }

    public void testThirdPlayerWithDropDuringGame2() throws RemoteException {
        startGame();
        client1.isAlive = false;
        client2.isAlive = false;

        assertEquals(Game.duration, client1.duration);
        assertEquals(Game.duration, client2.duration);

        assertFalse(server.identify(client3));
    }

    // exercita casos em que client1 cancela e client3 entra depois.
    public void testStartGameWithCancelWait() throws RemoteException {
        server.identify(client1);
        server.identify(client2);
        server.notifyWait(client1);

        server.cancelWait(client1);
        server.notifyWait(client2);

        assertEquals(-1, client1.duration);
        assertEquals(-1, client2.duration);

        server.identify(client3);
        server.notifyWait(client3);
        assertEquals(Game.duration, client2.duration);
        assertEquals(Game.duration, client3.duration);
    }

    public void testStartGameWithCancelWait2() throws RemoteException {
        server.identify(client1);
        server.notifyWait(client1);

        server.identify(client2);
        server.cancelWait(client1);
        server.notifyWait(client2);

        assertEquals(-1, client1.duration);
        assertEquals(-1, client2.duration);

        server.identify(client3);
        server.notifyWait(client3);
        assertEquals(Game.duration, client2.duration);
        assertEquals(Game.duration, client3.duration);
    }

    public void testStartGameWithCancelWait3() throws RemoteException {
        server.identify(client1);
        server.notifyWait(client1);
        server.cancelWait(client1);

        server.identify(client2);
        server.notifyWait(client2);

        assertEquals(-1, client1.duration);
        assertEquals(-1, client2.duration);

        server.identify(client3);
        server.notifyWait(client3);
        assertEquals(Game.duration, client2.duration);
        assertEquals(Game.duration, client3.duration);
    }

    private void startGame() throws RemoteException {
        server.identify(client1);
        server.notifyWait(client1);
        server.identify(client2);
        server.notifyWait(client2);
    }

    public void testNotifyLabelMatch() throws RemoteException {
        String label = "teste";
        startGame();

        assertEquals(null, client1.match);
        assertEquals(null, client2.match);

        server.sendLabel(label);
        assertEquals(null, client1.match);
        assertEquals(null, client2.match);

        server.sendLabel(label);

        assertEquals(label, client1.match);
        assertEquals(label, client2.match);
    }

    public void testNotifyLabelMatchWithReaptedMatches() throws RemoteException {
        String label = "teste";
        startGame();

        server.sendLabel(label);
        server.sendLabel(label);
        assertEquals(label, client1.match);
        assertEquals(label, client2.match);

        client1.match = client2.match = null;

        // Não deve notificar match repetidos
        server.sendLabel(label);
        server.sendLabel(label);
        assertEquals(null, client1.match);
        assertEquals(null, client2.match);
    }

    public void testNotifyPenico() throws RemoteException {
        startGame();

        assertEquals(false, client1.penicoNotified);
        assertEquals(false, client2.penicoNotified);

        server.notifyPenico();
        assertTrue(timer.canceled);

        assertEquals(true, client1.penicoNotified);
        assertEquals(true, client2.penicoNotified);
    }

    public void testPenicoWithDropPlayerAndReplay() throws RemoteException {
        startGame();
        server.notifyPenico();
        client1.isAlive = false;
        server.notifyWait(client2);

        server.identify(client3);
        server.notifyWait(client3);
        assertEquals(Game.duration, client2.duration);
        assertEquals(Game.duration, client3.duration);
    }

    public void testPenicoWithDropPlayerAndReplay2() throws RemoteException {
        startGame();
        server.notifyPenico();
        client1.isAlive = false;

        server.identify(client3);
        server.notifyWait(client2);
        server.notifyWait(client3);
        assertEquals(Game.duration, client2.duration);
        assertEquals(Game.duration, client3.duration);
    }

    public void testPenicoWithDropPlayerAndReplay3() throws RemoteException {
        startGame();
        server.notifyPenico();
        client1.isAlive = false;

        server.identify(client3);
        server.notifyWait(client3);
        server.notifyWait(client2);
        assertEquals(Game.duration, client2.duration);
        assertEquals(Game.duration, client3.duration);
    }

    public void testPenicoWithDropPlayers() throws RemoteException {
        startGame();
        server.notifyPenico();
        client1.isAlive = false;

        assertTrue(server.identify(client3));
        server.notifyWait(client3);

        assertFalse(server.identify(client4));
        client2.isAlive = false;

        assertTrue(server.identify(client4));
        server.notifyWait(client4);

        assertEquals(Game.duration, client3.duration);
        assertEquals(Game.duration, client4.duration);
    }

    public void testPenicoWithDropPlayers2() throws RemoteException {
        startGame();
        server.notifyPenico();
        client1.isAlive = false;
        client2.isAlive = false;

        assertTrue(server.identify(client3));
        server.notifyWait(client3);

        assertTrue(server.identify(client4));
        server.notifyWait(client4);

        assertEquals(Game.duration, client3.duration);
        assertEquals(Game.duration, client4.duration);
    }

    public void testPenicoWithDropPlayers3() throws RemoteException {
        startGame();
        server.notifyPenico();

        assertFalse(server.identify(client3));
        client1.isAlive = false;
        assertTrue(server.identify(client3));
        client2.isAlive = false;
        assertTrue(server.identify(client4));

        server.notifyWait(client3);
        server.notifyWait(client4);

        assertEquals(Game.duration, client3.duration);
        assertEquals(Game.duration, client4.duration);
    }

    public void testPenicoWithDropPlayers4() throws RemoteException {
        startGame();
        server.notifyPenico();

        assertFalse(server.identify(client3));
        client1.isAlive = false;
        assertTrue(server.identify(client3));
        server.notifyWait(client3);

        client2.isAlive = false;
        assertTrue(server.identify(client4));
        server.notifyWait(client4);

        assertEquals(Game.duration, client3.duration);
        assertEquals(Game.duration, client4.duration);
    }

    public void testStartGameScheduleTask() throws RemoteException {
        startGame();

        assertEquals(Game.duration * 1000, timer.delay);
    }

    public void testEndGame() throws RemoteException {
        startGame();

        server.notifyTimeout();

        assertNotNull(client1.summary);
        assertNotNull(client2.summary);
        assertEquals(client1.summary, client2.summary);
    }

    public void testNotifyTimeoutDropedPlayer() throws RemoteException {
        startGame();
        client1.isAlive = false;

        server.notifyTimeout();

        assertNotNull(client1.summary);
    }

    public void testEndGameAndReplay() throws RemoteException {
        startGame();

        server.notifyTimeout();
        assertNotNull(client1.summary);
        assertNotNull(client2.summary);
        assertEquals(client1.summary, client2.summary);

        server.notifyWait(client1);
        server.notifyWait(client2);
        assertEquals(true, client1.startGameCalled);
        assertEquals(true, client2.startGameCalled);
    }

    public void assertEmpty(List list) {
        if (list.size() != 0) {
            String message = "Expected empty list but got: ";
            for (Object o : list) {
                message = message + o + "\n";
            }
            fail(message);
        }
    }

    public void testUpdateRankAfterEndGame() throws Exception {
        client1.loginName = "Jobs";
        client2.loginName = "Page";

        startGame();
        for (int i = 0; i < 2; i++) {
            server.sendLabel("teste");
            server.sendLabel("123");
        }

        playerPersistance.updateCalls.add(new Player("Jobs", 108));
        playerPersistance.updateCalls.add(new Player("Page", 8));

        server.notifyTimeout();

        assertEmpty(playerPersistance.unexpectedUpdateCalls);
        assertEmpty(playerPersistance.updateCalls);
    }
 */
}
