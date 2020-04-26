/*
Every time Stamat tries to pay his bills he sees on the cash desk the sign: "I will be back in 30 minutes". One day
Stamat was sick of waiting and decided he needs a program, which prints the time after 30 minutes. That way he
won’t have to wait on the desk and come at the appropriate time. He gave the assignment to you, so you have to do
it.
Input - The input will be on two lines. On the first line, you will receive the hours and on the second you will receive the
minutes.
Output - Print on the console the time after 30 minutes. The result should be in format &quot;hh:mm&quot;. The hours have one or two
numbers and the minutes have always two numbers (with leading zero).
Constraints:
- The hours will be between 0 and 23.
- The minutes will be between 0 and 59.
 */
package Fundamentals.Lect1_BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class Ex4_BackIn30Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hours = scanner.nextInt();
        int seconds = scanner.nextInt();

        int secondsResult = seconds + 30;
        int hoursResult = hours;

        if (secondsResult == 60) {
            secondsResult = 0;
            hoursResult++;
        } else if (secondsResult > 60) {
            secondsResult -= 60;
            hoursResult++;
        }

        if (hoursResult == 24) {
            hoursResult = 0;
        }

        System.out.printf("%d:%02d", hoursResult, secondsResult);

    }
}
