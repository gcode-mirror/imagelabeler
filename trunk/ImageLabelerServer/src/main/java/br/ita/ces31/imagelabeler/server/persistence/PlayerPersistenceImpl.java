/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.imagelabeler.server.persistence;

import br.ita.ces31.imagelabeler.common.Player;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Helder Suzuki <helder@aluno.ita.br>
 */
public class PlayerPersistenceImpl implements PlayerPersistence {

    private static List<Player> content;

    private static void serialize() throws PersistenceException {
        FileOutputStream fout;
        try {
            fout = new FileOutputStream("image_labeler.db");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(content);
            oos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new PersistenceException();
        }
    }

    private static void deserialize() throws PersistenceException {
        try {
            FileInputStream fin = new FileInputStream("image_labeler.db");
            ObjectInputStream ois = new ObjectInputStream(fin);
            content = (List<Player>) ois.readObject();
            ois.close();
            fin.close();
        } catch (FileNotFoundException ex) {
            content = new ArrayList<Player>();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new PersistenceException();
        }
    }

    public synchronized void update(Player player) throws PersistenceException {
        deserialize();

        Player p = _getPlayer(player.getName());
        if (p != null) {
            p.setScore(player.getScore());
        } else {
            content.add(player);
        }

        serialize();
    }

    public synchronized List<Player> getBestPlayers(int n)
            throws PersistenceException {
        deserialize();

        Collections.sort(content);
        n = Math.min(n, content.size());

        // Se der algum bug bizarro, é pq devia retornar uma "deep copy" aqui.
        return content.subList(0, n);
    }

    private Player _getPlayer(String name) throws PersistenceException {
        deserialize();
        Player result = null;
        for (Player p : content) {
            if (name.equals(p.getName())) {
                result = p;
                break;
            }
        }

        return result;
    }

    public synchronized Player getPlayer(String name)
            throws PersistenceException {

        Player p = _getPlayer(name);
        if (p == null) {
            return new Player(name, 0);
        } else {
            return new Player(p);
        }
    }

    public synchronized void deleteAll() throws PersistenceException {
        content = new ArrayList<Player>();
        serialize();
    }
}
