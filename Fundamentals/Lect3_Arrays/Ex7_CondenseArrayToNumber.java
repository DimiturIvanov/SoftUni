/*
Write a program to read an array of integers and condense them by summing adjacent couples of elements until a
single integer is obtained. For example, if we have 3 elements {2, 10, 3}, we sum the first two and the second two
elements and obtain {2+10, 10+3} = {12, 13}, then we sum again all adjacent elements and obtain {12+13} = {25}.
 */
package Fundamentals.Lect3_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Ex7_CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] first = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        while (first.length > 1) {
            int[] second = new int[first.length - 1];

            for (int i = 0; i < second.length; i++) {
                second[i] = first[i] + first[i + 1];
            }
            first = second;
        }

        System.out.println(first[0]);

    }
}
