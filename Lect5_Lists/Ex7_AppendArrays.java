/*
Write a program to append several arrays of numbers.
 Arrays are separated by "|"
 Values are separated by spaces (" ", one or several)
 Order the arrays from the last to the first, and their values from left to right

Input
1 2 3 |4 5 6 | 7 8
Output
7 8 4 5 6 1 2 3

Input
7 | 4 5|1 0| 2 5 |3
Output
3 2 5 1 0 4 5 7

Input
1| 4 5 6 7 | 8 9
Output
8 9 4 5 6 7 1
 */
package Fundamentals.Lect5_Lists;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex7_AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().split("\\|");

        ArrayList<String> numbers = new ArrayList<>();

        for (int i = line.length - 1; i >= 0; i--) {
            String[] arrayFromLine = line[i].split(" ");

            for (int j = 0; j < arrayFromLine.length; j++) {
                numbers.add(arrayFromLine[j] + "");
            }
        }

        //Create a new blank list and add a blank space, to use it to remove it from the first list
        ArrayList<String> space = new ArrayList<>();
        space.add("");
        numbers.removeAll(space);

        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));

    }
}
