/*
You know the jude system, right?! Your job is to create a program similar to the Judge system.
You will receive several input lines in the following format:
{username} -> {contest} -> {points}
The constestName and username are strings, the given points will be an integer number. You need to keep track of
every contest and individual statistics of every user. You should check if such contest already exists, and if not, add
it, otherwise check if the current user is participating in the contest, if he is participating take the higher score,
otherwise just add it.
Also you need to keep individual statistics for each user - the total points of all constests.
You should end your program when you receive the command "no more time". At that point you should print each
contest in order of input, for each contest print the participants ordered by points in desecending order, than
ordered by name in ascending order. After that, you should print individual statistics for every participant ordered
by total points in desecnding order, and then by alphabetical order.
Input / Constraints
- The input comes in the form of commands in the format specified above
- Username and contest name always will be one word
- Points will be an integer in range [0, 1000]
- There will be no invalid input lines
- If all sorting criteria fail, the order should be by order of input
- The input ends when you receive the command "no more time"
Output
- The output format for the contests is:
{constestName}: {participants.Count} participants
{position}. {username} <::> {points}
- After you print all contests, print the individual statistics for every participant
- The output format is:
Individual standings:
{position}. {username} -> {totalPoints}
 */
package Fundamentals.Lect7_AssociativeArrays;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Ex2_Judge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inPut = scanner.nextLine();

        Map<String, Map<String, Integer>> courses = new LinkedHashMap<>();
        Map<String, Integer> students = new TreeMap<>();

        while (!inPut.equals("no more time")) {

            String[] line = inPut.split(" -> ");
            String studentName = line[0];
            String courseName = line[1];
            int points = Integer.parseInt(line[2]);

            if (!courses.containsKey(courseName)) {
                courses.put(courseName, new TreeMap<>());
                courses.get(courseName).put(studentName, points);
            } else {
                if (!courses.get(courseName).containsKey(studentName)) {
                    courses.get(courseName).put(studentName, points);
                } else {
                    int max = Math.max(courses.get(courseName).get(studentName), points);
                    courses.get(courseName).put(studentName, max);
                }
            }
            inPut = scanner.nextLine();
        }

        for (Map.Entry<String, Map<String, Integer>> entry : courses.entrySet()) {
            for (Map.Entry<String, Integer> secondEntry : entry.getValue().entrySet()) {
                String name = secondEntry.getKey();
                int points = secondEntry.getValue();

                if (!students.containsKey(name)) {
                    students.put(name, points);
                } else {
                    int sum = students.get(name) + points;
                    students.put(name, sum);
                }
            }
        }

        courses
                .entrySet()
                .forEach(entry -> {
                    System.out.printf("%s: %d participants%n", entry.getKey(), entry.getValue().size());
                    final int[] count = {0};
                    entry.getValue().entrySet().stream().sorted((f, s) -> s.getValue().compareTo(f.getValue()))
                            .forEach(e -> {
                                count[0] += 1;
                                System.out.printf("%d. %s <::> %d%n", count[0], e.getKey(), e.getValue());


                            });
                });

        System.out.println("Individual standings:");
        final int[] count = {0};
        students
                .entrySet()
                .stream()
                .sorted((f, s) -> s.getValue().compareTo(f.getValue()))
                .forEach(entry -> {
                    count[0] += 1;
                    System.out.printf("%d. %s -> %d%n", count[0], entry.getKey(), entry.getValue());
                });

    }
}
