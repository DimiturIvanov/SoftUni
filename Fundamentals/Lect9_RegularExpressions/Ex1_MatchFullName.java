/*
Write a Java Program to match full names from a list of names and print them on the console.
Writing the Regular Expression
First, write a regular expression to match a valid full name, according to these conditions:
 A valid full name has the following characteristics:
o It consists of two words.
o Each word starts with a capital letter.
o After the first letter, it only contains lowercase letters afterwards.
o Each of the two words should be at least two letters long.
o The two words are separated by a single space.
 */
package Fundamentals.Lect9_RegularExpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex1_MatchFullName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "\\b[A-Z][a-z]+ [A-Z][a-z]+\\b";

        String line = scanner.nextLine();

        List<String> names = new ArrayList<>();

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(line);

        while (matcher.find()) {
            names.add(matcher.group());
        }

        System.out.printf("%s", String.join(" ", names));

    }
}
