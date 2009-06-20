/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.imagelabeler.client.ui.screen;

import br.ita.ces31.imagelabeler.client.ui.WaitUI;

/**
 *
 * @author diego
 */
public interface WaitScreen {
    public void setWaitUI(WaitUI waitUI);
    public void setActive(boolean active);
}
