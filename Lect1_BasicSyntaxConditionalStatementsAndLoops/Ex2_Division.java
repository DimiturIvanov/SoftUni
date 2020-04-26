/*
You will be given an integer and you have to print on the console whether that number is divisible by the following
numbers: 2, 3, 6, 7, 10. You should always take the bigger division. If the number is divisible by both 2 and 3 it is
also divisible by 6 and you should print only the division by 6. If a number is divisible by 2 it is sometimes also
divisible by 10 and you should print the division by 10. If the number is not divisible by any of the given numbers
print “Not divisible”. Otherwise print "The number is divisible by {number}".
 */
package Fundamentals.Lect1_BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class Ex2_Division {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();
        boolean isTrue = true;

        while (isTrue) {

            if (number % 10 == 0) {
                System.out.printf("The number is divisible by %d", 10);
                break;
            }

            if (number % 7 == 0) {
                System.out.printf("The number is divisible by %d", 7);
                break;
            }

            if (number % 6 == 0) {
                System.out.printf("The number is divisible by %d", 6);
                break;
            }

            if (number % 3 == 0) {
                System.out.printf("The number is divisible by %d", 3);
                break;
            }

            if (number % 2 == 0) {
                System.out.printf("The number is divisible by %d", 2);
                break;
            } else {
                System.out.println("Not divisible");
                isTrue = false;
            }
        }

    }
}
