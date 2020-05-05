/*
You will receive 3 integers. Write a method sum to get the sum of the first two integers and subtract method that
subtracts the third integer from the result from the sum method.
 */
package Fundamentals.Lect4_Methods;

import java.util.Scanner;

public class Ex5_AddAndSubtract {
    static int sumTwoNumbers(int number1, int number2) {
        int sum = number1 + number2;
        return sum;
    }

    static int subtractTwoNumbers(int number1, int number2, int number3) {
        int subtract = sumTwoNumbers(number1, number2) - number3;
        return subtract;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number1 = Integer.parseInt(scanner.nextLine());
        int number2 = Integer.parseInt(scanner.nextLine());
        int number3 = Integer.parseInt(scanner.nextLine());

        System.out.println(subtractTwoNumbers(number1, number2, number3));

    }
}
