/*
Write a program, which keeps information about courses. Each course has a name and registered students.
You will receive course name and student name, until you receive the command "end". Check if such course
already exists, and if not - add the course. Register the user into the course. When you do receive the command
"end", print the courses with their names and total registered users, ordered by the count of registered users in
descending order. For each contest print registered users ordered by name in ascending order.
Input
- Until you receive "end", the input come in the format: "{courseName} : {studentName}"
- The product data is always delimited by " : "
Output
- Print information about each course, following the format:
"{courseName}: {registeredStudents}"
- Print information about each student, following the format:
"-- {studentName}"
 */
package Fundamentals.Lect7_AssociativeArrays;

import java.util.*;

public class Ex6_Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, ArrayList<String>> courseAndStudent = new LinkedHashMap<>();

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            String[] line = command.split(" : ");

            String coursName = line[0];
            String studentName = line[1];

            if (!courseAndStudent.containsKey(coursName)) {
                ArrayList<String> students = new ArrayList<>();
                students.add(studentName);
                courseAndStudent.put(coursName, students);
            } else {
                courseAndStudent.get(coursName).add(studentName);
                Collections.sort(courseAndStudent.get(coursName));
            }
            command = scanner.nextLine();
        }

        courseAndStudent.entrySet()
                .stream()
                .sorted((f, s) -> Integer.compare(s.getValue().size(), f.getValue().size()))
                .forEach(entry -> {
                    System.out.printf("%s: %d%n", entry.getKey(), entry.getValue().size());
                    for (int i = 0; i < entry.getValue().size(); i++) {
                        System.out.println("-- " + entry.getValue().get(i));
                    }
                });

    }
}
