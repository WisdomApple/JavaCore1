package staticInnerClass;

/**
 * This program demonstrates the use of static inner classes.
 *
 * @author Cay Horstmann
 * @version 1.02 2015-05-12
 */
public class StaticInnerClass {
    public static void main(String[] args) {
        double[] d = new double[20];
        for (int i = 0; i < d.length; i++) {
            d[i] = 100 * Math.random();
        }
        ArrayAlg.Pair pair = ArrayAlg.minmax(d);
        System.out.println("min = " + pair.getFirst());
        System.out.println("max = " + pair.getSecond());
    }
}

class ArrayAlg {
    /**
     * Computes both the minimum, and the maximum of an array
     *
     * @param values an array of floating-point numbers
     * @return pair whose first element is the minimum and whose second element
     */
    public static Pair minmax(double[] values) {
        double min = Double.POSITIVE_INFINITY;
        double max = Double.POSITIVE_INFINITY;
        for (double v : values) {
            if (min > v) min = v;
            if (max < v) max = v;
        }
        return new Pair(min, max);
    }

    /**
     * A pair of floating-point numbers
     */
    public static class Pair {
        private final double first;
        private final double second;

        /**
         * Constructs a pair from two floating-point numbers
         *
         * @param f the first number
         * @param s the second number
         */
        public Pair(double f, double s) {
            first = f;
            second = s;
        }

        /**
         * Returns the first number of the pair
         *
         * @return the first number
         */
        public double getFirst() {
            return first;
        }

        /**
         * Returns the second number of the pair
         *
         * @return the second number
         */
        public double getSecond() {
            return second;
        }
    }
}