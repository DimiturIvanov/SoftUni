/*
Create a method that calculates and returns the area of a rectangle by given width and length.
 */
package Fundamentals.Lect4_Methods;

import java.util.Scanner;

public class Ex6_CalculateRectangleArea {
    static int calculateRectangleArea(int width, int length) {
        int result = 0;
        result = width * length;
        return result;
    }

    static void printRectangleArea(int width, int length) {
        System.out.println(calculateRectangleArea(width, length));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());

        printRectangleArea(width, length);

    }
}
