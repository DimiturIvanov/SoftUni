/*
Use the class from the previous problem. If you receive a student which already exists (first name and last name
should be unique) overwrite the information.

 */
package Fundamentals.Lect6_ObjectsAndClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ex6_Students2 {

    static class Student {
        private String firstName;
        private String lastName;
        private int age;
        private String homeTown;

        public Student(String firstName, String lastName, int age, String homeTown) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.homeTown = homeTown;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public int getAge() {
            return age;
        }

        public String getHomeTown() {
            return homeTown;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setHomeTown(String homeTown) {
            this.homeTown = homeTown;
        }
    }

    public static Student findStudent(List<Student> students, String firstName, String lastName) {
        Student existingStudent = null;

        for (Student student : students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                existingStudent = student;
            }
        }
        return existingStudent;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Student> students = new ArrayList<>();

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            String[] line = command.split("\\s+");
            String firstName = line[0];
            String lastName = line[1];
            int age = Integer.parseInt(line[2]);
            String homeTown = line[3];

            Student existingStudent = findStudent(students, firstName, lastName);

            if (existingStudent != null) {
                existingStudent.setAge(age);
                existingStudent.setHomeTown(homeTown);
            } else {
                Student student = new Student(firstName, lastName, age, homeTown);
                students.add(student);
            }

            command = scanner.nextLine();
        }

        String city = scanner.nextLine();

        List<Student> givenCityStudents = students.stream()
                .filter(e -> e.getHomeTown().equals(city))
                .collect(Collectors.toList());

        for (Student student : givenCityStudents) {
            System.out.printf("%s %s is %d years old%n", student.getFirstName(), student.getLastName(), student.getAge());
        }

    }
}
