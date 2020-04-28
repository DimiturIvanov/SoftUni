/*
Write a program that finds the longest sequence of equal elements in an array of integers. If several longest
sequences exist, print the leftmost one.
 */
package Fundamentals.Lect3_Arrays;

import java.util.Scanner;

public class Ex7_MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        String[] numbers = line.split(" ");
        int[] parseNumbers = new int[numbers.length];

        for (int i = 0; i < parseNumbers.length; i++) {
            parseNumbers[i] = Integer.parseInt(numbers[i]);
        }

        int count = 1;
        int digit = 0;
        int maxDigit = 0;
        int maxCount = 0;

        for (int i = 0; i < parseNumbers.length; i++) {
            digit = parseNumbers[i];
            count = 1;

            for (int j = i + 1; j < parseNumbers.length; j++) {
                if (parseNumbers[i] == parseNumbers[j]) {
                    count++;
                } else {
                    break;
                }
            }

            if (count > maxCount) {
                maxCount = count;
                maxDigit = digit;
            }
        }

        for (int i = 1; i <= maxCount; i++) {
            System.out.print(maxDigit + " ");
        }

    }
}
