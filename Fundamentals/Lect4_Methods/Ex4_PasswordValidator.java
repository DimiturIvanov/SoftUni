/*
Write a program that checks if a given password is valid. Password rules are:
- 6 – 10 characters (inclusive);
- Consists only of letters and digits;
- Have at least 2 digits.
If a password is valid, print "Password is valid". If it is not valid, for every unfulfilled rule print a message:
- "Password must be between 6 and 10 characters"
- "Password must consist only of letters and digits"
- "Password must have at least 2 digits"
 */
package Fundamentals.Lect4_Methods;

import java.util.Scanner;

public class Ex4_PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();

        boolean isTrue = true;

        if (password.length() >= 6 && password.length() <= 10) {
        } else {
            System.out.println("Password must be between 6 and 10 characters");
            isTrue = false;
        }

        for (int i = 0; i < password.length(); i++) {
            if ((password.charAt(i) >= '0' && password.charAt(i) <= '9')
                    || (password.charAt(i) >= 'A' && password.charAt(i) <= 'Z')
                    || (password.charAt(i) >= 'a' && password.charAt(i) <= 'z')) {
            } else {
                System.out.println("Password must consist only of letters and digits");
                isTrue = false;
                break;
            }
        }

        int countDigit = 0;
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) >= '0' && password.charAt(i) <= '9') {
                countDigit++;
            }
        }

        if (countDigit < 2) {
            System.out.println("Password must have at least 2 digits");
            isTrue = false;
        }

        if (isTrue) {
            System.out.println("Password is valid");
        }

    }
}
