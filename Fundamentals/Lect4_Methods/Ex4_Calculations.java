/*
Write a program that receives a string on the first line ("add", "multiply", "subtract", "divide") and on the next two
lines receives two numbers. Create four methods (for each calculation) and invoke the right one depending on the
command. The method should also print the result (needs to be void).
 */
package Fundamentals.Lect4_Methods;

import java.util.Scanner;

public class Ex4_Calculations {
    static int addTwoNumbers(int a, int b) {
        return a + b;
    }

    static int multiplyTwoNumbers(int a, int b) {
        return a * b;
    }

    static int subtractTwoNumbers(int a, int b) {
        return a - b;
    }

    static int divideTwoNumbers(int a, int b) {
        return a / b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());

        switch (command) {
            case "add":
                System.out.println(addTwoNumbers(a, b));
                break;
            case "multiply":
                System.out.println(multiplyTwoNumbers(a, b));
                break;
            case "subtract":
                System.out.println(subtractTwoNumbers(a, b));
                break;
            case "divide":
                System.out.println(divideTwoNumbers(a, b));
                break;
            default:
                break;
        }

    }
}
