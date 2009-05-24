/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.ImageLabelerServer;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Vector;

/**
 *
 * @author Helder Suzuki <helder@aluno.ita.br>
 */
public class ImageServerImpl implements ImageServer {

    private Vector<String> images;
    private Iterator<String> imagePick;

    public ImageServerImpl() {
        images = new Vector<String>();

        images.add("figura1.jpg");
        images.add("figura2.jpg");
        images.add("figura3.jpg");
        images.add("figura4.jpg");
        imagePick = images.iterator();
    }

    public String getImage() {
        String ret;
        try{
            ret = imagePick.next();
        } catch (NoSuchElementException ex){
            imagePick = images.iterator();
            ret = imagePick.next();
        }

        return ret;
    }
}
