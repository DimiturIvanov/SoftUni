/*
Read four integer numbers.
Add first to the second, divide (integer) the sum by the third number and multiply the result by the fourth number.
Print the result.
- First number will be in the range [-2,147,483,648… 2,147,483,647]
- Second number will be in the range [-2,147,483,648… 2,147,483,647]
- Third number will be in the range [-2,147,483,648… 2,147,483,647]
- Fourth number will be in the range [-2,147,483,648… 2,147,483,647]
 */
package Fundamentals.Lect2_DataTypesAndVariables;

import java.util.Scanner;

public class Ex1_IntegerOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());
        int d = Integer.parseInt(scanner.nextLine());

        System.out.println(((a + b) / c) * d);

    }
}
