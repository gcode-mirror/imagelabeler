/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ita.ces31.imagelabeler.client.screen;

import br.ita.ces31.imagelabeler.client.controller.Controller;

/**
 *
 * @author diego
 */
public interface Screen {
    public void setActive(boolean isActive);
    
    public void setController(Controller controller);
}
