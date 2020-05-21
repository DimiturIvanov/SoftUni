/*
Write a program that receives a single string and on the first line prints all the digits, on the second – all the letters,
and on the third – all the other characters. There will always be at least one digit, one letter and one other
characters.
 */
package Fundamentals.Lect8_TextProcessing;

import java.util.Scanner;

public class Ex5_DigitsLettersAndOther {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        StringBuilder digits = new StringBuilder();
        StringBuilder letters = new StringBuilder();
        StringBuilder others = new StringBuilder();

        digits = isDigit(line);
        letters = isLetters(line);
        others = isOthers(line);

        System.out.println(digits);
        System.out.println(letters);
        System.out.println(others);

    }

    public static StringBuilder isDigit(String line) {
        StringBuilder digits = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
            char symbol = line.charAt(i);
            if (Character.isDigit(symbol)) {
                digits.append(symbol);
            }
        }
        return digits;
    }

    public static StringBuilder isLetters(String line) {
        StringBuilder letters = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
            char symbol = line.charAt(i);
            if (Character.isLetter(symbol)) {
                letters.append(symbol);
            }
        }
        return letters;
    }

    public static StringBuilder isOthers(String line) {
        StringBuilder others = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
            char symbol = line.charAt(i);
            if (!Character.isLetterOrDigit(symbol)) {
                others.append(symbol);
            }
        }
        return others;
    }

}
