/*
 * Image Labeler - Projeto de CES-31
 */
package br.ita.ces31.imagelabeler.server.image;

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

        images.add("pic01.jpg");
        images.add("pic02.jpg");
        images.add("pic03.jpg");
        images.add("pic04.jpg");
        images.add("pic05.jpg");
        images.add("pic06.jpg");
        images.add("pic07.jpg");
        images.add("pic08.jpg");
        images.add("pic09.jpg");
        images.add("pic10.jpg");

        imagePick = images.iterator();
    }

    public String getImage() {
        String ret;
        try {
            ret = imagePick.next();
        } catch (NoSuchElementException ex) {
            imagePick = images.iterator();
            ret = imagePick.next();
        }

        return ret;
    }
}
