/*
 * Image Labeler - Projeto de CES-31
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
        UserInterface.getController().setPartnerFoundUI(this);
    }

    //Button Penico Action
    public void penico() {
        UserInterface.getController().penico();
    }

    public int getRegressiveCounting(){
        return getScreen().getLblRegressiveCounting();
    }

    public void updateRegressiveCounting(){
        int pastCounting = getScreen().getLblRegressiveCounting();
        int currentCounting = pastCounting - 1;
        getScreen().setLblRegressiveCounting(currentCounting);
    }

    public void setPartnerName(String partnerName){
        getScreen().setPartnerName(partnerName);
    }

    public void setActive(boolean active){
        getScreen().setVisible(active);
    }

    public PartnerFoundScreen getScreen(){
        return screen;
    }

    public void setScreen(PartnerFoundScreen screen) {
        this.screen = screen;
    }
}
