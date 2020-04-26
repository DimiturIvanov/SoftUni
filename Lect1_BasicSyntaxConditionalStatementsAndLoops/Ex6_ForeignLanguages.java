/*
Write a program, which prints the language, that a given country speaks. You can receive only the following
combinations: English is spoken in England and USA; Spanish is spoken in Spain, Argentina and Mexico; for the
others, we should print "unknown".
Input - You will receive a single country name on a single line.
Output - Print the language, which the country speaks, or if it is unknown for your program, print "unknown".
 */
package Fundamentals.Lect1_BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class Ex6_ForeignLanguages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String countyName = scanner.nextLine();
        String text;

        switch (countyName) {
            case "England":
            case "USA":
                text = "English";
                break;
            case "Spain":
            case "Argentina":
            case "Mexico":
                text = "Spanish";
                break;
            default:
                text = "unknown";
                break;
        }

        System.out.println(text);

    }
}
