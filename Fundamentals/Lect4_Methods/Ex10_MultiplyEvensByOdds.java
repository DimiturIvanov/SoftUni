/*
Create a program that reads an integer number and multiplies the sum of all its even digits by the sum of all its odd
digits:
 */
package Fundamentals.Lect4_Methods;

import java.util.Scanner;

public class Ex10_MultiplyEvensByOdds {
    static int evenDigitsSum(String[] arrayNumbers) {
        int sumEven = 0;
        for (int i = 0; i < arrayNumbers.length; i++) {
            if (Integer.parseInt(arrayNumbers[i]) % 2 == 0) {
                sumEven += Integer.parseInt(arrayNumbers[i]);
            }
        }
        return sumEven;
    }

    static int oddDigitsSum(String[] arrayNumbers) {
        int sumOdd = 0;
        for (int i = 0; i < arrayNumbers.length; i++) {
            if (Integer.parseInt(arrayNumbers[i]) % 2 == 1) {
                sumOdd += Integer.parseInt(arrayNumbers[i]);
            }
        }
        return sumOdd;
    }

    static int multiplyTwoDigit(String[] arrayNumbers) {
        int multiply = 0;
        multiply = evenDigitsSum(arrayNumbers) * oddDigitsSum(arrayNumbers);

        return multiply;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        number = Math.abs(number);

        String numberString = number + "";

        String[] arrayNumbers = new String[numberString.length()];
        for (int i = 0; i < arrayNumbers.length; i++) {
            arrayNumbers[i] = numberString.charAt(i) + "";
        }
        System.out.println(multiplyTwoDigit(arrayNumbers));

    }
}
