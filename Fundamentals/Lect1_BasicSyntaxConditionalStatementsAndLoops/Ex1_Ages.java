/*
Write a program that determines whether based on the given age a person is: baby, child, teenager, adult, elder.
The bounders are:
- 0-2 – baby;
- 3-13 – child;
- 14-19 – teenager;
- 20-65 – adult;
- >=66 – elder;
- All the values are inclusive.
 */
package Fundamentals.Lect1_BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class Ex1_Ages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int age = scanner.nextInt();
        String text = "";

        if (0 <= age && age <= 2) {
            text = "baby";
        } else if (3 <= age && age <= 13) {
            text = "child";
        } else if (14 <= age && age <= 19) {
            text = "teenager";
        } else if (20 <= age && age <= 65) {
            text = "adult";
        } else if (age >= 66) {
            text = "elder";
        }

        System.out.println(text);

    }
}
