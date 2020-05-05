/*
You will receive a single string. Write a method that prints the middle character. If the length of the string is even,
there are two middle characters.
 */
package Fundamentals.Lect4_Methods;

import java.util.Scanner;

public class Ex6_MiddleCharacters {
    static void middleCharactersWithEvenLength(String line) {
        System.out.print(line.charAt(line.length() / 2 - 1));
        System.out.println(line.charAt(line.length() / 2));
    }

    static void middleCharactersWithOddLength(String line) {
        System.out.print(line.charAt(line.length() / 2));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        if (line.length() % 2 == 0) {
            middleCharactersWithEvenLength(line);
        } else {
            middleCharactersWithOddLength(line);
        }

    }
}
