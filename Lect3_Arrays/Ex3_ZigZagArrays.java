/*
Write a program which creates 2 arrays. You will be given an integer n. On the next n lines you get 2 integers. Form
2 arrays as shown below.
 */
package Fundamentals.Lect3_Arrays;

import java.util.Scanner;

public class Ex3_ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int maxNumber = Integer.parseInt(scanner.nextLine());

        int[] array1 = new int[maxNumber];
        int[] array2 = new int[maxNumber];

        for (int i = 0; i < maxNumber; i++) {
            int number1 = scanner.nextInt();
            int number2 = scanner.nextInt();

            if (i % 2 == 0) {
                array1[i] = number1;
                array2[i] = number2;
            } else {
                array1[i] = number2;
                array2[i] = number1;
            }
        }
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + " ");
        }

        System.out.println();

        for (int i = 0; i < array2.length; i++) {
            System.out.print(array2[i] + " ");
        }

    }
}
