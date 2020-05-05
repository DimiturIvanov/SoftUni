/*
Write a method that calculates the total price of an order and prints it on the console. The method should receive
one of the following products: coffee, water, coke, snacks; and a quantity of the product. The prices for a single
piece of each product are:
- coffee – 1.50
- water – 1.00
- coke – 1.40
- snacks – 2.00
Print the result rounded to the second decimal place.
 */
package Fundamentals.Lect4_Methods;

import java.util.Scanner;

public class Ex5_Orders {
    static double calculateThePrice(String product, int quantity) {
        double price = 0;
        switch (product) {
            case "coffee":
                price = 1.5;
                break;
            case "water":
                price = 1;
                break;
            case "coke":
                price = 1.4;
                break;
            case "snacks":
                price = 2;
                break;
            default:
                break;
        }
        return quantity * price;
    }

    static void printThePrice(String product, int quantity) {
        String result = "";
        result = String.format("%.2f", calculateThePrice(product, quantity));
        System.out.println(result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());

        printThePrice(product, quantity);

    }
}
