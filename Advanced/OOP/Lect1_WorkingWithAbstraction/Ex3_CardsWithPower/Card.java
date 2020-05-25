package Advanced.OOP.Lect1_WorkingWithAbstraction.Ex3_CardsWithPower;

public class Card {
    RankPower rank;
    SuitPower suit;

    public Card(RankPower rank, SuitPower suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public RankPower getRank() {
        return rank;
    }

    public SuitPower getSuit() {
        return suit;
    }

    private int calculate() {
        return this.rank.getRankPower() + this.suit.getSuitPower();
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d", this.rank.toString(), this.suit.toString(), this.calculate());
    }
}

