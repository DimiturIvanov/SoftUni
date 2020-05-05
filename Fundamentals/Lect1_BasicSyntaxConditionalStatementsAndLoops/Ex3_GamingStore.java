/*
Write a program, which helps you buy the games. The valid games are the following games in this table:
OutFall 4 $39.99
CS: OG $15.99
Zplinter Zell $19.99
Honored 2 $59.99
RoverWatch $29.99
RoverWatch Origins Edition $39.99
On the first line, you will receive your current balance – a floating-point number in the range [0.00…5000.00].
Until you receive the command “Game Time”, you have to keep buying games. When a game is bought, the user’s
balance decreases by the price of the game.
Additionally, the program should obey the following conditions:
- If a game the user is trying to buy is not present in the table above, print “Not Found” and read the next
line.
- If at any point, the user has $0 left, print “Out of money!” and end the program.
- Alternatively, if the user is trying to buy a game which they can’t afford, print “Too Expensive” and read
the next line.
When you receive “Game Time”, print the user’s remaining money and total spent on games, rounded to the 2 nd
decimal place.
 */
package Fundamentals.Lect1_BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class Ex3_GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double currentBalance = Double.parseDouble(scanner.nextLine());
        String command = scanner.nextLine();

        double price = 0;
        double spent = 0;
        boolean isTrue = false;
        while (!command.equals("Game Time")) {

            switch (command) {
                case "OutFall 4":
                    price = 39.99;
                    isTrue = true;
                    break;
                case "CS: OG":
                    price = 15.99;
                    isTrue = true;
                    break;
                case "Zplinter Zell":
                    price = 19.99;
                    isTrue = true;
                    break;
                case "Honored 2":
                    price = 59.99;
                    isTrue = true;
                    break;
                case "RoverWatch":
                    price = 29.99;
                    isTrue = true;
                    break;
                case "RoverWatch Origins Edition":
                    price = 39.99;
                    isTrue = true;
                    break;
                default:
                    isTrue = false;
                    System.out.println("Not Found");
                    price = 0;
            }
            spent += price;

            if (currentBalance - spent < 0) {
                isTrue = false;
                System.out.println("Too Expensive");
                spent -= price;
            }

            if (isTrue == true) {
                System.out.printf("Bought %s%n", command);
            }

            if (currentBalance - spent == 0) {
                System.out.println("Out of money!");
                break;
            }

            command = scanner.nextLine();
        }

        if (currentBalance - spent != 0) {
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", spent, currentBalance - spent);
        }

    }
}