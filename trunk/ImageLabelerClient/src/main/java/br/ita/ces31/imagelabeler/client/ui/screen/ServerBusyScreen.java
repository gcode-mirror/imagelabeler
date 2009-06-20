/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.imagelabeler.client.ui.screen;

import br.ita.ces31.imagelabeler.client.ui.ServerBusyUI;

/**
 *
 * @author diego
 */
public interface ServerBusyScreen {
    public void setServerBusyUI(ServerBusyUI serverBusyUI);
    public void setActive(boolean active);
}
