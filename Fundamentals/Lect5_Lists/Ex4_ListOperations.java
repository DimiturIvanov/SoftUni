/*
You will be given numbers (list of integers) on the first input line. Until you receive &quot;End&quot; you will be given
operations you have to apply on the list. The possible commands are:
- Add {number} - add number at the end
- Insert {number} {index} - insert number at given index
- Remove {index} - remove that index
- Shift left {count} - first number becomes last 'count' times
- Shift right {count} - last number becomes first 'count' times
Note: It is possible that the index given is outside of the bounds of the array. In that case print "Invalid index".
 */
package Fundamentals.Lect5_Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ex4_ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> numbers = (ArrayList<Integer>) Arrays.stream(scanner.nextLine().split(" +"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("End")) {
            String[] array = command.split("\\s+");

            switch (array[0]) {
                case "Add":
                    int addNumbers = Integer.parseInt(array[1]);
                    numbers.add(addNumbers);
                    break;
                case "Insert":
                    int insertNumber = Integer.parseInt(array[1]);
                    int index = Integer.parseInt(array[2]);
                    if (index >= 0 && index < numbers.size()) {
                        numbers.add(index, insertNumber);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Remove":
                    int removeIndex = Integer.parseInt(array[1]);
                    if (removeIndex >= 0 && removeIndex < numbers.size()) {
                        numbers.remove(removeIndex);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Shift":
                    int count = Integer.parseInt(array[2]);
                    if (array[1].equals("left")) {
                        for (int i = 1; i <= count; i++) {
                            numbers.add(numbers.get(0));
                            numbers.remove(0);
                        }
                    } else if (array[1].equals("right")) {
                        for (int i = 1; i <= count; i++) {
                            numbers.add(0, numbers.get(numbers.size() - 1));
                            numbers.remove(numbers.size() - 1);
                        }
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
