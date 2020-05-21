/*
On the first line you will receive a string. On the second line you will receive a second string. Write a program that
removes all of the occurrences of the first string in the second until there is no match. At the end print the remaining
string.
 */
package Fundamentals.Lect8_TextProcessing;

import java.util.Scanner;

public class Ex3_Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String removingWord = scanner.nextLine();

        String word = scanner.nextLine();

        word = removingWordFromWord(removingWord, word);

        System.out.println(word);

    }

    public static String removingWordFromWord(String removingWord, String word) {

        boolean isTrue = word.contains(removingWord);

        while (isTrue) {
            word = word.replace(removingWord, "");

            isTrue = word.contains(removingWord);
        }
        return word;
    }

}
