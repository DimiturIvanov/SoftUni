/*
Calculate how many courses will be needed to elevate n persons by using an elevator with capacity of p persons.
The input holds two lines: the number of people n and the capacity p of the elevator.
 */
package Fundamentals.Lect2_DataTypesAndVariables;

import java.util.Scanner;

public class Ex3_Elevator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());
        int capacityOfElevator = Integer.parseInt(scanner.nextLine());

        int courses = people / capacityOfElevator;

        if (people % capacityOfElevator != 0) {
            System.out.println(courses + 1);
        } else {
            System.out.println(courses);
        }

    }
}
