package FirstSample;

/**
 * This the first sample program in Core Java Chapter 3
 *
 * @author Gary Cornell
 * @version 1.01 1997-03022
 */
public class FirstSample {
    public static void main(String[] args) {
        String greeting = "Hello";

        int length = greeting.length();
        char first = greeting.charAt(0);    // first is 'H'
        char last = greeting.charAt(4);        // last is '0'

        // 得到实际的长度，即码点数量
        int cpCount = greeting.codePointCount(0, greeting.length());

        System.out.println("We will not use 'Hello World'");
        System.out.println(String.join(" / ", "S", "M", "L", "XL"));
        System.out.println(greeting.substring(0, 3) + "p!");
        System.out.println("Hello".equals(greeting));
        System.out.println("Hello".equalsIgnoreCase("hello"));
        System.out.println(greeting.compareTo("Hello") == 1);
        System.out.println("length = " + length
                + ", fist char is " + first
                + ", last char is " + last);
        System.out.println(cpCount);

        // 得到第 i 个码点
        for (int i = 0; i < length; i++) {
            int index = greeting.offsetByCodePoints(0, i);
            int cp = greeting.codePointAt(index);
            System.out.print(cp + " / ");
        }
        System.out.println();

        int[] codePoints = greeting.codePoints().toArray();
        String str = new String(codePoints, 0, codePoints.length);
        for (int i = 0; i < length; i++)
            System.out.print(codePoints[i] + " / ");
        System.out.println("\n" + str);

        char ch = ' ';
        StringBuilder builder = new StringBuilder();
        builder.append(ch);
        builder.append(str);
        System.out.println(ch + str);

        String completedString = builder.toString();
        System.out.println(completedString);
    }
}
