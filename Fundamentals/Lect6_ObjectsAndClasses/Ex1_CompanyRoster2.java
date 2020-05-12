/*
Define a class Employee that holds the following information: name, salary, position, department, email and age.
The name, salary, position and department are mandatory while the rest are optional.
Your task is to write a program which takes N lines of employees from the console and calculates the department
with the highest average salary and prints for each employee in that department his name, salary, email and age –
sorted by salary in descending order. If an employee doesn’t have an email – in place of that field you should print
“n/a” instead, if he doesn’t have an age – print “-1” instead. The salary should be printed to two decimal places
after the seperator.
Hint: you can define a Department class that holds list of employees.
 */
package Fundamentals.Lect6_ObjectsAndClasses;

import java.util.*;

public class Ex1_CompanyRoster2 {

    public static class Employee {
        private String name;
        private double salary;
        private String position;
        private String department;
        private String email;
        private int age;

        public Employee(String name, double salary, String position, String department, String email, int age) {
            this.name = name;
            this.salary = salary;
            this.position = position;
            this.department = department;
            this.email = email;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public double getSalary() {
            return salary;
        }

        public String getPosition() {
            return position;
        }

        public String getDepartment() {
            return department;
        }

        public String getEmail() {
            return email;
        }

        public int getAge() {
            return age;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        Map<String, List<Employee>> departments = new HashMap<>();

        for (int i = 1; i <= number; i++) {
            String[] line = scanner.nextLine().split("\\s+");
            String name = line[0];
            double salary = Double.parseDouble(line[1]);
            String position = line[2];
            String department = line[3];

            String email = "n/a";
            int age = -1;

            if (line.length == 5) {
                if (line[4].contains("@")) {
                    email = line[4];
                } else {
                    age = Integer.parseInt(line[4]);
                }
            } else if (line.length == 6) {
                email = line[4];
                age = Integer.parseInt(line[5]);
            }

            Employee employee = new Employee(name, salary, position, department, email, age);

            if (!departments.containsKey(department)) {
                departments.put(department, new ArrayList<>());
                departments.get(department).add(employee);
            } else {
                departments.get(department).add(employee);
            }
        }

        departments.entrySet().stream().sorted((a, b) -> {
            double avrFirst = a.getValue().stream().mapToDouble(Employee::getSalary).average().orElse(Double.NaN);
            double avrSecond = b.getValue().stream().mapToDouble(Employee::getSalary).average().orElse(Double.NaN);
            return Double.compare(avrSecond, avrFirst);

        }).limit(1).forEach(e -> {
            System.out.println(String.format("Highest Average Salary: %s", e.getKey()));
            e.getValue().stream()
                    .sorted((a, b) -> Double.compare(b.getSalary(), a.getSalary()))
                    .forEach(empl -> System.out.println(String.format("%s %.2f %s %d", empl.getName(),
                            empl.getSalary(), empl.getEmail(), empl.getAge())));
        });

    }
}

