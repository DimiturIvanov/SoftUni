/*
Write a program that reads a list of integers. Then until you receive "end", you will be given different commands:
Add {number}: add a number to the end of the list
Remove {number}: remove a number from the list
RemoveAt {index}: remove a number at a given index
Insert {number} {index}: insert a number at a given index
Note: All the indices will be valid!
When you receive the "end" command print the final state of the list (separated by spaces)
 */
package Fundamentals.Lect5_Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ex4_ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> numbers = (ArrayList<Integer>) Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            String[] array = command.split("\\s+");

            switch (array[0]) {
                case "Add":
                    int addNumber = Integer.parseInt(array[1]);
                    numbers.add(addNumber);
                    break;
                case "Remove":
                    int removeNumbers = Integer.parseInt(array[1]);
                    numbers.remove(Integer.valueOf(removeNumbers));
                    break;
                case "RemoveAt":
                    int removeIndex = Integer.parseInt(array[1]);
                    numbers.remove(removeIndex);
                    break;
                case "Insert":
                    int insertNumber = Integer.parseInt(array[1]);
                    int insertIndex = Integer.parseInt(array[2]);
                    numbers.add(insertIndex, insertNumber);
                    break;
                default:
                    break;
            }
            command = scanner.nextLine();
        }

        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));

    }
}
