/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.imagelabeler.client.ui.screen;

import br.ita.ces31.imagelabeler.client.ui.ConnectionFailedUI;

/**
 *
 * @author diego
 */
public interface ConnectionFailedScreen {
    public void setConnectionFailedUI(ConnectionFailedUI connectionFailedUI);
    public void setActive(boolean active);
}
