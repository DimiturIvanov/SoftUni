/*
Create a program that reads a positive integer n as input and prints on the console a rhombus with size n:
 */
package Advanced.OOP.Lect1_WorkingWithAbstraction;

import java.util.Scanner;

public class Ex1_RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= size; i++) {
            printRow(size, i);
        }

        for (int i = size - 1; i > 0; i--) {
            printRow(size, i);
        }

    }

    private static void printRow(int size, int currentRow) {
        printLeadingSpaces(currentRow, size);
        printStars(currentRow);
        System.out.println();
    }

    public static void printStars(int starCount) {
        for (int i = 0; i < starCount; i++) {
            System.out.print("* ");
        }
    }

    public static void printLeadingSpaces(int row, int size) {
        int spaceCount = Math.abs(size - row);

        for (int i = 0; i < spaceCount; i++) {
            System.out.print(" ");
        }

    }
}
