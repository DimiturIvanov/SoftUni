/*
You will be given a string representing a username. The password will be that username reversed. Until you receive
the correct password print on the console "Incorrect password. Try again.". When you receive the correct password
print "User {username} logged in." However on the fourth try if the password is still not correct print "User
{username} blocked!" and end the program.
 */
package Fundamentals.Lect1_BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class Ex5_Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String user = scanner.nextLine();
        String reverse = "";
        String password = "";

        int count = 4;

        for (int i = user.length() - 1; i >= 0; i--) {
            reverse += user.charAt(i);
        }

        while (count > 0) {
            password = scanner.nextLine();
            count--;

            if (password.equals(reverse)) {
                System.out.printf("User %s logged in.", user);
                break;
            } else if (count > 0) {
                System.out.println("Incorrect password. Try again.");
            }

        }
        if (count == 0 && !(password).equals(reverse)) {
            System.out.printf("User %s blocked!", user);
        }
    }
}
