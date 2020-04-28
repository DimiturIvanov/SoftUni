/*
Write a program, which prints common elements in two arrays. You have to compare the elements of the second
array to the elements of the first.
 */
package Fundamentals.Lect3_Arrays;

import java.util.Scanner;

public class Ex2_CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array1 = scanner.nextLine().split(" ");
        String[] array2 = scanner.nextLine().split(" ");

        for (int i = 0; i < array2.length; i++) {
            for (int j = 0; j < array1.length; j++) {
                if (array2[i].equals(array1[j])) {
                    System.out.print(array2[i] + " ");
                }
            }
        }

    }
}
