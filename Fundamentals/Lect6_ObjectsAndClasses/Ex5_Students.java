/*
Define a class Student, which holds the following information about students: first name, last name, age and
hometown.
Read list of students until you receive "end" command. After that, you will receive a city name. Print only students
which are from the given city, in the following format: "{firstName} {lastName} is {age} years old."
 */
package Fundamentals.Lect6_ObjectsAndClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ex5_Students {

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

            Student student = new Student(firstName, lastName, age, homeTown);
            students.add(student);

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
