/*
Write a program that prints the next n odd numbers (starting from 1) and on the last row prints the sum of them.
Input - On the first line, you will receive a number – n. This number shows how many odd numbers you should print.
Output - Print the next n odd numbers, starting from 1, separated by new lines. On the last line, print the sum of these
numbers.
Constrains:
- n will be in the interval [1…100]
 */
package Fundamentals.Lect1_BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class Ex9_SumOfOddNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int startNumber = 1;
        int sum = 0;
        int count = 0;
        boolean isTrue = true;

        while (isTrue) {
            if (startNumber % 2 != 0) {
                System.out.println(startNumber);
                sum += startNumber;
                count++;
            }
            startNumber++;

            if (count == n) {
                isTrue = false;
            }
        }

        System.out.printf("Sum: %d", sum);

    }
}
