/*
The clone factory in Kamino got another order to clone troops. But this time you are tasked to find the best DNA
sequence to use in the production.
You will receive the DNA length and until you receive the command "Clone them!" you will be receiving a DNA
sequences of ones and zeroes, split by "!" (one or several).
You should select the sequence with the longest subsequence of ones. If there are several sequences with same
length of subsequence of ones, print the one with the leftmost starting index, if there are several sequences with
same length and starting index, select the sequence with the greater sum of its elements.
After you receive the last command "Clone them!" you should print the collected information in the following
format:
"Best DNA sample {bestSequenceIndex} with sum: {bestSequenceSum}."
"{DNA sequence, joined by space}"
Input
- The first line holds the length of the sequences – integer in range [1…100];
- On the next lines until you receive "Clone them!" you will be receiving sequences (at least one) of ones and
zeroes, split by "!" (one or several).
Output
The output should be printed on the console and consists of two lines in the following format:
"Best DNA sample {bestSequenceIndex} with sum: {bestSequenceSum}."
"{DNA sequence, joined by space}"
 */
package Fundamentals.Lect3_Arrays;

import java.util.Scanner;

public class Ex9_KaminoFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String input = "";
        int bestSequenceIndex = Integer.MAX_VALUE;
        int bestSequenceSum = 0;
        int bestIndexInARow = 0;
        int bestIndexInARowOutput = 0;
        String sequenceOutput = "";


        while (!"Clone them!".equals(input = scanner.nextLine())) {
            ++bestIndexInARow;

            String[] data = input.split("!+");

            int[] sequenceDNA = new int[size];

            for (int i = 0; i < data.length; i++) {
                sequenceDNA[i] = Integer.parseInt(data[i]);
            }

            int maxCount = 0;
            int sequenceIndex = 0;
            for (int i = 0; i < sequenceDNA.length; i++) {
                int currentCount = 0;
                for (int j = i; j < sequenceDNA.length; j++) {
                    if (sequenceDNA[i] == sequenceDNA[j]) {
                        currentCount++;
                        if (currentCount > maxCount) {
                            maxCount = currentCount;
                            sequenceIndex = i;
                        }
                    } else {
                        break;
                    }
                }
            }
            int sequenceSum = 0;

            for (int i = 0; i < sequenceDNA.length; i++) {

                if (sequenceDNA[i] == 1) {
                    sequenceSum += sequenceDNA[i];
                }
            }
            if (sequenceIndex < bestSequenceIndex || sequenceSum > bestSequenceSum) {
                sequenceOutput = "";
                bestSequenceIndex = sequenceIndex;
                bestSequenceSum = sequenceSum;
                bestIndexInARowOutput = bestIndexInARow;

                for (int i = 0; i < sequenceDNA.length; i++) {
                    sequenceOutput += sequenceDNA[i] + " ";
                }
            }
        }

        System.out.println(String.format("Best DNA sample %d with sum: %d.", bestIndexInARowOutput, bestSequenceSum));
        System.out.println(sequenceOutput.trim());

    }
}
