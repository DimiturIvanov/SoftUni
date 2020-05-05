/*
Find online more information about ASCII (American Standard Code for Information Interchange) and write a
program that prints part of the ASCII table of characters at the console.
On the first line of input you will receive the char index you should start with and on the
second line - the index of the last character you should print.
 */
package Fundamentals.Lect2_DataTypesAndVariables;

import java.util.Scanner;

public class Ex5_PrintPartOfASCIITable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());

        for (int i = a; i <= b; i++) {
            System.out.print((char) i + " ");
        }

    }
}