/*
Write a program to sum all adjacent equal numbers in a list of decimal numbers, starting from left to right.
- After two numbers are summed, the obtained result could be equal to some of its neighbors and should be
summed as well (see the examples below).
- Always sum the leftmost two equal neighbors (if several couples of equal neighbors are available).
 */
package Fundamentals.Lect5_Lists;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ex1_SumAdjacentEqualNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Double> numbers = (ArrayList<Double>) Arrays.stream(scanner.nextLine().split(" ")).map(Double::parseDouble)
                .collect(Collectors.toList());

        int index = 0;

        while (index < numbers.size() - 1) {
            double first = numbers.get(index);
            double second = numbers.get(index + 1);
            if (first == second) {
                double sum = first + second;
                numbers.remove(index);
                numbers.set(index, sum);
                index = 0;
            } else {
                index++;
            }

        }
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(new DecimalFormat("0.#### ").format(numbers.get(i)));
        }

    }
}
