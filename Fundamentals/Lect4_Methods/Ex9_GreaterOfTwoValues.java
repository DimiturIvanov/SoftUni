/*
You are given two values of the same type as input. The values can be of type int, char of String. Create a
method getMax() that returns the greater of the two values:
 */
package Fundamentals.Lect4_Methods;

import java.util.Scanner;

public class Ex9_GreaterOfTwoValues {
    static int greaterOfTwoValues(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }

    static char greaterOfTwoValues(char a, char b) {
        if (a > b) {
            return a;
        }
        return b;
    }

    static String greaterOfTwoValues(String a, String b) {
        if (a.compareTo(b) >= 0) {
            return a;
        }
        return b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine();

        switch (type) {
            case "int":
                int number1 = Integer.parseInt(scanner.nextLine());
                int number2 = Integer.parseInt(scanner.nextLine());
                System.out.println(greaterOfTwoValues(number1, number2));
                break;
            case "char":
                char a = scanner.next().charAt(0);
                char b = scanner.next().charAt(0);
                System.out.println(greaterOfTwoValues(a, b));
                break;
            case "string":
                String word1 = scanner.nextLine();
                String word2 = scanner.nextLine();
                System.out.println(greaterOfTwoValues(word1, word2));
                break;
            default:
                break;
        }

    }
}
