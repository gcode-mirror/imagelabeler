/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ita.ces31.imagelabeler.test.client.screen.stub;

import br.ita.ces31.imagelabeler.client.controller.Controller;
import br.ita.ces31.imagelabeler.client.screen.PartnerFoundScreen;

/**
 *
 * @author diego
 */
public class PartnerFoundScreenStub implements PartnerFoundScreen{
    private Controller controller;

    public PartnerFoundScreenStub(){
    }

    public void setActive(boolean isActive) {
        if (isActive){
            System.out.println("PARTNER FOUND");
        }
    }

    public int getRegressiveCounting() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setPartnerName(String partnerName) {
        System.out.println(partnerName);
    }

    public void updateRegressiveCounting(int miliseconds) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public Controller getController() {
        return this.controller;
    }
}
