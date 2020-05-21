/*
Write a program that reads user names on a single line (joined by ", ") and prints all valid usernames.
A valid username is:
- Has length between 3 and 16 characters
- Contains only letters, numbers, hyphens and underscores
- Has no redundant symbols before, after or in between.
 */
package Fundamentals.Lect8_TextProcessing;

import java.util.Scanner;

public class Ex1_ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().split(", ");

        for (int i = 0; i < line.length; i++) {
            String userNames = line[i];
            boolean isTrue = true;

            if (userNames.length() >= 3 && userNames.length() <= 16) {
                for (int j = 0; j < userNames.length(); j++) {
                    char symbol = userNames.charAt(j);
                    if (!(Character.isLetterOrDigit(symbol) || symbol == '-' || symbol == '_')) {
                        isTrue = false;
                        break;
                    }
                }
            } else {
                isTrue = false;
            }

            if (isTrue) {
                System.out.println(userNames);
            }
        }

    }
}
