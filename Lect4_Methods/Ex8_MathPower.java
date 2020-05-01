/*
Create a method that calculates and returns the value of a number raised to a given power.
 */
package Fundamentals.Lect4_Methods;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Ex8_MathPower {
    static double numberPower(double number, int power) {
        double result = 1;
        for (int i = 1; i <= power; i++) {
            result *= number;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double number = Double.parseDouble(scanner.nextLine());
        int power = Integer.parseInt(scanner.nextLine());

        System.out.println(new DecimalFormat("0.####").format(numberPower(number, power)));

    }
}
