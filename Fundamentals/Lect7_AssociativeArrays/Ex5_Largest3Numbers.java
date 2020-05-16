/*
Read a list of integers and print largest 3 of them. If there are less than 3, print all of them.
 */
package Fundamentals.Lect7_AssociativeArrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Ex5_Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        Integer[] numbers = Arrays.
//                stream(scanner.nextLine().split("\\s+"))
//                .map(Integer::parseInt)
//                .sorted(Comparator.reverseOrder())
//                .toArray(Integer[]::new);
//
//        for (int i = 0; i < numbers.length; i++) {
//            if (i < 3) {
//                System.out.print(numbers[i] + " ");
//            }
//        }

        List<String> numbers = Arrays.asList(scanner.nextLine().split("\\s+"));
        numbers
                .stream().map(Integer::parseInt)
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .forEach(number -> System.out.print(number + " "));

    }
}
