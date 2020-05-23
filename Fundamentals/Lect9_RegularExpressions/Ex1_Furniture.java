/*
Write a program to calculate the total cost of different types of furniture. You will be given some lines of input until
you receive the line "Purchase". For the line to be valid it should be in the following format:
">>{furniture name}<<{price}!{quantity}"
The price can be a floating-point number or a whole number. Store the names of the furniture and the total price. At
the end print each bought furniture on a separate line in the format:
"Bought furniture:
{1 st name}
{2 nd name}
…"
And on the last line print the following: "Total money spend: {spend money}" formatted to the second decimal
point.
 */
package Fundamentals.Lect9_RegularExpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex1_Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = ">>(?<furnitureName>[A-Za-z]+)<<(?<price>\\d+\\.?\\d+)!(?<quantity>\\d+)";

        String inPut = scanner.nextLine();

        List<String> furnitureName = new ArrayList<>();
        double result = 0;

        Pattern pattern = Pattern.compile(regex);

        while (!inPut.equals("Purchase")) {
            double bill = 0;

            Matcher matcher = pattern.matcher(inPut);

            while (matcher.find()) {
                String furniture = matcher.group("furnitureName");
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));

                furnitureName.add(furniture);

                bill = price * quantity;
                result += bill;
            }
            inPut = scanner.nextLine();
        }

        System.out.println("Bought furniture:");
        for (String furniture : furnitureName) {
            System.out.println(furniture);
        }
        System.out.printf("Total money spend: %.2f", result);

    }
}
