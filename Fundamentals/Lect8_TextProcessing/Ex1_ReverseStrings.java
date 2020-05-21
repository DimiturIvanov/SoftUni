/*
You will be given series of strings until you receive an "end" command. Write a program that reverses strings and
printseach pair on separate line in format "{word} = {reversed word}".
 */
package Fundamentals.Lect8_TextProcessing;

import java.util.Scanner;

public class Ex1_ReverseStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inPut = scanner.nextLine();

        while (!inPut.equals("end")) {
            String word = inPut;
            String reversedWord = reversedWord(word);

            System.out.printf("%s = %s%n", word, reversedWord);

            inPut = scanner.nextLine();
        }

    }

    public static String reversedWord(String word) {
        String reversed = "";

        for (int i = word.length() - 1; i >= 0; i--) {
            reversed += word.charAt(i);
        }

        return reversed;
    }
}
