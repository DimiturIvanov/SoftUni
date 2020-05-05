/*
Write a program to display numbers from given start to given end and their sum. All the numbers will be integers.
On the first line you will receive the start number, on the second the end number.
 */
package Fundamentals.Lect1_BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class Ex4_PrintAndSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = scanner.nextInt();
        int secondNumber = scanner.nextInt();
        int sum = 0;

        for (int i = firstNumber; i <= secondNumber; i++) {
            System.out.print(i + " ");
            sum += i;
        }
        System.out.println();
        System.out.printf("Sum: %d", sum);

    }
}
