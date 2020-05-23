package Fundamentals.Lect9_RegularExpressions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex6_ExtractEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inPut = scanner.nextLine();
        StringBuilder sb = new StringBuilder();

        String regex = "^|\\s[a-z0-9][\\.\\_\\-a-z0-9]*[a-z0-9]@[a-z0-9][\\.\\-a-z0-9]*[a-z0-9]\\.[a-z]{2,}";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inPut);

        while (matcher.find()) {
            sb.append(matcher.group()).append("\n");
        }

        System.out.println(sb.toString());

    }
}
