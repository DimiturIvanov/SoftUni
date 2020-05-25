/*
Create an enumeration type that has as its constants the fourteen ranks of a deck of playing cards (ACE, TWO,
THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING). Iterate over the values of the enumeration
type and print all ordinal values and names.
 */
package Advanced.OOP.Lect1_WorkingWithAbstraction.Ex2_CardRank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        System.out.printf("%s:%n", text);

        for (TypeCards card : TypeCards.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", card.ordinal(), card.name());
        }

    }
}
