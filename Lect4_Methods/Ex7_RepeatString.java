/*
Write a method that receives a string and a repeat count n (integer). The method should return a new string (the old
one repeated n times).
 */
package Fundamentals.Lect4_Methods;

import java.util.Arrays;
import java.util.Scanner;

public class Ex7_RepeatString {
    static String repeatText(String text, int count) {
        String repeatedText = "";
        String[] array = new String[count];
        Arrays.fill(array, text);
        repeatedText = String.join("", array);

        return repeatedText;
    }

    static void printRepeatedText(String text, int count) {
        System.out.println(repeatText(text, count));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        int count = Integer.parseInt(scanner.nextLine());

        printRepeatedText(text, count);

    }
}
