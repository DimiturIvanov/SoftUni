/*
Write a program that sum all numbers in a list in the following order:
first + last, first + 1 + last - 1, first + 2 + last - 2, … first + n, last - n.
 */
package Fundamentals.Lect5_Lists;

import java.util.*;
import java.util.stream.Collectors;

public class Ex2_GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> numbers = (ArrayList<Integer>) Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());

        ArrayList<Integer> resultNumbers = new ArrayList<>();

        for (int i = 0; i < numbers.size() / 2; i++) {
            int first = numbers.get(i);
            int second = numbers.get(numbers.size() - 1 - i);
            int sum = first + second;
            resultNumbers.add(sum);
        }

        if (numbers.size() % 2 == 1) {
            resultNumbers.add(numbers.get(numbers.size() / 2));
        }

        for (Integer n : resultNumbers) {
            System.out.print(n + " ");
        }

    }
}
