/*
Write a program to calculate the winner of a car race. You will receive an array of numbers. Each element of the
array represents the time needed to pass through that step (the index). There are going to be two cars. One of
them starts from the left side and the other one starts from the right side. The middle index of the array is the
finish line. (The number of elements of the array will always be odd). Calculate the total time for each racer to
reach the finish (the middle of the array) and print the winner with his total time. (The racer with less time). If you
have a zero in the array, you have to reduce the time of the racer that reached it by 20% (from the time so far).
Print the result in the following format "The winner is {left/right} with total time: {total time}", formatted with one
digit after the decimal point.
 */
package Fundamentals.Lect5_Lists;

import java.util.Arrays;
import java.util.Scanner;

public class Ex2_CarRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        double leftRacer = 0;
        double rightRacer = 0;

        for (int i = 0; i < numbers.length / 2; i++) {
            leftRacer += numbers[i];
            if (numbers[i] == 0) {
                leftRacer = leftRacer - (leftRacer * 0.2);
            }
        }

        for (int i = numbers.length - 1; i > numbers.length / 2; i--) {
            rightRacer += numbers[i];
            if (numbers[i] == 0) {
                rightRacer = rightRacer - (rightRacer * 0.2);
            }
        }

        if (leftRacer > rightRacer) {
            System.out.printf("The winner is right with total time: %.1f", rightRacer);
        } else if (rightRacer > leftRacer) {
            System.out.printf("The winner is left with total time: %.1f", leftRacer);
        }

    }
}
