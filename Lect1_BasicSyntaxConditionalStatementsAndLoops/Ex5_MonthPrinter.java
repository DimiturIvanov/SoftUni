/*
Write a program, which takes an integer from the console and prints the corresponding month. If the number is
more than 12 or less than 1 print "Error!".
Input - You will receive a single integer on a single line.
Output - If the number is within the boundaries print the corresponding month, otherwise print "Error!".
 */
package Fundamentals.Lect1_BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class Ex5_MonthPrinter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfMonth = scanner.nextInt();
        String text;

        switch (numberOfMonth) {
            case 1:
                text = "January";
                break;
            case 2:
                text = "February";
                break;
            case 3:
                text = "March";
                break;
            case 4:
                text = "April";
                break;
            case 5:
                text = "May";
                break;
            case 6:
                text = "June";
                break;
            case 7:
                text = "July";
                break;
            case 8:
                text = "August";
                break;
            case 9:
                text = "September";
                break;
            case 10:
                text = "October";
                break;
            case 11:
                text = "November";
                break;
            case 12:
                text = "December";
                break;
            default:
                text = "Error!";
                break;
        }

        System.out.println(text);

    }
}
