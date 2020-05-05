/*
Write a method that receives a grade between 2.00 and 6.00 and prints the corresponding grade in words:
 */
package Fundamentals.Lect4_Methods;

import java.util.Scanner;

public class Ex2_Grades {
    static void grade(double grade) {

        String text = "";

        if (grade >= 2 && grade < 3) {
            text = "Fail";
        } else if (grade >= 3 && grade < 3.5) {
            text = "Poor";
        } else if (grade >= 3.5 && grade < 4.5) {
            text = "Good";
        } else if (grade >= 4.5 && grade < 5.5) {
            text = "Very good";
        } else if (grade >= 5.5) {
            text = "Excellent";
        }
        System.out.println(text);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double grade = Double.parseDouble(scanner.nextLine());
        grade(grade);

    }
}

