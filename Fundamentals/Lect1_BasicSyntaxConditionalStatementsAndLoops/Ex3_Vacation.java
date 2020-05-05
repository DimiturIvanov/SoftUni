/*
You are given a group of people, type of the group, on which day of the week they are going to stay. Based on that
information calculate how much they have to pay and print that price on the console. Use the table below. In each
cell is the price for a single person. The output should look like that: "Total price: {price}". The price should be
formatted to the second decimal point.
TABLE:
There are also discounts based on some conditions:
- Students – if the group is bigger than or equal to 30 people you should reduce the total price by 15%
- Business – if the group is bigger than or equal to 100 people 10 of them can stay for free.
- Regular – if the group is bigger than or equal 10 and less than or equal to 20 reduce the total price by 5%
 */
package Fundamentals.Lect1_BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class Ex3_Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberPeople = scanner.nextInt();
        String typeGroup = scanner.next();
        String day = scanner.next();

        double price = 0;
        double totalPrice = 0;

        switch (typeGroup) {
            case "Students":
                switch (day) {
                    case "Friday":
                        price = 8.45;
                        break;
                    case "Saturday":
                        price = 9.80;
                        break;
                    case "Sunday":
                        price = 10.46;
                    default:
                        break;
                }
                totalPrice = price * numberPeople;
                if (numberPeople >= 30) {
                    totalPrice = totalPrice - (totalPrice * 0.15);
                }
                break;
            case "Business":
                switch (day) {
                    case "Friday":
                        price = 10.90;
                        break;
                    case "Saturday":
                        price = 15.60;
                        break;
                    case "Sunday":
                        price = 16;
                    default:
                        break;
                }
                totalPrice = price * numberPeople;
                if (numberPeople >= 100) {
                    totalPrice = totalPrice - (10 * price);
                }
                break;
            case "Regular":
                switch (day) {
                    case "Friday":
                        price = 15;
                        break;
                    case "Saturday":
                        price = 20;
                        break;
                    case "Sunday":
                        price = 22.50;
                    default:
                        break;
                }
                totalPrice = price * numberPeople;
                if (numberPeople >= 10 && numberPeople <= 20) {
                    totalPrice = totalPrice - (totalPrice * 0.05);
                }
                break;
            default:
                break;
        }

        System.out.printf("Total price: %.2f", totalPrice);

    }
}
