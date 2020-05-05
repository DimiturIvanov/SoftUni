/*
You are given the coordinates of two points on a Cartesian coordinate system - X1, Y1, X2 and Y2. Create a method
that prints the point that is closest to the center of the coordinate system (0, 0) in the format (X, Y). If the points are
on a same distance from the center, print only the first one.
 */
package Fundamentals.Lect4_Methods;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Ex2_CenterPoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();

        closestPoint(x1, y1, x2, y2);

    }

    public static void closestPoint(double x1, double y1, double x2, double y2) {
        double first = Math.sqrt(Math.pow(y1, 2) + Math.pow(x1, 2));
        double second = Math.sqrt(Math.pow(y2, 2) + Math.pow(x2, 2));

        DecimalFormat df = new DecimalFormat("#.##");

        if (first < second) {
            System.out.print("(" + df.format(x1) + ", " + df.format(y1) + ")");
        } else {
            System.out.print("(" + df.format(x2) + ", " + df.format(y2) + ")");
        }

    }
}
