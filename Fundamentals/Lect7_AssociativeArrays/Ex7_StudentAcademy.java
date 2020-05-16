/*
Write a program, which keeps information about students and their grades.
On the first line you will receive number n. After that you will receive n pair of rows. First you will receive the
student`s name, after that you will receive his grade. Check if student already exists, and if not - add him. Keep
track of all grades for each student.
When you finish reading data, keep students with average grade higher or equal to 4.50. Order filtered students by
average grade in descending order.
Print the students and their average grade in format:
"{name} –> {averageGrade}"
Format the average grade to the 2 nd decimal place.
 */
package Fundamentals.Lect7_AssociativeArrays;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex7_StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Double> students = new LinkedHashMap<>();

        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= number; i++) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            if (!students.containsKey(name)) {
                students.put(name, grade);
            } else {
                double currentGrade = students.get(name);
                students.put(name, (currentGrade + grade) / 2);
            }
        }

        students.entrySet()
                .stream()
                .sorted((f, s) -> Double.compare(s.getValue(), f.getValue()))
                .forEach(entry -> {
                    if (entry.getValue() >= 4.50) {
                        System.out.printf("%s -> %.2f%n", entry.getKey(), entry.getValue());
                    }
                });

    }
}
