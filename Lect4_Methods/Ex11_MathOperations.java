/*
Write a method that receives two numbers and an operator, calculates the result and returns it. You will be given
three lines of input. The first will be the first number, the second one will be the operator and the last one will be
the second number. The possible operators are: / * + -
Print the result rounded up to the second decimal point.
 */
package Fundamentals.Lect4_Methods;

import java.util.Scanner;

public class Ex11_MathOperations {
    static int getSum(int a, int b) {
        int sum = a + b;
        return sum;
    }

    static int getSubtract(int a, int b) {
        int subtract = a - b;
        return subtract;
    }

    static int getMultiply(int a, int b) {
        int multiply = a * b;
        return multiply;
    }

    static int getDivide(int a, int b) {
        int divide = a / b;
        return divide;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();
        int b = Integer.parseInt(scanner.nextLine());

        int result = 0;

        switch (command) {
            case "+":
                result = getSum(a, b);
                break;
            case "-":
                result = getSubtract(a, b);
                break;
            case "*":
                result = getMultiply(a, b);
                break;
            case "/":
                result = getDivide(a, b);
                break;
            default:
                break;
        }

        System.out.println(result);

    }
}
