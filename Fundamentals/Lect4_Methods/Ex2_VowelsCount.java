/*
Write a method that receives a single string and prints the count of the vowels. Use appropriate name for the
method.
 */
package Fundamentals.Lect4_Methods;

import java.util.Scanner;

public class Ex2_VowelsCount {
    static int vowelsCount(String line) {
        int count = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == 'e' || line.charAt(i) == 'E' || line.charAt(i) == 'y' || line.charAt(i) == 'Y'
                    || line.charAt(i) == 'u' || line.charAt(i) == 'U' || line.charAt(i) == 'i' || line.charAt(i) == 'I'
                    || line.charAt(i) == 'a' || line.charAt(i) == 'A' || line.charAt(i) == 'o'
                    || line.charAt(i) == 'O') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        System.out.println(vowelsCount(line));

    }
}
