/*
Create a method that takes two strings as arguments and returns the sum of their character codes multiplied
(multiply str1[0] with str2[0] and add to the total sum). Then continue with the next two characters. If one of the
strings is longer than the other, add the remaining character codes to the total sum without multiplication.
 */
package Fundamentals.Lect8_TextProcessing;

import java.util.Scanner;

public class Ex2_CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().split(" +");

        int sum = sumOfcharacterCodesMultiplied(line);

        System.out.println(sum);

    }

    public static int sumOfcharacterCodesMultiplied(String[] line) {
        String first = line[0];
        String second = line[1];

        int sum = 0;

        if (first.length() != second.length()) {
            for (int i = 0; i < Math.min(first.length(), second.length()); i++) {
                int firstArraySymbol = (int) first.charAt(i);
                int secondArraySymbol = (int) second.charAt(i);

                int multiply = firstArraySymbol * secondArraySymbol;
                sum += multiply;
            }

            if (first.length() > second.length()) {
                for (int j = first.length() - 1; j > second.length() - 1; j--) {
                    int symbol = (int) first.charAt(j);
                    sum += symbol;
                }
            } else {
                for (int j = second.length() - 1; j > first.length() - 1; j--) {
                    int symbol = (int) second.charAt(j);
                    sum += symbol;
                }
            }

        } else {
            for (int i = 0; i < second.length(); i++) {
                int firstArraySymbol = (int) first.charAt(i);
                int secondArraySymbol = (int) second.charAt(i);

                int multiply = firstArraySymbol * secondArraySymbol;
                sum += multiply;
            }
        }
        return sum;
    }

}
