/*
Write a program that extracts from a given sequence of words all elements that are present in it an odd number of
times (case-insensitive).
- Words are given in a single line, space separated
- Print the result elements in lowercase in their order of appearance
 */
package Fundamentals.Lect7_AssociativeArrays;

import java.util.*;

public class Ex3_OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        line = line.toLowerCase();

        String[] arrayLine = line.split("\\s+");

        Map<String, Integer> wordCount = new LinkedHashMap<>();

        for (int i = 0; i < arrayLine.length; i++) {
            String word = arrayLine[i];

            if (!wordCount.containsKey(word)) {
                wordCount.put(word, 1);
            } else {
                wordCount.put(word, wordCount.get(word) + 1);
            }
        }

        List<String> words = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                words.add(entry.getKey());
            }
        }

        String wordsJoined = String.join(", ", words);
        System.out.println(wordsJoined);

    }
}
