/*
Write a program to find all the top integers in an array. A top integer is an integer which is bigger than all the
elements to its right.
 */
package Fundamentals.Lect3_Arrays;

import java.util.Scanner;

public class Ex5_TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().split(" ");
        int[] arrayNumbers = new int[array.length];

        for (int i = 0; i < arrayNumbers.length; i++) {
            arrayNumbers[i] = Integer.parseInt(array[i]);
        }

        int count = 0;
        for (int i = 0; i < arrayNumbers.length - 1; i++) {
            for (int j = i; j < arrayNumbers.length; j++) {
                if (arrayNumbers[i] > arrayNumbers[j]) {
                    count++;
                }
            }
            if (count == arrayNumbers.length - i - 1) {
                System.out.print(arrayNumbers[i] + " ");
            }
            count = 0;
        }

        System.out.print(arrayNumbers[arrayNumbers.length - 1]);

    }
}
