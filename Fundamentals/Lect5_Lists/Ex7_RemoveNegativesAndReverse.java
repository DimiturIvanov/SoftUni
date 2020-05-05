/*
Read a list of integers, remove all negative numbers from it and print the remaining elements in reversed order. In
case of no elements left in the list, print "empty".
 */
package Fundamentals.Lect5_Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ex7_RemoveNegativesAndReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> numbers = (ArrayList<Integer>) Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        numbers.removeIf(n -> n < 0);
        Collections.reverse(numbers);

        if (numbers.isEmpty()) {
            System.out.println("empty");
        } else {
            System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
        }

    }
}
