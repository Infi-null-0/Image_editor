
package tools;

import java.io.File;
import edu.duke.DirectoryResource;
import edu.duke.ImageResource;
import edu.duke.Pixel;

/**
 * This converts a file into its grayscale and displays in terminal
 */
public class Negative {
    private static ImageResource convert(ImageResource inImg) {
        // creating a new image on size of input image
        ImageResource outImg = new ImageResource(inImg.getWidth(), inImg.getHeight());

        // for each pixel in outImage
        for (Pixel outPixel : outImg.pixels()) {

            // get the pixel from inImg for the outpixel Position
            Pixel inPixel = inImg.getPixel(outPixel.getX(), outPixel.getY());

            // setting rbg for outpixel
            outPixel.setRed(255 - inPixel.getRed());
            outPixel.setBlue(255 - inPixel.getBlue());
            outPixel.setGreen(255 - inPixel.getGreen());
        }
        return outImg;
    }

    private static void save(ImageResource inImg, ImageResource outImg) {
        String name = inImg.getFileName();
        String newname = "negative-" + name;
        outImg.setFileName(newname);
        outImg.save();
    }

    public static void toNegative(Iterable<File> pics) {

        for (File file : pics) {
            ImageResource pic = new ImageResource(file);
            save(pic, convert(pic));
        }
    }

    // ? test
    protected static void main(String[] args) {
        System.out.println("--- Negative Converter ---\n");

        // select file
        System.out.println(">> Select the file\n");
        DirectoryResource dr = new DirectoryResource();
        Iterable<File> pics = dr.selectedFiles();

        toNegative(pics);
    }
}
