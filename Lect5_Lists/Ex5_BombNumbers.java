/*
Write a program that reads sequence of numbers and special bomb number with a certain power. Your task is to
detonate every occurrence of the special bomb number and according to its power - his neighbors from left and
right. Detonations are performed from left to right and all detonated numbers disappear. Finally print the sum of
the remaining elements in the sequence.
 */
package Fundamentals.Lect5_Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ex5_BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> numbers = (ArrayList<Integer>) Arrays.stream(scanner.nextLine().split(" +"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int specialBomb = scanner.nextInt();
        int power = scanner.nextInt();

        int removeElementAfterAll = Integer.MAX_VALUE;

        while (numbers.contains(specialBomb)) {
            int index = numbers.indexOf(specialBomb);

            numbers.set(index, removeElementAfterAll);

            //check to the right of the special number (specialBomb)
            int plusOnePosition = 1;
            for (int i = 1; i <= power; i++) {
                int currentIndex = index + plusOnePosition;
                if (currentIndex < numbers.size()) {
                    numbers.set(currentIndex, removeElementAfterAll);
                }
                plusOnePosition++;
            }

            //check to the left of the special number (specialBomb)
            int minusOnePosition = 1;
            for (int i = 1; i <= power; i++) {
                int currentIndex = index - minusOnePosition;
                if (currentIndex >= 0 && currentIndex < numbers.size()) {
                    numbers.set(currentIndex, removeElementAfterAll);
                }
                minusOnePosition++;
            }
        }

        numbers.removeIf(e -> e == removeElementAfterAll);

        int sum = 0;
        for (Integer n : numbers) {
            sum += n;
        }
        System.out.println(sum);

    }
}
