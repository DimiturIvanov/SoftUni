/*
Let`s take a break and visit the game bar at SoftUni. It is about time for the people behind the bar to go home and
you are the person who has to draw the line and calculate the money from the products that were sold throughout
the day. Until you receive a line with text "end of shift" you will be given lines of input. But before processing
that line you have to do some validations first.
Each valid order should have a customer, product, count and a price:
 Valid customer`s name should be surrounded by '%' and must start with a capital letter, followed by lower-
case letters
 Valid product contains any word character and must be surrounded by '<' and '>'
 Valid count is an integer, surrounded by '|'
 Valid price is any real number followed by '&'
The parts of a valid order should appear in the order given: customer, product, count and a price.
Between each part there can be other symbols, except ('|', '$', '%' and '.')
For each valid line print on the console: "{customerName}: {product} - {totalPrice}"
When you receive "end of shift" print the total amount of money for the day rounded to 2 decimal places in
the following format: "Total income: {income}".
 */
package Fundamentals.Lect9_RegularExpressions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex3_SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inPut = scanner.nextLine();

        String regex = "%(?<name>[A-Z][a-z]+)%[^|$%.]*?<(?<product>\\w+)>[^|$%.]*?\\|(?<quantity>\\d+)\\|[^|$%.]*?(?<price>\\d+\\.?\\d*)\\$";
        Pattern patter = Pattern.compile(regex);
        double totalIncome = 0;

        while (!inPut.equals("end of shift")) {

            Matcher matcher = patter.matcher(inPut);

            while (matcher.find()) {
                String name = matcher.group("name");
                String product = matcher.group("product");
                int quantity = Integer.parseInt(matcher.group("quantity"));
                double price = Double.parseDouble(matcher.group("price"));

                double totalPrice = quantity * price;
                totalIncome += totalPrice;

                System.out.printf("%s: %s - %.2f%n", name, product, totalPrice);
            }
            inPut = scanner.nextLine();
        }

        System.out.printf("Total income: %.2f", totalIncome);

    }
}
