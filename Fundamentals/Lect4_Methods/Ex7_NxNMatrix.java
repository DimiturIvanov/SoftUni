/*
Write a method that receives a single integer n and prints nxn matrix with that number.
 */
package Fundamentals.Lect4_Methods;

import java.util.Scanner;

public class Ex7_NxNMatrix {
    static void printLine(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print(n + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            printLine(n);
            System.out.println();
        }

    }
}
