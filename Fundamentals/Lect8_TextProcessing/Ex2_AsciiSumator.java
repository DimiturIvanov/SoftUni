/*
Write a program that prints a sum of all characters between two given characters (their ascii code). On the first line
you will get a character. On the second line you get another character. On the last line you get a random string.
Find all the characters between the two given and print their ascii sum.
 */
package Fundamentals.Lect8_TextProcessing;

import java.util.Scanner;

public class Ex2_AsciiSumator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char firstSymbol = scanner.nextLine().charAt(0);
        char secondSymbol = scanner.nextLine().charAt(0);
        String line = scanner.nextLine();

        int sum = sumAllCharacters(firstSymbol, secondSymbol, line);

        System.out.println(sum);
    }

    public static int sumAllCharacters(char first, char second, String line) {
        int sum = 0;

        for (int i = 0; i < line.length(); i++) {
            char symbol = line.charAt(i);
            if (first < symbol && symbol < second) {
                sum += (int) symbol;
            }
        }
        return sum;
    }

}
