/*
A number is special when its sum of digits is 5, 7 or 11.
Write a program to read an integer n and for all numbers in the range 1…n to print the number and if it is
special or not (True / False).
 */
package Fundamentals.Lect2_DataTypesAndVariables;

import java.util.Scanner;

public class Ex10_SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int number;
        int allSum = 0;

        for (int i = 1; i <= n; i++) {
            number = i;
            allSum = 0;
            while (number != 0) {
                sum = number % 10;
                allSum += sum;
                number = number / 10;
            }
            if (allSum == 5 || allSum == 7 || allSum == 11) {
                System.out.printf("%d -> True%n", i);
            } else {
                System.out.printf("%d -> False%n", i);
            }
        }

    }
}
