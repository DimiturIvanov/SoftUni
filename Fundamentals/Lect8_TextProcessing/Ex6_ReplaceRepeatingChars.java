/*
Write a program that reads a string from the console and replaces any sequence of the same letters
with a single corresponding letter.
 */
package Fundamentals.Lect8_TextProcessing;

import java.util.Scanner;

public class Ex6_ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < line.length(); i++) {
            char currentSymbol = line.charAt(i);

            if (i == 0) {
                result.append(currentSymbol);
            } else {
                char lastSymbol = line.charAt(i - 1);
                if (lastSymbol != currentSymbol) {
                    result.append(currentSymbol);
                }
            }
        }

        System.out.println(result);

    }
}
