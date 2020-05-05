/*
Now we will implement more complicated list commands. Again, read a list, and until you receive "end" read
commands:
Contains {number} – check if the list contains the number. If yes print "Yes", otherwise print "No such number"
Print even – print all the numbers that are even separated by a space
Print odd – print all the numbers that are odd separated by a space
Get sum – print the sum of all the numbers
Filter ({condition} {number}) – print all the numbers that fulfill that condition. The condition will be either '<', '>',
'>=', '<='
 */
package Fundamentals.Lect5_Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ex5_ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> numbers = (ArrayList<Integer>) Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            String[] array = command.split("\\s+");

            switch (array[0]) {
                case "Contains":
                    ;
                    int containsNumber = Integer.parseInt(array[1]);
                    if (numbers.contains(containsNumber)) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }
                    break;
                case "Print":
                    if (array[1].equals("even")) {
                        for (Integer number : numbers) {
                            if (number % 2 == 0) {
                                System.out.print(number + " ");
                            }
                        }
                        System.out.println();
                    } else if (array[1].equals("odd")) {
                        for (Integer number : numbers) {
                            if (number % 2 != 0) {
                                System.out.print(number + " ");
                            }
                        }
                        System.out.println();
                    }
                    break;
                case "Get":
                    int sum = 0;
                    for (Integer number : numbers) {
                        sum += number;
                    }
                    System.out.println(sum);
                    break;
                case "Filter":
                    int number = Integer.parseInt(array[2]);
                    if (array[1].equals("<")) {
                        for (Integer n : numbers) {
                            if (n < number) {
                                System.out.print(n + " ");
                            }
                        }
                        System.out.println();
                    } else if (array[1].equals(">")) {
                        for (Integer n : numbers) {
                            if (n > number) {
                                System.out.print(n + " ");
                            }
                        }
                        System.out.println();
                    } else if (array[1].equals("<=")) {
                        for (Integer n : numbers) {
                            if (n <= number) {
                                System.out.print(n + " ");
                            }
                        }
                        System.out.println();
                    } else if (array[1].equals(">=")) {
                        for (Integer n : numbers) {
                            if (n >= number) {
                                System.out.print(n + " ");
                            }
                        }
                        System.out.println();
                    }
                    break;
                default:
                    break;
            }
            command = scanner.nextLine();
        }

    }
}
