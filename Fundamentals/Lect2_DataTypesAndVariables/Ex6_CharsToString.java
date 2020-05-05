/*
Write a program that reads 3 lines of input. On each line you get a single character. Combine all the characters into
one string and print it on the console.
 */
package Fundamentals.Lect2_DataTypesAndVariables;

import java.util.Scanner;

public class Ex6_CharsToString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String combine = "";

        for (int i = 0; i < 3; i++) {
            char symbol = scanner.nextLine().charAt(0);
            combine += symbol;
        }

        System.out.println(combine);

    }
}
