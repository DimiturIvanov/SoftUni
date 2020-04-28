/*
Read two arrays and print on the console whether they are identical or not. Arrays are identical if their elements are
equal. If the arrays are identical find the sum of the first one and print on the console following message: "Arrays are
identical. Sum: {sum}", otherwise find the first index where the arrays differ and print on the console following
message: "Arrays are not identical. Found difference at {index} index."
 */
package Fundamentals.Lect3_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Ex6_EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers1 = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int[] numbers2 = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();

        int sum = 0;
        int count = 0;
        int differentIndex = 0;

        for (int i = 0; i < numbers1.length; i++) {
            if (numbers1[i] == numbers2[i]) {
                count++;
                sum += numbers1[i];
            } else {
                differentIndex = i;
                break;
            }
        }

        if (count == numbers1.length) {
            System.out.printf("Arrays are identical. Sum: %d", sum);
        } else {
            System.out.printf("Arrays are not identical. Found difference at %d index.", differentIndex);
        }

    }
}
