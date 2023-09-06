
package tools;

import java.io.File;
import edu.duke.DirectoryResource;
import edu.duke.ImageResource;
import edu.duke.Pixel;

/**
 * This converts a file into its grayscale and displays in terminal
 */
public class Gray {
    private static ImageResource convert(ImageResource inImg) {
        // creating a new image on size of input image
        ImageResource outImg = new ImageResource(inImg.getWidth(), inImg.getHeight());

        // for each pixel in outImage
        for (Pixel outPixel : outImg.pixels()) {

            // get the pixel from inImg for the outpixel Position
            Pixel inPixel = inImg.getPixel(outPixel.getX(), outPixel.getY());

            // finding average for inPixel
            int avg = (inPixel.getRed() + inPixel.getBlue() + inPixel.getGreen()) / 3;

            // setting rbg for outpixel
            outPixel.setRed(avg);
            outPixel.setBlue(avg);
            outPixel.setGreen(avg);
        }
        return outImg;
    }

    private static void save(ImageResource inImg, ImageResource outImg) {
        String name = inImg.getFileName();
        String newname = "gray-" + name;
        outImg.setFileName(newname);
        outImg.save();
    }

    public static void toGray(Iterable<File> pics) {

        for (File file : pics) {
            ImageResource pic = new ImageResource(file);
            save(pic, convert(pic));
        }
    }

    // ? test
    protected static void main(String[] args) {
        System.out.println("--- Gray Converter ---\n");

        // select file
        System.out.println(">> Select the file\n");
        DirectoryResource dr = new DirectoryResource();
        Iterable<File> pics = dr.selectedFiles();

        toGray(pics);
    }
}
