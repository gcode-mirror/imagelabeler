/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.imagelabeler.server.persistence;

import br.ita.ces31.imagelabeler.common.Player;
import java.util.ArrayList;

/**
 *
 * @author Helder Suzuki <helder@aluno.ita.br>
 */
public interface PlayerPersistence {

    /**
     * Atualiza registro de Player no banco de dados.
     * @param player
     * @throws PersistenceException
     */
    public void update(Player player) throws PersistenceException;

    /**
     * Adquire registro de Player no banco de dados.
     * @param name
     * @return
     * @throws PersistenceException
     */
    public Player getPlayer(String name) throws PersistenceException;

    /**
     * Deleta todos registros no banco de dados.
     * @throws PersistenceException
     */
    public void deleteAll() throws PersistenceException;

    /**
     * Adquire lista com players.
     * @return
     * @throws PersistenceException
     */
    public ArrayList<Player> getPlayers() throws PersistenceException;
}
