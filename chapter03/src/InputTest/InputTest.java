package InputTest;

import java.io.File;
import java.util.Date;
import java.util.Scanner;

/**
 * This program demonstrates console input
 *
 * @author Cay Horstmann
 * @version 1.1. 2004-02-10
 */
public class InputTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // get first input
        System.out.println("What's your name?");
        String name = in.nextLine();

        // get second input
        System.out.println("How old are your?");
        int age = in.nextInt();

        // display output on console
        System.out.println("Hello, " + name + ". Next year, you'll be " + (age + 1));
        System.out.printf("Hello, %s. Next year, you'll be %d\n", name, age + 1);
        System.out.printf("%,.2f\n", 10000000.0 / 3.0);
        System.out.printf("%tc\n", new Date());
        System.out.printf("%1$s %2$tB %2$te, %2$tY\n", "Due Date:", new Date());
        System.out.printf("%s %tB %<te, %<tY\n", "Due Date:", new Date());
        System.out.printf("%s %tB %<te, %<tY\n", "Due Date:", new Date());
    }
}
