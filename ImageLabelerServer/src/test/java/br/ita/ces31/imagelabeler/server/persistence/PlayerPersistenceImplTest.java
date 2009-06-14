/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.imagelabeler.server.persistence;

import br.ita.ces31.imagelabeler.server.persistence.PlayerPersistence;
import br.ita.ces31.imagelabeler.server.persistence.PlayerPersistenceImpl;
import br.ita.ces31.imagelabeler.server.persistence.PersistenceException;
import br.ita.ces31.imagelabeler.common.Player;
import java.util.List;
import junit.framework.TestCase;

/**
 *
 * @author Helder Suzuki <helder@aluno.ita.br>
 */
public class PlayerPersistenceImplTest extends TestCase {

    private PlayerPersistence playerPersistence;

    @Override
    public void setUp() {
        playerPersistence = new PlayerPersistenceImpl();
    }

    @Override
    public void tearDown() throws PersistenceException {
        playerPersistence.deleteAll();
    }

    public void testUpdateGet() throws PersistenceException {
        int score = 1000;
        String name = "Sergey";

        playerPersistence.update(new Player(name, score));
        Player sergey = playerPersistence.getPlayer(name);
        assertNotNull(sergey);
        assertEquals(name, sergey.getName());
        assertEquals(score, sergey.getScore());
    }

    public void testDeleteaAll() throws PersistenceException {
        playerPersistence.update(new Player("Ninguem", 0));
        playerPersistence.deleteAll();
        List<Player> content = playerPersistence.getBestPlayers(1);
        assertNotNull(content);
        assertEquals(0, content.size());
    }

    public void testUpdateScore() throws PersistenceException {
        Player p;
        int score = 10;

        playerPersistence.update(new Player("Sergey", score));
        playerPersistence.update(new Player("Larry", 0));

        p = playerPersistence.getPlayer("Sergey");
        assertNotNull(p);
        assertEquals(score, p.getScore());

        score += 123;
        playerPersistence.update(new Player("Sergey", score));

        p = playerPersistence.getPlayer("Sergey");
        assertNotNull(p);
        assertEquals(score, p.getScore());

        List<Player> content = playerPersistence.getBestPlayers(2);
        assertNotNull(content);
        assertEquals(2, content.size());
    }

    public void testBestPlayers() throws PersistenceException {
        playerPersistence.update(new Player("Gates", 14));
        playerPersistence.update(new Player("Schmitd", 10));
        playerPersistence.update(new Player("Brin", 16));
        playerPersistence.update(new Player("Page", 15));
        playerPersistence.update(new Player("Balmer", 3));
        playerPersistence.update(new Player("Jobs", 17));

        List<Player> content = playerPersistence.getBestPlayers(3);
        assertNotNull(content);
        assertEquals(3, content.size());
        assertEquals("Jobs", content.get(0).getName());
        assertEquals("Brin", content.get(1).getName());
        assertEquals("Page", content.get(2).getName());

        content = playerPersistence.getBestPlayers(1);
        assertNotNull(content);
        assertEquals(1, content.size());
        assertEquals("Jobs", content.get(0).getName());
    }

    public void testGetPlayer() throws PersistenceException {
        playerPersistence.update(new Player("Jobs", 17));
        Player jobs = playerPersistence.getPlayer("Jobs");
        assertEquals(17, jobs.getScore());
    }

    public void testGetPlayer2() throws PersistenceException {
        Player jobs = playerPersistence.getPlayer("Jobs");
        assertEquals(0, jobs.getScore());
    }
}
