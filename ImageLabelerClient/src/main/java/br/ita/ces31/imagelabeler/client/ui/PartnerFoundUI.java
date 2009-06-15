/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ita.ces31.imagelabeler.client.ui;

import br.ita.ces31.imagelabeler.client.ui.screen.PartnerFoundScreen;

/**
 *
 * @author diego
 */
public class PartnerFoundUI extends UserInterface{
    private PartnerFoundScreen screen;

    public PartnerFoundUI(PartnerFoundScreen screen) {
        setScreen(screen);
        controller.setPartnerFoundUI(this);
    }
    
    public void penico() {
        PartnerFoundUI.controller.penico();
    }

    public void setVisible(boolean visible){
        this.screen.setVisible(visible);
    }

    public void setScreen(PartnerFoundScreen screen) {
        this.screen = screen;
    }

    public void setPartnerName(String partnerName){
        this.screen.setPartnerName(partnerName);
    }

    public int getRegressiveCounting(){
        return Integer.parseInt(this.screen.getLblRegressiveCounting());
    }

    public void updateRegressiveCounting(){
        int pastCounting = Integer.parseInt(this.screen.getLblRegressiveCounting());
        int currentCounting = pastCounting - 1;
        this.screen.setLblRegressiveCounting(String.valueOf(currentCounting));
    }
}
