package RWFile;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class ScannerReadFile {
    public static void main(String[] args) throws IOException {
        Scanner out = new Scanner(Paths.get("./chapter03/outfile.txt"), "UTF-8");

        Scanner in = new Scanner(Paths.get("./chapter03/infile.txt"), "UTF-8");

        System.out.println("Read the contents of the file outfile written by InputTest:\n");
        try {
            while (out.hasNext()) {
                String s = out.nextLine();
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\nread the existing file infile:\n");
        try {
            while (in.hasNext()) {
                String s = in.nextLine();
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
