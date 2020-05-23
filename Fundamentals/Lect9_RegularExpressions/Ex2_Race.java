/*
Write a program that processes information about a race. On the first line you will be given a list of participants
separated by ", ". On the next few lines until you receive a line "end of race" you will be given some info which will
be some alphanumeric characters. In between them you could have some extra characters which you should
ignore. For example: "G!32e%o7r#32g$235@!2e". The letters are the name of the person and the sum of the digits
is the distance he ran. So here we have George who ran 29 km. Store the information about the person only if the
list of racers contains the name of the person. If you receive the same person more than once just add the
distance to his old distance. At the end print the top 3 racers ordered by distance in descending in the format:
"1st place: {first racer}
2nd place: {second racer}
3rd place: {third racer}"
 */
package Fundamentals.Lect9_RegularExpressions;

import java.util.*;

public class Ex2_Race {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().split(", ");
        Map<String, Integer> students = new LinkedHashMap<>();

        for (String name : line) {
            if (!students.containsKey(name)) {
                students.put(name, 0);
            }
        }

        String inPut = scanner.nextLine();

        while (!inPut.equals("end of race")) {

            String name = nameFormation(inPut, students);
            int distance = calculateDistance(inPut);

            if (students.containsKey(name.toString())) {
                int lastDistance = students.get(name.toString());
                students.put(name.toString(), lastDistance + distance);
            }

            inPut = scanner.nextLine();
        }

        printFirstThreeStudents(students);

    }

    public static String nameFormation(String inPut, Map<String, Integer> students) {
        StringBuilder name = new StringBuilder();

        for (int i = 0; i < inPut.length(); i++) {
            char symbol = inPut.charAt(i);
            if (Character.isAlphabetic(symbol)) {
                if (!students.containsKey(name.toString())) {
                    name.append(symbol);
                }
            }
        }
        return name.toString();
    }

    public static int calculateDistance(String inPut) {
        int distance = 0;

        for (int i = 0; i < inPut.length(); i++) {
            char symbol = inPut.charAt(i);
            if (Character.isDigit(symbol)) {
                int currentDistance = Integer.parseInt(symbol + "");
                distance += currentDistance;
            }
        }
        return distance;
    }

    public static void printFirstThreeStudents(Map<String, Integer> students) {
        final int[] count = {0};
        students
                .entrySet()
                .stream()
                .sorted((f, s) -> s.getValue().compareTo(f.getValue()))
                .limit(3)
                .forEach(entry -> {
                    count[0] += 1;
                    if (count[0] == 1) {
                        System.out.println("1st place: " + entry.getKey());
                    } else if (count[0] == 2) {
                        System.out.println("2nd place: " + entry.getKey());
                    } else if (count[0] == 3) {
                        System.out.println("3rd place: " + entry.getKey());
                    }
                });
    }

}
