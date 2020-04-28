/*
You will be given a count of wagons in a train n. On the next n lines you will receive how many people are going to
get on that wagon. At the end print the whole train and after that the sum of the people in the train.
 */
package Fundamentals.Lect3_Arrays;

import java.util.Scanner;

public class Ex1_Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int maxNumber = Integer.parseInt(scanner.nextLine());
        int[] train = new int[maxNumber];
        int sum = 0;

        for (int i = 0; i < train.length; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            sum += number;
            train[i] = number;
        }

        for (int i = 0; i < train.length; i++) {
            System.out.print(train[i] + " ");
        }

        System.out.println();
        System.out.println(sum);

    }
}
