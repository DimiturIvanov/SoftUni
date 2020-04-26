/*
You are given a working code that finds the volume of a pyramid. However, you should consider that the
variables exceed their optimum span and have improper naming. Also, search for variables that have
multiple purpose.
 */
package Fundamentals.Lect2_DataTypesAndVariables;

import java.util.Scanner;

public class Ex11_RefactorVolumeOfPyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double length, width, height = 0;
        System.out.print("Length: ");
        length = Double.parseDouble(scanner.nextLine());
        System.out.print("Width: ");
        width = Double.parseDouble(scanner.nextLine());
        System.out.print("Height: ");
        height = Double.parseDouble(scanner.nextLine());
        double V = (length * width * height) / 3;
        System.out.printf("Pyramid Volume: %.2f", V);

    }
}
