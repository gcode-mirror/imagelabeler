/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.imagelabeler.client.screen;

/**
 *
 * @author diego
 */
public interface PartnerFoundScreen extends Screen{
    public void setPartnerName(String partnerName);
    public int getRegressiveCounting();
    public void updateRegressiveCounting(int miliseconds);
}
