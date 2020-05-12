/*
You will receive an unknown number of lines. On each line, you will receive an array with 3 elements. The first
element will be string and represents the name of the person. The second element will be a string and will
represent the ID of the person. The last element will be an integer which represents the age of the person.
When you receive the command "End", stop taking input and print all the people, ordered by age.
 */
package Fundamentals.Lect6_ObjectsAndClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex7_OrderByAge {

    static class Person {
        private String name;
        private String ID;
        private int age;

        public Person(String name, String ID, int age) {
            this.name = name;
            this.ID = ID;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public String getID() {
            return ID;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return String.format("%s with " +
                    "ID: %s " +
                    "is %d years old.", getName(), getID(), getAge());
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();

        String inPut = scanner.nextLine();

        while (!inPut.equals("End")) {
            String[] line = inPut.split(" +");

            String name = line[0];
            String ID = line[1];
            int age = Integer.parseInt(line[2]);

            Person person = new Person(name, ID, age);
            people.add(person);

            inPut = scanner.nextLine();
        }

        people.sort((f, s) -> Integer.compare(f.getAge(), s.getAge()));

        for (Person person : people) {
            System.out.println(person);
        }

    }
}
