/*
Write program to enter n numbers and calculate and print their exact sum (without rounding).
 */
package Fundamentals.Lect2_DataTypesAndVariables;

import java.math.BigDecimal;
import java.util.Scanner;

public class Ex3_ExactSumOfRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String numbers = "";
        BigDecimal summ = new BigDecimal(0);

        while (n-- > 0) {
            numbers = scanner.nextLine();
            BigDecimal number = new BigDecimal(numbers);
            summ = summ.add(number);
        }

        System.out.println(summ);

    }
}