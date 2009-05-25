/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.ImageLabelerServer;

import junit.framework.TestCase;

/**
 *
 * @author Helder Suzuki <helder@aluno.ita.br>
 */
public class GameTest extends TestCase {

    private Game game;
    TestClient client1, client2;

    @Override
    public void setUp() {
        client1 = new TestClient();
        client2 = new TestClient();
        game = GameBuilder.createLengthGame(client1, client2);
    }

    public void testMatch() {
        assertFalse(game.addLabel("abas"));
        assertFalse(game.addLabel("babas"));
        assertEquals(0, game.getMatches().size());

        assertTrue(game.addLabel("abas"));
        assertEquals(1, game.getMatches().size());

        assertTrue(game.addLabel("babas"));
        assertEquals(2, game.getMatches().size());

        assertEquals(9, game.getScore());
    }
    
    public void testRepeatMatch() {
        assertFalse(game.addLabel("abas"));
        assertTrue(game.addLabel("abas"));
        assertFalse(game.addLabel("abas"));
        assertFalse(game.addLabel("abas"));
        assertFalse(game.addLabel("abas"));
        
        assertEquals(1, game.getMatches().size());
        assertEquals(4, game.getScore());
    }
}
