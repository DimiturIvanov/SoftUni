/*
You will be given an integer that will be distance in meters. Write a program that converts meters to kilometers
formatted to the second decimal point.
 */
package Fundamentals.Lect2_DataTypesAndVariables;

import java.util.Scanner;

public class Ex1_ConvertMetersToKilometers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int meters = scanner.nextInt();

        double kilometers = meters / 1000.0;

        System.out.printf("%.2f", kilometers);

    }
}
