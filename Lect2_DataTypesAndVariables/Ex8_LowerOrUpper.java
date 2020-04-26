/*
Write a program that prints whether a given character is upper-case or lower-case.
 */
package Fundamentals.Lect2_DataTypesAndVariables;

import java.util.Scanner;

public class Ex8_LowerOrUpper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char symbol = scanner.nextLine().charAt(0);

        if ('A' <= symbol && symbol <= 'Z') {
            System.out.println("upper-case");
        } else if ('a' <= symbol && symbol <= 'z') {
            System.out.println("lower-case");
        }

    }
}
