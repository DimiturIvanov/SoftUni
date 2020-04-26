/*
Rewrite you program so it can receive the multiplier from the console. Print the table from the given multiplier to
10. If the given multiplier is more than 10 - print only one row with the integer, the given multiplier and the
product. See the examples below for more information.
Output - Print every row of the table in the following format:
{theInteger} X {times} = {product}
Constrains:
The integer will be in the interval [1…100]
 */
package Fundamentals.Lect1_BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class Ex11_MultiplicationTable2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = scanner.nextInt();
        int secondNumber = scanner.nextInt();

        for (int i = secondNumber; i <= 10; i++) {
            System.out.printf("%d X %d = %d%n", firstNumber, i, firstNumber * i);
        }

        if (secondNumber > 10) {
            System.out.printf("%d X %d = %d", firstNumber, secondNumber, firstNumber * secondNumber);
        }

    }
}
