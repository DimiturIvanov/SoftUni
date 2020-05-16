/*
Until you receive "stop" command, you will be given a sequence of strings, each on a new line. Every odd line on the
console is representing a resource (e.g. Gold, Silver, Copper, etc.) and every even - quantity. Your task is to collect
the resources and print them each on a new line.
Print the resources and their quantities in format: {resource} –> {quantity}
The quantities inputs will be in the range [1 … 2 000 000 000]
 */
package Fundamentals.Lect7_AssociativeArrays;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex2_AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> resourceQuantity = new LinkedHashMap<>();

        String inPut = scanner.nextLine();

        while (!inPut.equals("stop")) {
            String resource = inPut;
            int quantity = Integer.parseInt(scanner.nextLine());

            if (!resourceQuantity.containsKey(resource)) {
                resourceQuantity.put(resource, quantity);
            } else {
                resourceQuantity.put(resource, resourceQuantity.get(resource) + quantity);
            }
            inPut = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> entry : resourceQuantity.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

    }
}
