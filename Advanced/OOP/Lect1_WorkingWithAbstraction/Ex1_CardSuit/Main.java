/*
Create an enumeration type that has as its constants the four suits of a deck of playing cards (CLUBS, DIAMONDS,
HEARTS, SPADES). Iterate over the values of the enumeration type and print all ordinal values and names.
 */
package Advanced.OOP.Lect1_WorkingWithAbstraction.Ex1_CardSuit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        System.out.println(text + ":");

        for (TypeCards type : TypeCards.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", type.ordinal(), type.toString());
        }

    }
}
