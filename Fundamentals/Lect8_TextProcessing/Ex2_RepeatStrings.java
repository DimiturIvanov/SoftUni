/*
Write a program that reads an array of strings. Each string is repeated n times, where n is the length of the string.
Print the concatenated string.
 */
package Fundamentals.Lect8_TextProcessing;

import java.util.Scanner;

public class Ex2_RepeatStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().split("\\s+");

        StringBuilder resultLine = new StringBuilder();

        resultLine = resultLine(line);

        System.out.println(resultLine);

    }

    public static StringBuilder resultLine(String[] line) {
        StringBuilder resultLine = new StringBuilder();

        for (int i = 0; i < line.length; i++) {
            int count = line[i].length();
            String word = line[i];
            for (int j = 1; j <= count; j++) {
                resultLine.append(word);
            }
        }
        return resultLine;
    }

}
