/*
Write a program that receives an array and number of rotations you have to perform (first element goes at the end)
Print the resulting array.
 */
package Fundamentals.Lect3_Arrays;

import java.util.Scanner;

public class Ex4_ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().split(" ");
        int rotation = scanner.nextInt();

        while (rotation > 0) {
            String symbol = array[0];
            for (int i = 0; i < array.length; i++) {
                if (i == array.length - 1) {
                    array[array.length - 1] = symbol;
                } else {
                    array[i] = array[i + 1];
                }
            }

            rotation--;
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

    }
}
