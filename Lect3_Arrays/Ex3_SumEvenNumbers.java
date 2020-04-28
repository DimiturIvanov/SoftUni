/*
Read an array from the console and sum only the even numbers.
 */
package Fundamentals.Lect3_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Ex3_SumEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int evenSum = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                evenSum += numbers[i];
            }
        }

        System.out.println(evenSum);

    }
}
