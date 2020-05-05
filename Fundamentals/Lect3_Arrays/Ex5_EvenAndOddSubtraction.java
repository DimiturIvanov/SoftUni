/*
Write a program that calculates the difference between the sum of the even and the sum of the odd numbers in an
array.
 */
package Fundamentals.Lect3_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Ex5_EvenAndOddSubtraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int evenSum = 0;
        int oddSum = 0;

        for (int number : numbers) {
            if (number % 2 == 0) {
                evenSum += number;
            } else {
                oddSum += number;
            }
        }

        System.out.println(evenSum - oddSum);

    }
}
