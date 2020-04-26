/*
As a MOBA challenger player, Pesho has the bad habit to trash his PC when he loses a game and rage quits. His
gaming setup consists of headset, mouse, keyboard and display. You will receive Pesho`s lost games count.
Every second lost game, Pesho trashes his headset.
Every third lost game, Pesho trashes his mouse.
When Pesho trashes both his mouse and headset in the same lost game, he also trashes his keyboard.
Every second time, when he trashes his keyboard, he also trashes his display.
You will receive the price of each item in his gaming setup. Calculate his rage expenses for renewing his gaming
equipment.
Input
- On the first input line - lost games count – integer in the range [0, 1000].
- On the second line – headset price - floating point number in range [0, 1000].
- On the third line – mouse price - floating point number in range [0, 1000].
- On the fourth line – keyboard price - floating point number in range [0, 1000].
- On the fifth line – display price - floating point number in range [0, 1000].
Output
- As output you must print Pesho`s total expenses: "Rage expenses: {expenses} lv."
 */
package Fundamentals.Lect1_BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class Ex10_RageExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lostGame = Integer.parseInt(scanner.nextLine());
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());

        int countHeadset = 0;
        int countMouse = 0;
        int countKeyboard = 0;
        int countDisplay = 0;

        for (int i = 1; i <= lostGame; i++) {
            if (i % 2 == 0) {
                countHeadset++;
            }
            if (i % 3 == 0) {
                countMouse++;
            }
            if (i % 6 == 0) {
                countKeyboard++;
            }
            if (i % 12 == 0) {
                countDisplay++;
            }
        }

        double sum = countHeadset * headsetPrice + countMouse * mousePrice + countKeyboard * keyboardPrice
                + countDisplay * displayPrice;
        System.out.printf("Rage expenses: %.2f lv.", sum);

    }
}
