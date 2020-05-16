/*
Judge statistics on the last Programing Fundamentals exam was not working correctly, so you have the task to take
all the submissions and analyze them properly. You should collect all the submission and print the final results and
statistics about each language that the participants submitted their solutions in.
You will be receiving lines in the following format: "{username}-{language}-{points}" until you receive "exam finished".
You should store each username and his submissions and points.You can receive a command to ban a user for cheating in
the following format: "{username}-banned". In that case, you should remove the user from the contest,
but preserve his submissions in the total count of submissions foreach language.
After receiving "exam finished", print each of the participants, ordered descending by their max points, then by
username, in the following format:
Results:
{username} | {points}
…
After that print each language, used in the exam, ordered descending by total submission count and then by
language name, in the following format:
Submissions:
{language} - {submissionsCount}
…

Input
Until you receive &quot;exam finished&quot;, you will be receiving participant submissions in the following format:
"{username}-{language}-{points}"
You can receive a ban command -> "{username}-banned"
The points of the participant will always be a valid integer in the range [0-100]

Output
-  Print the exam results for each participant, ordered descending by max points and then by username, in the
following format:
Results:
{username} | {points}
…
- After that print each language, ordered descending by total submissions and then by language name, in the
following format:
Submissions:
{language} - {submissionsCount}
 */
package Fundamentals.Lect7_AssociativeArrays;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex10_SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inPut = scanner.nextLine();

        Map<String, Integer> namesAndPoints = new LinkedHashMap<>();
        Map<String, Integer> languagesAndCounts = new LinkedHashMap<>();

        while (!inPut.equals("exam finished")) {
            String[] line = inPut.split("-");
            String name = line[0];
            String language = "";
            int points = 0;

            if (inPut.contains("banned")) {
                namesAndPoints.remove(name);
            } else {
                language = line[1];
                points = Integer.parseInt(line[2]);

                if (!namesAndPoints.containsKey(name)) {
                    namesAndPoints.put(name, points);
                } else {
                    int lastPoints = namesAndPoints.get(name);
                    int maxPoints = Math.max(lastPoints, points);
                    namesAndPoints.put(name, maxPoints);
                }

                if (!languagesAndCounts.containsKey(language)) {
                    languagesAndCounts.put(language, 1);
                } else {
                    languagesAndCounts.put(language, languagesAndCounts.get(language) + 1);
                }
            }
            inPut = scanner.nextLine();
        }

        System.out.println("Results: ");
        namesAndPoints
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue()
                        .reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .forEach(entry -> System.out.println(entry.getKey() + " | " + entry.getValue()));

        System.out.println("Submissions:");
        languagesAndCounts
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue()
                        .reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue()));

    }
}
