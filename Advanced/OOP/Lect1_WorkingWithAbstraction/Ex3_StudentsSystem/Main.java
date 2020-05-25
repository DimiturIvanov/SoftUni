package Advanced.OOP.Lect1_WorkingWithAbstraction.Ex3_StudentsSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StudentSystem studentSystem = new StudentSystem();

        String line = scanner.nextLine();

        while (!line.equals("Exit")) {
            String[] inPut = line.split(" ");
            studentSystem.executeCommand(inPut);

            line = scanner.nextLine();
        }

    }
}
