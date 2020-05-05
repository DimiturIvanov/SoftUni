/*
Write a program, which sums the ASCII codes of n characters.
Print the sum on the console.
Input
- On the first line, you will receive n – the number of lines, which will follow
- On the next n lines – you will receive letters from the Latin alphabet
Output
- Print the total sum in the following format:
- The sum equals: {totalSum}
Constrains
- n will be in the interval [1…20].
- The characters will always be either upper or lower-case letters from the English alphabet
- You will always receive one letter per line
 */
package Fundamentals.Lect2_DataTypesAndVariables;

import java.util.Scanner;

public class Ex4_SumOfChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            char symbol = scanner.nextLine().charAt(0);
            sum += symbol;
        }

        System.out.printf("The sum equals: %d", sum);

    }
}
