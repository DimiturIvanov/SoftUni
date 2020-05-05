/*
Write a method to print the smallest of three integer numbers. Use appropriate name for the method.
 */
package Fundamentals.Lect4_Methods;

import java.util.Scanner;

public class Ex1_SmallestOfThreeNumbers {
    static int smallestBetweenTwoNumbers(int number1, int number2) {
        if (number1 < number2) {
            return number1;
        }
        return number2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number1 = Integer.parseInt(scanner.nextLine());
        int number2 = Integer.parseInt(scanner.nextLine());
        int number3 = Integer.parseInt(scanner.nextLine());

        System.out.println(smallestBetweenTwoNumbers(smallestBetweenTwoNumbers(number1, number2), number3));

    }
}
