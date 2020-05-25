package Advanced.OOP.Lect1_WorkingWithAbstraction.Ex2_PointInRectangle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rectangleInPut = scanner.nextLine().split(" ");
        int[] coordinates = new int[rectangleInPut.length];

        for (int i = 0; i < coordinates.length; i++) {
            coordinates[i] = Integer.parseInt(rectangleInPut[i]);
        }

        Rectangle rectangle = new Rectangle(coordinates[0], coordinates[1], coordinates[2], coordinates[3]);

        int numberOfPoints = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfPoints; i++) {
            int pointX = scanner.nextInt();
            int pointY = scanner.nextInt();

            Point check = new Point(pointX, pointY);

            System.out.println(rectangle.contains(check));
        }

    }
}
