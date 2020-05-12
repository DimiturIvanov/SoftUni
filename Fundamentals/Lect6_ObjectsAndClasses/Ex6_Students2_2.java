package Fundamentals.Lect6_ObjectsAndClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ex6_Students2_2 {

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

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setHomeTown(String homeTown) {
            this.homeTown = homeTown;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Student> students = new ArrayList<>();

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            String[] line = command.split(" +");
            String firstName = line[0];
            String lastName = line[1];
            int age = Integer.parseInt(line[2]);
            String homeTown = line[3];

            Student student = students
                    .stream()
                    .filter(s -> s.getFirstName().equals(firstName) && s.getLastName().equals(lastName))
                    .findFirst()
                    .orElse(null);

            if (student == null) {
                Student studentToAdd = new Student(firstName, lastName, age, homeTown);
                students.add(studentToAdd);
            } else {
                student.setFirstName(firstName);
                student.setLastName(lastName);
                student.setAge(age);
                student.setHomeTown(homeTown);
            }

            command = scanner.nextLine();
        }

        String city = scanner.nextLine();

        List<Student> givenCityStudents = students.stream()
                .filter(s -> s.getHomeTown().equals(city))
                .collect(Collectors.toList());

        for (Student student : givenCityStudents) {
            System.out.printf("%s %s is %d years old%n", student.getFirstName(), student.getLastName(), student.getAge());
        }

    }
}
