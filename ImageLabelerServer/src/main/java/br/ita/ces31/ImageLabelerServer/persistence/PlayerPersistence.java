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

    /**
     * Atualiza registro de Player no banco de dados.
     * @param player
     * @throws br.ita.ces31.ImageLabelerServer.persistence.PersistenceException
     */
    public void update(Player player) throws PersistenceException;

    /**
     * Adquire registro de Player no banco de dados.
     * @param name
     * @return
     * @throws br.ita.ces31.ImageLabelerServer.persistence.PersistenceException
     */
    public Player getPlayer(String name) throws PersistenceException;

    /**
     * Deleta todos registros no banco de dados.
     * @throws br.ita.ces31.ImageLabelerServer.persistence.PersistenceException
     */
    public void deleteAll() throws PersistenceException;

    /**
     * Adquire lista com n players que possuem as maiores pontuações.
     * @param n
     * @return
     * @throws br.ita.ces31.ImageLabelerServer.persistence.PersistenceException
     */
    public List<Player> getBestPlayers(int n) throws PersistenceException;
}
