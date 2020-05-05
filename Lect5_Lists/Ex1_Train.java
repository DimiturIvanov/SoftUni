/*
On the first line you will be given a list of wagons (integers). Each integer represents the number of passengers that
are currently in each wagon. On the next line you will get the max capacity of each wagon (single integer). Until you
receive "end" you will be given two types of input:
- Add {passengers} - add a wagon to the end with the given number of passengers
- {passengers} - find an existing wagon to fit all the passengers (starting from the first wagon)
At the end print the final state of the train (all the wagons separated by a space)
 */
package Fundamentals.Lect5_Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ex1_Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> listOfWagons = (ArrayList<Integer>) Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int maxCapacityWagon = Integer.parseInt(scanner.nextLine());

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            String[] array = command.split("\\s+");

            if (array[0].equals("Add")) {
                listOfWagons.add(Integer.parseInt(array[1]));
            } else {
                int sum = 0;
                for (int i = 0; i < listOfWagons.size(); i++) {
                    int number = Integer.parseInt(array[0]);
                    if ((number + listOfWagons.get(i)) <= maxCapacityWagon) {
                        listOfWagons.set(i, Integer.parseInt(array[0]) + listOfWagons.get(i));
                        break;
                    }
                }
            }
            command = scanner.nextLine();
        }

        System.out.println(listOfWagons.toString().replaceAll("[\\[\\],]", ""));

    }
}
