package br.ita.ces31.ImageLabelerServer;

import br.ita.ces31.ImageLabelerCommon.Server;
import java.rmi.RemoteException;
import junit.framework.TestCase;

/*
 * Image Labeler - Projeto de CES-31
 */
/**
 *
 * @author Helder Suzuki <helder@aluno.ita.br>
 */
public class ServerImplTest extends TestCase {

    private Server server;

    @Override
    public void setUp() throws RemoteException {
        server = new ServerImpl();
    }

    public void testStartGame() {
    }
}
