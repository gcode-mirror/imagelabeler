/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.imagelabeler.client.ui.screen;

import br.ita.ces31.imagelabeler.client.ui.PartnerFoundUI;

/**
 *
 * @author diego
 */
public interface PartnerFoundScreen {
    public void setPartnerFoundUI(PartnerFoundUI partnerFoundUI);
    public void setPartnerName(String partnerName);
    public int getRegressiveCounting();
    public void updateRegressiveCounting(int currentCounting);
    public void setActive(boolean active);
}
