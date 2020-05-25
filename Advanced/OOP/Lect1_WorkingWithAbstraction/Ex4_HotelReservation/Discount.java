package Advanced.OOP.Lect1_WorkingWithAbstraction.Ex4_HotelReservation;

public enum Discount {
    None(0),
    SecondVisit(10),
    VIP(20);

    private final int discountPercent;

    Discount(int percents) {
        this.discountPercent = percents;
    }

    public double getDiscount(){
        return (100 - this.discountPercent) / 100.0;
    }

}
