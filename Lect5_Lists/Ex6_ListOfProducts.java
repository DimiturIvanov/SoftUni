/*
Read a number n and n lines of products. Print a numbered list of all the products ordered by name.
 */
package Fundamentals.Lect5_Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ex6_ListOfProducts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberProducts = Integer.parseInt(scanner.nextLine());

        ArrayList<String> products = new ArrayList<>();

        for (int i = 1; i <= numberProducts; i++) {
            String product = scanner.nextLine();
            products.add(product);
        }

        Collections.sort(products);

        for (int i = 0; i < products.size(); i++) {
            System.out.printf("%d.%s%n", i + 1, products.get(i));
        }

    }
}
