/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.ImageLabelerServer.persistence;

import br.ita.ces31.ImageLabelerCommon.Player;
import java.util.List;

/**
 *
 * @author Helder Suzuki <helder@aluno.ita.br>
 */
public interface PlayerPersistence {

    public void update(Player player) throws PersistenceException;

    public Player getPlayer(String name) throws PersistenceException;

    public void deleteAll() throws PersistenceException;

    public List<Player> getBestPlayers(int n) throws PersistenceException;
}
