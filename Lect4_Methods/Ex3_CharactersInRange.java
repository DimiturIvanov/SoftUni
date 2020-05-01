/*
Write a method that receives two characters and prints on a single line all the characters in between them according
to ASCII.
 */
package Fundamentals.Lect4_Methods;

import java.util.Scanner;

public class Ex3_CharactersInRange {
    static void charactersInRange(char symbol1, char symbol2) {
        int count = 0;
        for (char i = symbol1; i < symbol2; i++) {
            count++;
            if (count > 1) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char symbol1 = scanner.next().charAt(0);
        char symbol2 = scanner.next().charAt(0);

        charactersInRange(symbol1, symbol2);
        charactersInRange(symbol2, symbol1);

    }
}
