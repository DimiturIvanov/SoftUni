package Advanced.OOP.Lect1_WorkingWithAbstraction.Ex4_HotelReservation;

import java.util.Scanner;

enum Season {
    Spring(2),
    Summer(4),
    Autumn(1),
    Winter(3);

    private int priceMultiplier;

    Season(int index) {
        this.priceMultiplier = index;
    }

    public int getPriceMultiplier() {
        return this.priceMultiplier;
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double price = scanner.nextDouble();
        int numberOfDays = scanner.nextInt();
        String seasonName = scanner.next();
        String discountType = scanner.next();

        Season season = Season.valueOf(seasonName);
        Discount discount = Discount.valueOf(discountType);

        System.out.printf("%.2f", getPriceFor(price, numberOfDays, season, discount));
    }

    private static double getPriceFor(double pricePerDay, int numberOfDays, Season season, Discount discount) {
        return pricePerDay * season.getPriceMultiplier() * numberOfDays * discount.getDiscount();
    }
}
