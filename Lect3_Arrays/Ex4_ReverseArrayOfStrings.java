/*
Write a program to read an array of strings, reverse it and print its elements. The input consists of a sequence of
space separated strings. Print the output on a single line (space separated).
 */
package Fundamentals.Lect3_Arrays;

import java.util.Scanner;

public class Ex4_ReverseArrayOfStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().split(" ");

        for (int i = 0; i < array.length / 2; i++) {
            String first = array[i];
            String second = array[array.length - 1 - i];

            String swap = first;
            array[i] = second;
            array[array.length - 1 - i] = swap;
        }

        String outPut = String.join(" ", array);
        System.out.println(outPut);

    }
}
