/*
You will be given some list of numbers and a string. For each element of the list you have to take the sum of its
digits and take the element corresponding to that index from the text. If the index is greater than the length of the
text, start counting from the beginning (so that you always have a valid index). After getting the element from the
text, you have to remove the character you have taken from it (so for the next index, the text will be with one
character less).
 */
package Fundamentals.Lect5_Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ex1_Messaging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> listOgInteger = (List<String>) Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        List<String> listOfString = (List<String>) Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        for (int i = 0; i < listOgInteger.size(); i++) {
            String text = listOgInteger.get(i);
            for (int j = 0; j < text.length(); j++) {
                int number = Integer.parseInt(text.charAt(i) + "");
                for (int k = 1; k <= number; k++) {
                }
            }
        }


    }
}
