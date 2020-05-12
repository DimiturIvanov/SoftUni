/*
Using the Person class, write a program that reads from the console N lines of personal information and then prints
all people whose age is more than 30 years, sorted in alphabetical order.
Note: you can use stream() to filter people.
 */
package Fundamentals.Lect6_ObjectsAndClasses;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Ex3_OpinionPoll {

    static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        List<Person> people = new ArrayList<>();

        for (int i = 1; i <= number; i++) {
            String name = scanner.next();
            int age = scanner.nextInt();

            Person person = new Person(name, age);
            people.add(person);
        }

        people.stream()
                .filter(age -> age.getAge() > 30)
                .sorted(Comparator.comparing(Person::getName))
                .forEach(System.out::print);

//        Other way
//        people.sort((f, s) -> f.getName().compareTo(s.getName()));
//
//        for (Person p : people) {
//            if (p.getAge() > 30) {
//                System.out.printf("%s - %d%n", p.getName(), p.getAge());
//            }
//        }

    }
}
