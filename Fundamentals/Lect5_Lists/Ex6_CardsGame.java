/*
You will be given two hands of cards, which will be integer numbers. Assume that you have two players. You have to
find out the winning deck and respectively the winner.
You start from the beginning of both hands. Compare the cards from the first deck to the cards from the second
deck. The player, who has bigger card, takes both cards and puts them at the back of his hand - the second player`s
card is last, and the first person`s card (the winning one) is before it (second to last) and the player with smaller
card must remove the card from his deck. If both players` cards have the same values - no one wins, and the two
cards must be removed from the decks. The game is over when one of the decks is left without any cards. You have
to print the winner on the console and the sum of the left cards: "{First/Second} player wins! Sum: {sum}".
 */
package Fundamentals.Lect5_Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ex6_CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> firstPlayerCards = (ArrayList<Integer>) Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        ArrayList<Integer> secondPlayerCards = (ArrayList<Integer>) Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        for (int i = 0; i < firstPlayerCards.size() && i < secondPlayerCards.size(); ) {
            if (firstPlayerCards.get(i) > secondPlayerCards.get(i)) {
                firstPlayerCards.add(firstPlayerCards.get(i));
                firstPlayerCards.add(secondPlayerCards.get(i));
                firstPlayerCards.remove(i);
                secondPlayerCards.remove(i);
            } else if (secondPlayerCards.get(i) > firstPlayerCards.get(i)) {
                secondPlayerCards.add(secondPlayerCards.get(i));
                secondPlayerCards.add(firstPlayerCards.get(i));
                secondPlayerCards.remove(i);
                firstPlayerCards.remove(i);
            } else {
                firstPlayerCards.remove(i);
                secondPlayerCards.remove(i);
            }
        }

        if (firstPlayerCards.size() > secondPlayerCards.size()) {
            System.out.printf("First player wins! Sum: %d", sumOfAllIntegerInList(firstPlayerCards));
        } else if (secondPlayerCards.size() > firstPlayerCards.size()) {
            System.out.printf("Second player wins! Sum: %d", sumOfAllIntegerInList(secondPlayerCards));
        } else {
            System.out.println("There is no winner!");
        }
    }

    public static int sumOfAllIntegerInList(ArrayList<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }

}
