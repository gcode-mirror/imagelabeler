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

        images.add("pic001.jpg");
        images.add("pic002.jpg");
        images.add("pic003.jpg");
        images.add("pic004.jpg");
        images.add("pic005.jpg");
        images.add("pic006.jpg");
        images.add("pic007.jpg");
        images.add("pic008.jpg");
        images.add("pic009.jpg");
        images.add("pic010.jpg");

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
