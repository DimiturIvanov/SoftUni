/*
Write a program that reads a sequence of strings from the console. Encrypt every string by summing:
- The code of each vowel multiplied by the string length
- The code of each consonant divided by the string length
-ort the number sequence in ascending order and print it on the console.
On first line, you will always receive the number of strings you have to read.
 */
package Fundamentals.Lect3_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Ex1_EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        int[] encrypt = new int[n];

        for (int i = 1; i <= n; i++) {
            String word = scanner.nextLine();

            for (int j = 0; j < word.length(); j++) {
                if (word.charAt(j) == 'a' || word.charAt(j) == 'e' ||
                        word.charAt(j) == 'i' || word.charAt(j) == 'o' || word.charAt(j) == 'u' ||
                        word.charAt(j) == 'A' || word.charAt(j) == 'E' || word.charAt(j) == 'I' ||
                        word.charAt(j) == 'O' || word.charAt(j) == 'U') {
                    int numberOfLeter = (int) word.charAt(j);
                    int result = numberOfLeter * word.length();
                    sum += result;
                } else {
                    int numberOfLeter = (int) word.charAt(j);
                    int result = numberOfLeter / word.length();
                    sum += result;
                }
            }
            encrypt[i - 1] = sum;
            sum = 0;
        }

        Arrays.sort(encrypt);
        for (Integer number : encrypt) {
            System.out.println(number);
        }

    }
}
