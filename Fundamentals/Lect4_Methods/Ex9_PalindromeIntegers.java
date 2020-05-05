/*
A palindrome is a number which reads the same backward as forward, such as 323 or 1001. Write a program which
reads a positive integer numbers until you receive END. For each number print whether the number is palindrome
or not.
 */
package Fundamentals.Lect4_Methods;

import java.util.Scanner;

public class Ex9_PalindromeIntegers {
    static boolean polindrome(String number) {
        boolean isTrue = true;
        for (int i = 0; i < number.length() / 2; i++) {
            if (number.charAt(i) != number.charAt(number.length() - 1 - i)) {
                isTrue = false;
                break;
            }
        }
        return isTrue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String number = scanner.nextLine();

        while (!number.equals("END")) {
            System.out.println(polindrome(number));

            number = scanner.nextLine();

        }
    }
}
