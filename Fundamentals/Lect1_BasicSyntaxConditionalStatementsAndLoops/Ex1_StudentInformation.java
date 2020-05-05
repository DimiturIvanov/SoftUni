/*
You will be given 3 lines of input – student name, age and average grade. Your task is to print all the info about the
student in the following format: "Name: {student name}, Age: {student age}, Grade: {student
grade}".
 */
package Fundamentals.Lect1_BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class Ex1_StudentInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int age = scanner.nextInt();
        double grade = scanner.nextDouble();

        System.out.printf("Name: %s, Age: %d, Grade: %.2f", name, age, grade);

    }
}
