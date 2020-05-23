package Fundamentals.Lect9_RegularExpressions;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Ex5_NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> demons = Arrays
                .stream(scanner.nextLine().split("[, ]+"))
                .sorted(String::compareTo)
                .collect(Collectors.toList());

        String healthRegex = "([^\\d+\\-*.\\/])";

        String damageRegex = "(-?\\d+\\.?\\d*)";

        String operationRegex = "([*/])";

        Pattern healthPAttern = Pattern.compile(healthRegex);

        Pattern damagePattern = Pattern.compile(damageRegex);

        Pattern operationPattern = Pattern.compile(operationRegex);

        for (String demon : demons) {
            Matcher matcher = healthPAttern.matcher(demon);

            int health = 0;

            while (matcher.find()) {
                health += matcher.group(1).charAt(0);
            }

            matcher = damagePattern.matcher(demon);

            double damage = 0;

            while (matcher.find()) {
                damage += Double.parseDouble(matcher.group(1));
            }

            matcher = operationPattern.matcher(demon);

            while (matcher.find()) {
                if (matcher.group(1).equals("*")) {
                    damage *= 2;
                } else {
                    damage /= 2;
                }
            }

            System.out.printf("%s - %d health, %.2f damage%n", demon, health, damage);
        }

    }
}
