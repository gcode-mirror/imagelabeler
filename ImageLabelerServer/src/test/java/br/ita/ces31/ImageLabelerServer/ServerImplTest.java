package br.ita.ces31.ImageLabelerServer;

import br.ita.ces31.ImageLabelerCommon.Player;
import br.ita.ces31.ImageLabelerCommon.Server;
import java.rmi.RemoteException;
import java.util.ArrayList;
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
    private TestClient client1,  client2,  client3;
    private TestPlayerPersistence playerPersistance;
    TestTimer timer;

    @Override
    public void setUp() throws RemoteException {
        server = new ServerImpl();
        client1 = new TestClient();
        client2 = new TestClient();
        client3 = new TestClient();

        timer = new TestTimer();
        server.setTimer(timer);

        playerPersistance = new TestPlayerPersistence();
        server.setPlayerPersistence(playerPersistance);
    }

    // Exercita caso em que só podem existir 2 identificados.
    public void testIdentify() throws RemoteException {
        assertTrue(server.identify(client1));
        assertTrue(server.identify(client2));
        assertFalse(server.identify(client3));
    }

    // Fluxo de sucesso.
    public void testStartGame() throws RemoteException {
        server.identify(client1);
        server.notifyWait(client1);

        server.identify(client2);
        server.notifyWait(client2);

        assertEquals(Game.duration, client1.duration);
        assertEquals(Game.duration, client2.duration);
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

    // exercita casos em que client1 cancela e client3 entra depois.
    public void testStartGameCancelWait() throws RemoteException {
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

    public void testStartGameCancelWait2() throws RemoteException {
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

    public void testStartGameCancelWait3() throws RemoteException {
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

    public void testNotifyMatch() throws RemoteException {
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
    
        public void testNotifyMatchRepeat() throws RemoteException {
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
        assertEquals(false, client1.penicoNotified);

        server.notifyPenico();

        assertEquals(true, client1.penicoNotified);
        assertEquals(true, client1.penicoNotified);
    }

    public void testStartGameScheduleTask() throws RemoteException {
        startGame();

        assertNotNull(timer.task);
        assertEquals(Game.duration * 1000, timer.delay);
    }

    public void testNotifyTimeout() throws RemoteException {
        startGame();

        server.notifyTimeout();

        assertNotNull(client1.summary);
        assertNotNull(client2.summary);
        assertEquals(client1.summary, client2.summary);
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

    public void testUpdateRank() throws Exception {
        client1.loginName = "Jobs";
        client2.loginName = "Page";

        startGame();
        for (int i = 0; i < 2; i++) {
            server.sendLabel("teste");
            server.sendLabel("123");
        }

        playerPersistance.updateCalls = new ArrayList<Player>();
        playerPersistance.updateCalls.add(new Player("Jobs", 108));
        playerPersistance.updateCalls.add(new Player("Page", 8));

        server.notifyTimeout();

        assertEmpty(playerPersistance.unexpectedUpdateCalls);
        assertEmpty(playerPersistance.updateCalls);
    }
}
