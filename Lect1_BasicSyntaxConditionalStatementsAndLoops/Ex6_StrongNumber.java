/*
Write a program to check if a given number is a strong number or not. A number is strong if the sum of the Factorial
of each digit is equal to the number. For example 145 is a strong number, because 1! + 4! + 5! = 145. Print "yes" if
the number is strong and "no" if the number is not strong.
 */
package Fundamentals.Lect1_BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class Ex6_StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int number2 = number;
        int factorial = 1;
        int sum = 0;

        while (!(number2 == 0)) {
            int a = number2 % 10;
            int b = number2 / 10;

            for (int i = 1; i <= a; i++) {
                factorial *= i;
            }
            sum += factorial;
            factorial = 1;

            number2 = b;
        }

        if (sum == number) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

    }
}
