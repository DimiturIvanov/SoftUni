/*
Write a program that converts British pounds to US dollars formatted to 3th decimal point.
1 British Pound = 1.31 Dollars
 */
package Fundamentals.Lect2_DataTypesAndVariables;

import java.util.Scanner;

public class Ex2_PoundsToDollars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double pounds = Double.parseDouble(scanner.nextLine());

        double dollars = pounds * 1.31;

        System.out.printf("%.3f", dollars);

    }
}
