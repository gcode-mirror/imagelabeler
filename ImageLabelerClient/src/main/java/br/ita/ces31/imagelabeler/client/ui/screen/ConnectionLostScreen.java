/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.imagelabeler.client.ui.screen;

import br.ita.ces31.imagelabeler.client.ui.ConnectionLostUI;

/**
 *
 * @author diego
 */
public interface ConnectionLostScreen {
    public void setConnectionLostUI(ConnectionLostUI connectionLostUI);
    public void setActive(boolean active);
}
