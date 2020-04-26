/*
Yoda is starting his newly created Jedi academy. So, he asked master Ivan Cho to buy the needed equipment. The
number of items depends on how many students will sign up. The equipment for the Padawan contains lightsabers,
belts and robes.
You will be given the amount of money Ivan Cho has, the number of students and the prices of each item. You
have to help Ivan Cho calculate if the money he has is enough to buy all of the equipment, or how much more
money he needs.
Because the lightsabres sometimes brake, Ivan Cho should buy 10% more, rounded up to the next integer. Also,
every sixth belt is free.
Input
The input data should be read from the console. It will consist of exactly 5 lines:
- The amount of money Ivan Cho has – floating-point number in range [0.00…1,000.00]
- The count of students – integer in range [0…100]
- The price of lightsabers for a single sabre – floating-point number in range [0.00…100.00]
- The price of robes for a single robe – floating-point number in range [0.00…100.00]
- The price of belts for a single belt – floating-point number in range [0.00…100.00]
The input data will always be valid. There is no need to check it explicitly.
Output
If the calculated price of the equipment is less or equal to the money Ivan Cho has:
- "The money is enough - it would cost {the cost of the equipment}lv.";
If the calculated price of the equipment is more than the money Ivan Cho has:
- "Ivan Cho will need {neededMoney}lv more."
All prices must be rounded to two digits after the decimal point.
 */
package Fundamentals.Lect1_BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class Ex9_PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double money = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double priceLightSabers = Double.parseDouble(scanner.nextLine());
        double priceRobes = Double.parseDouble(scanner.nextLine());
        double priceBelts = Double.parseDouble(scanner.nextLine());

        int freeBelts = students / 6;

        double sum = priceLightSabers * (students + Math.ceil(students * 0.10)) + priceRobes * students
                + priceBelts * (students - freeBelts);

        if (sum <= money) {
            System.out.printf("The money is enough - it would cost %.2flv.", sum);
        } else {
            System.out.printf("Ivan Cho will need %.2flv more.", sum - money);
        }

    }
}
