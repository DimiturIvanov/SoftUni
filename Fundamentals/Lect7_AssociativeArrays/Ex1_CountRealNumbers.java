/*
Read a list of real numbers and print them in ascending order along with their number of occurrences.
 */
package Fundamentals.Lect7_AssociativeArrays;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Ex1_CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        TreeMap<Double, Integer> countNumbers = new TreeMap<>();

        for (Double number : numbers) {
            if (!countNumbers.containsKey(number)) {
                countNumbers.put(number, 0);
            }
            countNumbers.put(number, countNumbers.get(number) + 1);
        }

        for (Map.Entry<Double, Integer> entry : countNumbers.entrySet()) {
            DecimalFormat df = new DecimalFormat("#.#######");
            System.out.printf("%s -> %d%n", df.format(entry.getKey()), entry.getValue());
        }

    }
}
