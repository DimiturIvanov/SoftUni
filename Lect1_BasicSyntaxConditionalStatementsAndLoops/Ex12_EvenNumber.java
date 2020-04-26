/*
Take as an input an even number and print its absolute value. If the number is odd, print "Please write an even
number." and continue reading numbers.
 */
package Fundamentals.Lect1_BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class Ex12_EvenNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();

        while (number % 2 != 0) {
            System.out.println("Please write an even number.");

            number = scanner.nextInt();
        }

        System.out.printf("The number is: %d", Math.abs(number));

    }
}
