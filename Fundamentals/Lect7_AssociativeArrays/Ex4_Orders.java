/*
Write a program, which keeps information about products and their prices. Each product has a name, a price and its
quantity. If the product doesn`t exist yet, add it with its starting quantity.
If you receive a product, which already exists, increase its quantity by the input quantity and if its price is different,
replace the price as well.
You will receive products` names, prices and quantities on new lines. Until you receive the command "buy", keep
adding items. When you do receive the command "buy", print the items with their names and total price of all the
products with that name.
Input
- Until you receive "buy", the products come in the format: "{name} {price} {quantity}"
- The product data is always delimited by a single space
Output
- Print information about each product, following the format:
"{productName} -> {totalPrice}"
- Format the average grade to the 2 nd decimal place
 */
package Fundamentals.Lect7_AssociativeArrays;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex4_Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        Map<String, Double> priceAndName = new LinkedHashMap<>();
        Map<String, Integer> quantitiesAndName = new LinkedHashMap<>();

        while (!line.equals("buy")) {
            String[] inPut = line.split("\\s+");
            String name = inPut[0];
            double price = Double.parseDouble(inPut[1]);
            int quantities = Integer.parseInt(inPut[2]);

            if (!quantitiesAndName.containsKey(name)) {
                priceAndName.put(name, price);
                quantitiesAndName.put(name, quantities);
            } else {
                priceAndName.put(name, price);
                int currentQuantities = quantitiesAndName.get(name);
                quantitiesAndName.put(name, currentQuantities + quantities);
            }

            line = scanner.nextLine();
        }

        for (var entry : priceAndName.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            for (var entry2 : quantitiesAndName.entrySet()) {
                if (entry.getKey().equals(entry2.getKey())) {
                    System.out.printf("%.2f%n", entry.getValue() * entry2.getValue());
                }
            }
        }

    }
}
