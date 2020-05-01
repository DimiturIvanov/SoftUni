/*
Read an integer n from the console. Find all top numbers in the range [1 … n] and print them. A top number holds
the following properties:
- Its sum of digits is divisible by 8, e.g. 8, 16, 88.
- Holds at least one odd digit, e.g. 232, 707, 87578.
 */
package Fundamentals.Lect4_Methods;

import java.util.Scanner;

public class Ex10_TopNumber {
    static boolean isDivisibleByEight(int n) {
        boolean isTrue = true;
        String nString = n + "";
        String[] number = new String[nString.length()];
        int sum = 0;

        for (int i = 0; i < number.length; i++) {
            number[i] = nString.charAt(i) + "";
            sum += Integer.parseInt(number[i]);
        }

        if (sum % 8 != 0) {
            isTrue = false;
        }

        return isTrue;
    }

    static boolean leastOneOddDigit(int n) {
        boolean isTrue = true;
        String nString = n + "";
        String[] number = new String[nString.length()];
        int count = 0;

        for (int i = 0; i < number.length; i++) {
            number[i] = nString.charAt(i) + "";
            if (Integer.parseInt(number[i]) % 2 == 1 && count == 0) {
                count++;
                break;
            }
        }

        if (count == 0) {
            isTrue = false;
        }

        return isTrue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            if (isDivisibleByEight(i) && leastOneOddDigit(i)) {
                System.out.println(i);
            }
        }

    }
}
