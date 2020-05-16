/*
Read an array of strings, take only words which length is even. Print each word on a new line.
 */
package Fundamentals.Lect7_AssociativeArrays;

import java.util.Arrays;
import java.util.Scanner;

public class Ex4_WordFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .filter(word -> word.length() % 2 == 0)
                .toArray(String[]::new);

        Arrays.stream(line)
                .forEach(System.out::println);

    }
}
