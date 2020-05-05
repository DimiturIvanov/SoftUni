/*
You are tasked to help plan the next Programing Fundamentals course by keeping track of the lessons, that are going
to be included in the course, as well as all the exercises for the lessons.
On the first input line you will receive the initial schedule of lessons and exercises that are going to be part of the
next course, separated by comma and space ", ". But before the course starts, there are some changes to be made.
Until you receive "course start" you will be given some commands to modify the course schedule. The possible
commands are:
Add:{lessonTitle} - add the lesson to the end of the schedule, if it does not exist
Insert:{lessonTitle}:{index} -insert the lesson to the given index, if it does not exist
Remove:{lessonTitle} -remove the lesson, if it exists
Swap:{lessonTitle}:{lessonTitle} -change the place of the two lessons, if they exist
Exercise:{lessonTitle} -add Exercise in the schedule right after the lesson index, if the lesson exists and there is no
exercise already, in the following format "{lessonTitle}-Exercise". If the lesson doesn`t exist, add the lesson in the
end of the course schedule, followed by the Exercise.
Each time you Swap or Remove a lesson, you should do the same with the Exercises, if there are any, which follow
the lessons.
Input
- On the first line -the initial schedule lessons -strings, separated by comma and space ", "
- Until "course start" you will receive commands in the format described above
Output
- Print the whole course schedule, each lesson on a new line with its number(index) in the schedule:
"{lesson index}.{lessonTitle}"
 */
package Fundamentals.Lect5_Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ex10_SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> schedule = (List<String>) Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("course start")) {
            String[] array = command.split(":");

            String lessonTitle = array[1];

            switch (array[0]) {
                case "Add":
                    if (!schedule.contains(lessonTitle)) {
                        schedule.add(lessonTitle);
                    }
                    break;
                case "Insert":
                    int insertIndex = Integer.parseInt(array[2]);
                    if (!schedule.contains(lessonTitle)) {
                        schedule.add(insertIndex, lessonTitle);
                    }
                    break;
                case "Remove":
                    if (schedule.contains(lessonTitle)) {
                        schedule.remove(lessonTitle);
                    }
                    if (schedule.contains(lessonTitle + "-Exercise")) {
                        schedule.remove(lessonTitle + "-Exercise");
                    }
                    break;
                case "Swap":
                    String swapLesson = array[2];
                    if (schedule.contains(lessonTitle) && schedule.contains(swapLesson)) {
                        int indexLesson = schedule.indexOf(lessonTitle);
                        int swapIndex = schedule.indexOf(swapLesson);
                        schedule.set(indexLesson, swapLesson);
                        schedule.set(swapIndex, lessonTitle);
                    }

                    if (schedule.contains(lessonTitle + "-Exercise")) {
                        schedule.remove(lessonTitle + "-Exercise");
                        int index = schedule.indexOf(lessonTitle);
                        schedule.add(index + 1, lessonTitle + "-Exercise");
                    }

                    if (schedule.contains(swapLesson + "-Exercise")) {
                        schedule.remove(swapLesson + "-Exercise");
                        int index = schedule.indexOf(swapLesson);
                        schedule.add(index + 1, swapLesson + "-Exercise");
                    }
                    break;
                case "Exercise":
                    if (schedule.contains(lessonTitle)) {
                        int index = schedule.indexOf(lessonTitle);
                        if (!schedule.contains(lessonTitle + "-Exercise")) {
                            schedule.add(index + 1, lessonTitle + "-Exercise");
                        }
                    } else {
                        schedule.add(lessonTitle);
                        schedule.add(lessonTitle + "-Exercise");
                    }
                    break;
                default:
                    break;
            }
            command = scanner.nextLine();
        }

        for (int i = 0; i < schedule.size(); i++) {
            System.out.printf("%d.%s%n", i + 1, schedule.get(i));
        }

    }
}
