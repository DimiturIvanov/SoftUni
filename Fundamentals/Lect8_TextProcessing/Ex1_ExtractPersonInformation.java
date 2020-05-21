/*
Write a program that reads n lines of strings and extracts the name and age of a given person. The name of the
person will be between '@' and '|'. The person’s age will be between '#' and '*'. Example: "Hello my name is
@Peter| and I am #20* years old." For each found name and age print a line in the following format "{name} is
{age} years old."
 */
package Fundamentals.Lect8_TextProcessing;

import java.util.Scanner;

public class Ex1_ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= number; i++) {
            String line = scanner.nextLine();

            String name = findName(line);
            int age = findAge(line);

            System.out.printf("%s is %d years old.%n", name, age);
        }
    }

    public static String findName(String line) {
        String name = "";

        for (int j = 0; j < line.length(); j++) {
            char firstSymbol = line.charAt(j);

            int first = -1;
            int second = -1;

            if (firstSymbol == '@') {
                first = line.indexOf(firstSymbol);
                for (int k = first; k < line.length(); k++) {
                    char secondSymbol = line.charAt(k);
                    if (secondSymbol == '|') {
                        second = line.indexOf(secondSymbol);
                    }
                }
            }
            if (first != 1 && second != -1) {
                for (int k = first + 1; k < second; k++) {
                    name += line.charAt(k);
                }
            }
        }
        return name;
    }

    public static int findAge(String line) {
        String stringAge = "";
        int age = 0;

        for (int j = 0; j < line.length(); j++) {
            char firstSymbol = line.charAt(j);

            int first = -1;
            int second = -1;

            if (firstSymbol == '#') {
                first = line.indexOf(firstSymbol);
                for (int k = first; k < line.length(); k++) {
                    char secondSymbol = line.charAt(k);
                    if (secondSymbol == '*') {
                        second = line.indexOf(secondSymbol);
                    }
                }
            }
            if (first != -1 && second != -1) {
                for (int k = first + 1; k < second; k++) {
                    stringAge += line.charAt(k);
                }
            }
        }
        age = Integer.parseInt(stringAge);
        return age;
    }
}
