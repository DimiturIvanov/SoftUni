package Advanced.OOP.Lect1_WorkingWithAbstraction.Ex3_CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rank = scanner.nextLine();
        String suit = scanner.nextLine();

        RankPower rankPower = RankPower.valueOf(rank);
        SuitPower suitPower = SuitPower.valueOf(suit);


        Card card = new Card(rankPower, suitPower);

        System.out.println(card.toString());

    }
}
