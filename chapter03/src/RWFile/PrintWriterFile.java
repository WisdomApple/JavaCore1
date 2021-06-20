package RWFile;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class PrintWriterFile {
    public static void main(String[] args) {
        try {
            PrintWriter out = new PrintWriter("./chapter03/infile.txt", "UTF-8");
            out.println("Hello world");
            out.println("你好，世界");
            out.println("Java世界");
            out.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
