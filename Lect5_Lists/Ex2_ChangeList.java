/*
Write a program, which reads a list of integers from the console and receives commands, which manipulate the list.
Your program may receive the following commands:
- Delete {element} - delete all elements in the array, which are equal to the given element
- Insert {element} {position} - insert element at the given position
You should stop the program when you receive the command "end". Print all numbers in the array separated with
a single whitespace.
 */
package Fundamentals.Lect5_Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ex2_ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> numbers = (ArrayList<Integer>) Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            String[] array = command.split("\\s+");

            switch (array[0]) {
                case "Delete":
                    int deleteNumber = Integer.parseInt(array[1]);
                    while (numbers.remove(Integer.valueOf(deleteNumber))) {
                    }
                    break;
                case "Insert":
                    int insertNumber = Integer.parseInt(array[1]);
                    int position = Integer.parseInt(array[2]);
                    if (position >= 0 && position < numbers.size()) {
                        numbers.add(position, insertNumber);
                    }
                    break;
                default:
                    break;
            }
            command = scanner.nextLine();
        }

        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));

    }
}
