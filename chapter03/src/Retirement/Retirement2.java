package Retirement;

import java.util.Scanner;

/**
 * This program demonstrates a <code>do/while</code> loop,
 *
 * @author Cay Horstmann
 * @version 1.20 2004-02-10
 */
public class Retirement2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("How much money do you need to retire?");
        double goal = in.nextDouble();

        System.out.println("How much money will you contribute every year?");
        double payment = in.nextDouble();

        System.out.println("Interest rate in %: ");
        double interestRate = in.nextDouble();

        double balance = 0;
        int year = 0;

        String input;
        // update account balance while goal isn't reached
        do {
            // add this year's payment and interest
            balance += payment;
            double interest = balance * interestRate / 100;
            balance += interest;

            year++;

            // print current balance
            System.out.printf("After year %d, your balance is %,.2f%n", year, balance);
            System.out.print("Ready to retire? (Y/N) ");
            input = in.next();
        } while (input.equals("N"));

    }
}
