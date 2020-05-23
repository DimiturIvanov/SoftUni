/*
Write a program, which matches a date in the format “dd{separator}MMM{separator}yyyy”. Use named
capturing groups in your regular expression.
Compose the Regular Expression
Every valid date has the following characteristics:
 Always starts with two digits, followed by a separator
 After that, it has one uppercase and two lowercase letters (e.g. Jan, Mar).
 After that, it has a separator and exactly 4 digits (for the year).
 The separator could be either of three things: a period (“.”), a hyphen (“-“) or a forward slash (“/”)
 The separator needs to be the same for the whole date (e.g. 13.03.2016 is valid, 13.03/2016 is NOT). Use
a group backreference to check for this.
Now it’s time to find all the valid dates in the input and print each date in the following format: “Day: {day},
Month: {month}, Year: {year}”, each on a new line.
ForExample
Input
13/Jul/1928, 10-Nov-1934, , 01/Jan-1951,f 25.Dec.1937 23/09/1973, 1/Feb/2016
Output
Day: 13, Month: Jul, Year: 1928
Day: 10, Month: Nov, Year: 1934
Day: 25, Month: Dec, Year: 1937
 */
package Fundamentals.Lect9_RegularExpressions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex3_MatchDates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "\\b(?<day>\\d{2})([-.\\/])(?<month>[A-Z][a-z]{2})\\2(?<year>\\d{4})\\b";

        String line = scanner.nextLine();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);

        while (matcher.find()) {
            String day = matcher.group("day");
            String month = matcher.group("month");
            String year = matcher.group("year");

            System.out.printf("Day: %s, Month: %s, Year: %s%n", day, month, year);
        }

    }
}
