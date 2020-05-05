/*
You will be given a single integer. Your task is to find the sum of its digits.
 */
package Fundamentals.Lect2_DataTypesAndVariables;

import java.util.Scanner;

public class Ex2_SumDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        while (number > 0) {
            int n = number % 10;
            sum += n;
            number = number / 10;
        }

        System.out.println(sum);

    }
}
