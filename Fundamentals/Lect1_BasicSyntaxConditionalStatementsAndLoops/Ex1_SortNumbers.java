/*
Read three real numbers and sort them in descending order. Print each number on a new line.
 */
package Fundamentals.Lect1_BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class Ex1_SortNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());

        int max = 0;
        int min = 0;
        int middle = 0;

        if (a > b && a > c) {
            max = a;
            if (b > c) {
                min = c;
                middle = b;
            } else {
                min = b;
                middle = c;
            }
        } else if (b > a && b > c) {
            max = b;
            if (a > c) {
                min = c;
                middle = a;
            } else {
                min = a;
                middle = c;
            }
        } else if (c > b && c > a) {
            max = c;
            if (b > a) {
                min = a;
                middle = b;
            } else {
                min = b;
                middle = a;
            }
        }

        System.out.println(max);
        System.out.println(middle);
        System.out.println(min);

    }
}
