/*
Write a program that determines if there exists an element in the array such that the sum of the elements on its
left is equal to the sum of the elements on its right. If there are no elements to the left / right, their sum is
considered to be 0. Print the index that satisfies the required condition or “no” if there is no such index.
 */
package Fundamentals.Lect3_Arrays;

import java.util.Scanner;

public class Ex6_EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().split(" ");
        int[] numbers = new int[array.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(array[i]);
        }
        int sumLeft = 0;
        int sumRight = 0;
        int index = 0;
        boolean isTrue = false;

        for (int i = 0; i < numbers.length; i++) {

            if (numbers.length == 1) {
                System.out.println(0);
                break;
            }

            for (int j = i + 1; j < numbers.length; j++) {
                sumRight += numbers[j];
            }

            for (int j = 0; j < i; j++) {
                sumLeft += numbers[j];
            }

            if (sumLeft == sumRight) {
                isTrue = true;
                index = i;
            }

            sumLeft = 0;
            sumRight = 0;
        }
        if (isTrue) {
            System.out.println(index);
        } else if (numbers.length > 1) {
            System.out.println("no");
        }

    }
}
