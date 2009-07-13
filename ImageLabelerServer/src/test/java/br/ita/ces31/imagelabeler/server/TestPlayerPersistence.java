/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.imagelabeler.server;

import br.ita.ces31.imagelabeler.common.Player;
import br.ita.ces31.imagelabeler.server.persistence.PersistenceException;
import br.ita.ces31.imagelabeler.server.persistence.PlayerPersistence;
import java.util.ArrayList;

/**
 *
 * @author Helder Suzuki <helder@aluno.ita.br>
 */
public class TestPlayerPersistence implements PlayerPersistence {

    public ArrayList<Player> updateCalls;
    public ArrayList<Player> unexpectedUpdateCalls;
    public ArrayList<Player> bestPlayers;

    public TestPlayerPersistence() {
        unexpectedUpdateCalls = new ArrayList<Player>();
        updateCalls = new ArrayList<Player>();
    }

    public void update(Player player) throws PersistenceException {
        if (updateCalls.contains(player)) {
            updateCalls.remove(player);
        } else {
            unexpectedUpdateCalls.add(player);
        }
    }

    public Player getPlayer(String name) throws PersistenceException {
        if ("Jobs".equals(name)) {  // Jobs começa com 100 pontos
            return new Player("Jobs", 100);
        }
        return new Player(name, 0);
    }

    public void deleteAll() throws PersistenceException {
    }

    public ArrayList<Player> getPlayers() throws PersistenceException {
        return bestPlayers;
    }
}
