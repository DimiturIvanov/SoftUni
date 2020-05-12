/*
You will receive two numbers (0 to 10^50 ), print their sum.
 */
package Fundamentals.Lect6_ObjectsAndClasses;

import java.math.BigInteger;
import java.util.Scanner;

public class Ex2_SumBigNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigInteger first = scanner.nextBigInteger();
        BigInteger second = scanner.nextBigInteger();

        BigInteger sum = first.add(second);

        System.out.println(sum);

    }
}
