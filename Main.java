import java.util.Scanner;
import edu.duke.DirectoryResource;
import java.io.File;
import tools.Gray;
import tools.Negative;

public class Main {

    public static void run() {
        Scanner sc = new Scanner(System.in);

        System.out.println("--- Image Converter ---\n");

        // select file
        System.out.println(">> Select the file\n");
        DirectoryResource dr = new DirectoryResource();
        Iterable<File> pics = dr.selectedFiles();

        System.out.println(">> Options : ");
        System.out.println("> 1.toGray");
        System.out.println("> 2.toNegative");
        System.out.println("> 3.exit");

        System.out.print("\n> choice : ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                Gray.toGray(pics);
                break;
            case 2:
                Negative.toNegative(pics);
                break;
            case 3:
                System.out.println(">> Exit");
                System.exit(0);
            default:
                System.out.println(">> Exit");
        }

        sc.close();
    }

    public static void main(String[] args) {
        run();
    }
}
