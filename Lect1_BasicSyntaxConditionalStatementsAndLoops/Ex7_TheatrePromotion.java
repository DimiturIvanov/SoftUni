/*
A theatre is doing a ticket sale, but they need a program to calculate the price of a single ticket. If the given age
does not fit one of the categories, you should print &quot;Error!&quot;. You can see the prices in the table below:
Input - The input comes in two lines. On the first line, you will receive the type of day. On the second – the age of the
person.
Output - Print the price of the ticket according to the table, or &quot;Error!&quot; if the age is not in the table.
Constrains:
- The age will be in the interval [-1000…1000].
- The type of day will always be valid.
 */
package Fundamentals.Lect1_BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class Ex7_TheatrePromotion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String day = scanner.nextLine();
        int age = scanner.nextInt();

        int price = 0;
        String priceText = "";

        switch (day) {
            case "Weekday":
                if (0 <= age && age <= 18) {
                    price = 12;
                } else if (18 < age && age <= 64) {
                    price = 18;
                } else if (64 < age && age <= 122) {
                    price = 12;
                } else {
                    priceText = "Error!";
                }
                break;
            case "Weekend":
                if (0 <= age && age <= 18) {
                    price = 15;
                } else if (18 < age && age <= 64) {
                    price = 20;
                } else if (64 < age && age <= 122) {
                    price = 15;
                } else {
                    priceText = "Error!";
                }
                break;
            case "Holiday":
                if (0 <= age && age <= 18) {
                    price = 5;
                } else if (18 < age && age <= 64) {
                    price = 12;
                } else if (64 < age && age <= 122) {
                    price = 10;
                } else {
                    priceText = "Error!";
                }
                break;
            default:
                break;
        }

        if (priceText.equals("Error!")) {
            System.out.println(priceText);
        } else {
            System.out.printf("%d$", price);
        }

    }
}
