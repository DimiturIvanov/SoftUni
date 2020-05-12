/*
You will receive N - number in range [0 - 1000]. Calculate Factorial of N and print the result.
 */
package Fundamentals.Lect6_ObjectsAndClasses;

import java.math.BigInteger;
import java.util.Scanner;

public class Ex3_BigFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();

        BigInteger factorial = BigInteger.valueOf(1);

        for (int i = 1; i <= number; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        System.out.println(factorial);

    }
}
