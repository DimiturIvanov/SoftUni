package Advanced.OOP.Lect1_WorkingWithAbstraction.Ex5_JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        fillMatrix(rows, cols, matrix);

        String command = scanner.nextLine();
        long starPower = 0;
        while (!command.equals("Let the Force be with you")) {
            int[] playerPosition = Arrays
                    .stream(command.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int[] evil = Arrays
                    .stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int enemyRow = evil[0];
            int enemyCol = evil[1];

            while (enemyRow >= 0 && enemyCol >= 0) {
                if (enemyRow < matrix.length && enemyCol < matrix[0].length) {
                    matrix[enemyRow][enemyCol] = 0;
                }
                enemyRow--;
                enemyCol--;
            }

            int playerRow = playerPosition[0];
            int playerCol = playerPosition[1];

            while (playerRow >= 0 && playerCol < matrix[1].length) {
                if (playerRow < matrix.length && playerCol >= 0 && playerCol < matrix[0].length) {
                    starPower += matrix[playerRow][playerCol];
                }

                playerCol++;
                playerRow--;
            }

            command = scanner.nextLine();
        }

        System.out.println(starPower);

    }

    private static void fillMatrix(int rows, int cols, int[][] matrix) {
        int value = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = value++;
            }
        }
    }

}
