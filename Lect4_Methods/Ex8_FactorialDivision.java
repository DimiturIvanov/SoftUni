/*
Read two integer numbers. Calculate factorial of each number. Divide the first result by the second and print the
division formatted to the second decimal point.
 */
package Fundamentals.Lect4_Methods;

import java.util.Scanner;

public class Ex8_FactorialDivision {
    static double calculateFactorial(int a) {
        double factorial = 1;
        for (int i = 2; i <= a; i++) {
            factorial *= i;
        }
        return factorial;
    }

    static double divideTwoNumbers(int a, int b) {
        double divide = calculateFactorial(a) / calculateFactorial(b);
        return divide;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());

        System.out.printf("%.2f", divideTwoNumbers(a, b));

    }
}
