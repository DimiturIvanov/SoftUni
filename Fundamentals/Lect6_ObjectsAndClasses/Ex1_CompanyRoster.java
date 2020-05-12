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

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ex1_CompanyRoster {

    static class Department {
        private String name;
        private List<Employee> employees;
        private double averageSalary;

        public Department(String name, List<Employee> employees, double averageSalary) {
            this.name = name;
            this.employees = employees;
            this.averageSalary = averageSalary;
        }

        public Department(String name, List<Employee> employees) {
            this.name = name;
            this.employees = employees;
        }

        public String getName() {
            return name;
        }

        public List<Employee> getEmployees() {
            return employees;
        }

        public double getAverageSalary() {
            return averageSalary;
        }
    }

    static class Employee {
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

        List<Employee> employees = new ArrayList<>();

        int numberEmployees = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= numberEmployees; i++) {
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
            employees.add(employee);

        }

        double highestAverageSalary = 0.0;
        String bestDepartment = "";

        List<String> departmentsList = employees.stream().
                map(Employee::getDepartment).
                distinct().collect(Collectors.toList());

        for (String department : departmentsList) {
            double sum = 0.0;
            int count = 0;
            for (Employee employee : employees) {
                if (employee.getDepartment().equals(department)) {
                    sum += employee.getSalary();
                    count++;
                }
            }
            if (sum / count > highestAverageSalary) {
                highestAverageSalary = sum / count;
                bestDepartment = department;
            }
        }

        System.out.println("Highest Average Salary: " + bestDepartment);
        String finalBestDepartment = bestDepartment;
        String finalBestDepartment1 = bestDepartment;
        employees.stream().filter(empl -> empl.getDepartment().equals(finalBestDepartment1))
                .sorted((a, b) -> Double.compare(b.getSalary(), a.getSalary()))
                .forEach(empl -> System.out.println(String.format("%s %.2f %s %d", empl.getName(),
                        empl.getSalary(), empl.getEmail(), empl.getAge())));

    }
}



