/*
Write a program that keeps track of the guests that are going to a house party.
On the first input line you are going to receive how many commands you are going to have. On the next lines you
are going to receive some of the following inputs:
- "{name} is going!"
- "{name} is not going!"
If you receive the first type of input, you have to add the person if he/she is not in the list. (If he/she is in the list
print on the console: "{name} is already in the list!". If you receive the second type of input, you have to remove
the person if he/she is in the list. (If not print: "{name} is not in the list!". At the end print all guests.
 */
package Fundamentals.Lect5_Lists;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex3_HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        ArrayList<String> names = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String line = scanner.nextLine();
            String[] array = line.split(" +");
            String name = array[0];

            if (line.contains("is going!")) {
                if (names.contains(name)) {
                    System.out.printf("%s is already in the list!%n", name);
                } else {
                    names.add(name);
                }
            } else if (line.contains("is not going!")) {
                if (!names.remove(name)) {
                    System.out.printf("%s is not in the list!%n", name);
                }
            }
        }

        for (String name : names) {
            System.out.println(name);
        }

    }
}
