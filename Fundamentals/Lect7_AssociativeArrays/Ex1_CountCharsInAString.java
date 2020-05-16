/*
Write a program, which counts all characters in a string except space ('').
Print all occurrences in the following format:
{char} -> {occurrences}
 */
package Fundamentals.Lect7_AssociativeArrays;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex1_CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        Map<Character, Integer> countChars = new LinkedHashMap<>();

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) != ' ') {
                if (!countChars.containsKey(line.charAt(i))) {
                    countChars.put(line.charAt(i), 1);
                } else {
                    countChars.put(line.charAt(i), countChars.get(line.charAt(i)) + 1);
                }
            }
        }

        for (Map.Entry<Character, Integer> entry : countChars.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

    }
}
