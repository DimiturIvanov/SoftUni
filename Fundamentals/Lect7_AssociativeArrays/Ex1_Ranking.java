/*
Here comes the final and the most interesting part - the Final ranking of the candidate-interns. The final ranking is
determined by the points of the interview tasks and from the exams in SoftUni. Here is your final task. You will
receive some lines of input in the format "{contest}:{password for contest}" until you receive "end of contests".
Save that data because you will need it later. After that you will receive other type of inputs in format
"{contest}=>{password}=>{username}=>{points}" until you receive "end of submissions". Here is what you need to do:
- Check if the contest is valid (if you received it in the first type of input)
- Check if the password is correct for the given contest
- Save the user with the contest they take part in (a user can take part in many contests) and the points the
user has in the given contest. If you receive the same contest and the same user, update the points only if
the new ones are more than the older ones.

At the end you have to print the info for the user with the most points in the format "Best candidate is {user}
with total {total points} points.". After that print all students ordered by their names. For each user print each
contest with the points in descending order. See the examples.

Input
Strings in format "{contest}:{password for contest}" until the "end of contests" command. There will be no
case with two equal contests
- Strings in format "{contest}=>{password}=>{username}=>{points}" until the "end of submissions" command
- There will be no case with 2 or more users with same total points!

Output
- On the first line print the best user in format
"Best candidate is {user} with total {total points} points.".
- Then print all students ordered as mentioned above in format:
{user1 name}
# {contest1} -> {points}
# {contest2} -> {points}

Constraints
- The strings may contain any ASCII character except from (:, =, >)
- The numbers will be in range [0 - 10000]
- Second input is always valid

 */
package Fundamentals.Lect7_AssociativeArrays;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Ex1_Ranking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstInPut = scanner.nextLine();

        Map<String, String> contestAndPassword = new LinkedHashMap<>();

        while (!firstInPut.equals("end of contests")) {
            String[] lineFirstInput = firstInPut.split(":");
            String nameContest = lineFirstInput[0];
            String passwordContest = lineFirstInput[1];

            if (!contestAndPassword.containsKey(nameContest)) {
                contestAndPassword.put(nameContest, passwordContest);
            }
            firstInPut = scanner.nextLine();
        }

        String secondInPut = scanner.nextLine();

        Map<String, Map<String, Integer>> users = new TreeMap<>();

        while (!secondInPut.equals("end of submissions")) {
            String[] lineSecondInPut = secondInPut.split("=>");
            String nameContest = lineSecondInPut[0];
            String passwordContest = lineSecondInPut[1];
            String namePerson = lineSecondInPut[2];
            int pointsPerson = Integer.parseInt(lineSecondInPut[3]);

            if (contestAndPassword.containsKey(nameContest)) {
                if (contestAndPassword.get(nameContest).equals(passwordContest)) {

                    LinkedHashMap<String, Integer> course = new LinkedHashMap<>();
                    course.put(nameContest, pointsPerson);

                    if (!users.containsKey(namePerson)) {
                        users.put(namePerson, course);
                    } else {
                        if (!users.get(namePerson).containsKey(nameContest)) {
                            users.get(namePerson).put(nameContest, pointsPerson);
                        } else {
                            users.get(namePerson).put(nameContest, Math.max(pointsPerson, users.get(namePerson).get(nameContest)));
                        }
                    }
                }
            }
            secondInPut = scanner.nextLine();
        }

        int totalSum = 0;
        for (Map.Entry<String, Map<String, Integer>> user : users.entrySet()) {
            int sum = user.getValue().values().stream().mapToInt(i -> i).sum();
            if (sum > totalSum) {
                totalSum = sum;
            }
        }

        for (Map.Entry<String, Map<String, Integer>> user : users.entrySet()) {
            if (user.getValue().values().stream().mapToInt(i -> i).sum() == totalSum) {
                System.out.printf("Best candidate is %s with total %d points.%n", user.getKey(), totalSum);
            }
        }

        System.out.println("Ranking:");
        users.forEach((key, value) -> {
            System.out.printf("%s%n", key);
            value.entrySet().stream().
                    sorted((f, s) -> s.getValue() - f.getValue()).
                    forEach(i -> System.out.printf("#  %s -> %d%n", i.getKey(), i.getValue()));
        });

    }
}
