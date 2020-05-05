/*
Create a method that prints the sign of an integer number.
 */
package Fundamentals.Lect4_Methods;

import java.util.Scanner;

public class Ex1_SignOfIntegerNumbers {

    static void signOfInteger(int number) {
        String text = "";
        if (number > 0) {
            text = String.format("The number %d is positive.", number);
        } else if (number < 0) {
            text = String.format("The number %d is negative.", number);
        } else {
            text = String.format("The number %d is zero.", number);
        }
        System.out.println(text);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        signOfInteger(number);

    }
}
