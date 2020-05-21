/*
Write a program that returns an encrypted version of the same text. Encrypt the text by shifting each character with
three positions forward. For example A would be replaced by D, B would become E, and so on. Print the encrypted
text.
For Example:
Input
"Programming is cool!"
Output
"Surjudpplqj#lv#frro$"
 */
package Fundamentals.Lect8_TextProcessing;

import java.util.Scanner;

public class Ex4_CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < line.length(); i++) {
            char symbol = line.charAt(i);
            int charSymbol = (int) symbol;

            int resultCharSymbol = charSymbol + 3;
            char resultSymbol = (char) resultCharSymbol;

            result.append(resultSymbol);
        }

        System.out.println(result);

    }
}
