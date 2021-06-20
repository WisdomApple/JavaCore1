package methods;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * This program shows how to invoke methods through reflection.
 *
 * @author Cay Horstmann
 * @version 1.2 2012-05-04
 */
public class MethodTableTest {

    private static String string;

    public static void main(String[] args) throws Exception {
        // get method pointers to the square and sqrt methods
        Method square = MethodTableTest.class.getMethod("square", double.class);
        Method sqrt = Math.class.getMethod("sqrt", double.class);

        // print table of x- and y-values

        printTable(1, 10, 10, square);
        printTable(1, 10, 10, sqrt);
    }

    /**
     * Return the square of a number
     *
     * @param x a number
     * @return x squared
     */
    public static double square(double x) {
        return x * x;
    }

    /**
     * Prints a table with x- and y-values for a method
     *
     * @param form the lower bound for the x-values
     * @param to   the upper bound for the x-values
     * @param n    the number of rows in the table
     * @param f    a method with a double parameter and double return value
     */
    private static void printTable(double form, double to, int n, Method f) {
        // print out the method as table header
        System.out.println(f);

        double dx = (to - form) / (n - 1);

        for (double x = form; x <= to; x += dx) {
            try {
                double y = (Double) f.invoke(null, x);
                System.out.printf("%10.4f | %10.4f\n", x, y);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

}
