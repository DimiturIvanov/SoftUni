/*
Write a program which keeps information about companies and their employees.
You will receive company name and employee's id, until you receive the command "End". Add each employee to
the given company. Keep in mind that a company cannot have two employees with the same id.
When you finish reading data, order the companies by the name in ascending order.
Print the company name and each employee's id in the following format:
{companyName}
-- {id1}
-- {id2}
-- {idN}
Input / Constraints
- Until you receive &quot;End&quot;, the input come in the format: "{companyName} -> {employeeId}"
- The input always will be valid
*/
package Fundamentals.Lect7_AssociativeArrays;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Ex8_CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, ArrayList<String>> companies = new TreeMap<>();

        String inPut = scanner.nextLine();

        while (!inPut.equals("End")) {
            String[] employee = inPut.split(" -> ");
            String companyName = employee[0];
            String employeeID = employee[1];

            if (!companies.containsKey(companyName)) {
                companies.put(companyName, new ArrayList<>());
                companies.get(companyName).add(employeeID);
            } else {
                if (!companies.get(companyName).contains(employeeID)) {
                    companies.get(companyName).add(employeeID);
                }
            }
            inPut = scanner.nextLine();
        }

        companies
                .forEach((key, value) -> {
                    System.out.println(key);
                    for (String ID : value) {
                        System.out.println("-- " + ID);
                    }
                });

    }
}
