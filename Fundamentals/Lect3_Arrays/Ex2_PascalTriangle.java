/*
The triangle may be constructed in the following manner: In row 0 (the topmost row), there is a unique nonzero
entry 1. Each entry of each subsequent row is constructed by adding the number above and to the left with the
number above and to the right, treating blank entries as 0. For example, the initial number in the first (or any other)
row is 1 (the sum of 0 and 1), whereas the numbers 1 and 3 in the third row are added to produce the number 4 in
the fourth row.
Print each row elements separated with whitespace.
 */
package Fundamentals.Lect3_Arrays;

import java.util.Scanner;

public class Ex2_PascalTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = 1;
        System.out.print("Enter Number of Rows : ");
        int row = scanner.nextInt();

        for (int i = 0; i < row; i++) {
            number = 1;
            for (int j = 0; j <= i; j++) {
                System.out.print(number + " ");
                number = number * (i - j) / (j + 1);
            }
            System.out.println();

        }

    }
}
