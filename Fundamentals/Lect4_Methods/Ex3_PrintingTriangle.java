/*
Create a method for printing triangles as shown below:
 */
package Fundamentals.Lect4_Methods;

import java.util.Scanner;

public class Ex3_PrintingTriangle {
    static void printLine(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            printLine(1, i);
        }

        printLine(1, n);

        for (int i = n - 1; i >= 1; i--) {
            printLine(1, i);
        }

    }
}

