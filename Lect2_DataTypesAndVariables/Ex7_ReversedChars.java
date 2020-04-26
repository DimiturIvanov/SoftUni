/*
Write a program that takes 3 lines of characters and prints them in reversed order with a space between them.
 */
package Fundamentals.Lect2_DataTypesAndVariables;

import java.util.Scanner;

public class Ex7_ReversedChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char symbol1 = scanner.nextLine().charAt(0);
        char symbol2 = scanner.nextLine().charAt(0);
        char symbol3 = scanner.nextLine().charAt(0);

        System.out.printf("%c %c %c", symbol3, symbol2, symbol1);

    }
}
