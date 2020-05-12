/*
Write a program that receives n count of students and orders them by grade (in descending). Each student should
have first name (string), last name (string) and grade (floating-point number).
Input
- First line will be a number n
- Next n lines you will get a student info in the format "{first name} {second name} {grade}"
Output
- Print each student in the following format "{first name} {second name}: {grade}"
 */
package Fundamentals.Lect6_ObjectsAndClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex5_Students3 {

    static class Student {
        String firstName;
        String secondName;
        double grade;

        public Student(String firstName, String secondName, double grade) {
            this.firstName = firstName;
            this.secondName = secondName;
            this.grade = grade;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getSecondName() {
            return secondName;
        }

        public double getGrade() {
            return grade;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Student> students = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String firstName = scanner.next();
            String secondName = scanner.next();
            double grade = scanner.nextDouble();

            Student student = new Student(firstName, secondName, grade);
            students.add(student);
        }

        students.sort((f, s) -> Double.compare(s.getGrade(), f.getGrade()));

        for (Student student : students) {
            System.out.printf("%s %s: %.2f%n", student.getFirstName(), student.getSecondName(), student.getGrade());
        }

    }
}