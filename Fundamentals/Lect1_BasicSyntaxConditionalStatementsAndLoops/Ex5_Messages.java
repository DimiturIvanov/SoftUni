/*
Write a program, which emulates typing an SMS, following this guide:
Following the guide, 2 becomes “a”, 22 becomes “b” and so on.
Like the phone.
 */
package Fundamentals.Lect1_BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class Ex5_Messages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        StringBuilder result = new StringBuilder();
        int start = 0;

        while (number > 0) {
            start = Integer.parseInt(scanner.nextLine());

            switch (start) {
                case 2:
                    result.append("a");
                    break;
                case 22:
                    result.append("b");
                    break;
                case 222:
                    result.append("c");
                    break;
                case 3:
                    result.append("d");
                    break;
                case 33:
                    result.append("e");
                    break;
                case 333:
                    result.append("f");
                    break;
                case 4:
                    result.append("g");
                    break;
                case 44:
                    result.append("h");
                    break;
                case 444:
                    result.append("i");
                    break;
                case 5:
                    result.append("j");
                    break;
                case 55:
                    result.append("k");
                    break;
                case 555:
                    result.append("l");
                    break;
                case 6:
                    result.append("m");
                    break;
                case 66:
                    result.append("n");
                    break;
                case 666:
                    result.append("o");
                    break;
                case 7:
                    result.append("p");
                    break;
                case 77:
                    result.append("q");
                    break;
                case 777:
                    result.append("r");
                    break;
                case 7777:
                    result.append("s");
                    break;
                case 8:
                    result.append("t");
                    break;
                case 88:
                    result.append("u");
                    break;
                case 888:
                    result.append("v");
                    break;
                case 9:
                    result.append("w");
                    break;
                case 99:
                    result.append("x");
                    break;
                case 999:
                    result.append("y");
                    break;
                case 9999:
                    result.append("z");
                    break;
                case 0:
                    result.append(" ");
                    break;
            }
            number--;
        }

        System.out.println(result);

    }
}
