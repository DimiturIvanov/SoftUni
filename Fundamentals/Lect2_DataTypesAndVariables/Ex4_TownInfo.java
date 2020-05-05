/*
You will be given 3 lines of input. On the first line you will be given the name of the town, on the second – the
population and on the third the area. Use the correct data types and print the result in the following format:
"Town {town name} has population of {population} and area {area} square km."
 */
package Fundamentals.Lect2_DataTypesAndVariables;

import java.util.Scanner;

public class Ex4_TownInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String town = scanner.nextLine();
        int population = Integer.parseInt(scanner.nextLine());
        short square = Short.parseShort(scanner.nextLine());

        System.out.printf("Town %s has population of %d and area %d square km.", town, population, square);

    }
}
