/*
Write a program, which prints all unique pairs in an array of integers whose sum is equal to a given number.
 */
package Fundamentals.Lect3_Arrays;

import java.util.Scanner;

public class Ex8_MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().split(" ");
        int[] numbers = new int[array.length];
        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(array[i]);
        }

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == number) {
                    System.out.printf("%d %d", numbers[i], numbers[j]);
                    System.out.println();
                }
            }
        }

    }
}
