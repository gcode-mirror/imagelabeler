/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.ImageLabelerServer.persistence;

/**
 *
 * @author Helder Suzuki <helder@aluno.ita.br>
 */
public class PlayerPersistenceSingleton {

    private static PlayerPersistence playerPersistence;

    public synchronized static PlayerPersistence getPlayerPersistence() {
        if (playerPersistence == null) {
            playerPersistence = new PlayerPersistenceImpl();
        }

        return playerPersistence;
    }
}
