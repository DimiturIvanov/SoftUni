/*
Write a program that, depending on the first line of the input, reads an int, double or string.
- If the data type is int, multiply the number by 2.
- If the data type is real, multiply the number by 1.5 and format it to the second decimal point.
- If the data type is string, surround the input with &quot;$&quot;.
Print the result on the console.
 */
package Fundamentals.Lect4_Methods;

import java.util.Scanner;

public class Ex1_DataTypes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine();

        switch (type) {
            case "int":
                int number = scanner.nextInt();
                System.out.println(intType(number));
                break;
            case "real":
                double floatNumber = scanner.nextDouble();
                System.out.printf("%.2f", doubleType(floatNumber));
                break;
            case "string":
                String text = scanner.next();
                System.out.println(stringType(text));
                break;
            default:
                break;
        }
    }

    public static int intType(int number) {
        int result = number * 2;
        return result;
    }

    public static double doubleType(double number) {
        double result = number * 1.5;
        return result;
    }

    public static String stringType(String text) {
        String result = String.format("$%s$", text);
        return result;
    }

}
