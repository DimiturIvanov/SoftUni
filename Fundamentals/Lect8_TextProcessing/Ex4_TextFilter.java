/*
Write a program that takes a text and a string of banned words. All words included in the ban list should be
replaced with asterisks "*", equal to the word`s length. The entries in the ban list will be separated by a comma and
space ", ".
The ban list should be entered on the first input line and the text on the second input line.
 */
package Fundamentals.Lect8_TextProcessing;

import java.util.Scanner;

public class Ex4_TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] banList = scanner.nextLine().split(", ");

        String text = scanner.nextLine();

        for (int i = 0; i < banList.length; i++) {

            while (text.contains(banList[i])) {
                String replacement = "";
                for (int j = 0; j < banList[i].length(); j++) {
                    replacement += "*";
                }

                text = text.replace(banList[i], replacement);
            }
        }

        System.out.println(text);

    }
}
