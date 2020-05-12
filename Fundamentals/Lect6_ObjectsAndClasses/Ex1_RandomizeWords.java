/*
You are given a list of words on one line. Randomize their order and print each word on a separate line.
 */
package Fundamentals.Lect6_ObjectsAndClasses;

import java.util.Random;
import java.util.Scanner;

public class Ex1_RandomizeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().split(" +");

        Random random = new Random();

        for (int i = 0; i < line.length; i++) {
            int first = random.nextInt(line.length);
            int second = random.nextInt(line.length);

            String swap = line[first];
            line[first] = line[second];
            line[second] = swap;
        }

        for (String word : line) {
            System.out.println(word);
        }

    }
}
