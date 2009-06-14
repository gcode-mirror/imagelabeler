/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.imagelabeler.client.communicator;

/**
 *
 * @author Helder Suzuki <helder@aluno.ita.br>
 */
public interface Communicator {

    public void sendLabel(String label) throws CommunicationException;

    public boolean identify(String loginName) throws CommunicationException;

    public void cancelWait() throws CommunicationException;

    public void notifyWait() throws CommunicationException;

    public void askPenico() throws CommunicationException;

    public void addObserver(CommunicatorObserver observer);

    public void removeObserver(CommunicatorObserver observer);
}
