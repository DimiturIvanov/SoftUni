/*
You are going to receive two lists with numbers. Create a result list which contains the numbers from both of the
lists. The first element should be from the first list, the second from the second list and so on. If the length of the
two lists are not equal, just add the remaining elements at the end of the list.
Hint
- Read the two lists
- Create a result list
- Start looping through them until you reach the end of the smallest one
- Finally add the remaining elements (if any) to the end of the list
 */
package Fundamentals.Lect5_Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ex3_MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> firstNumbers = (ArrayList<Integer>) Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        ArrayList<Integer> secondNumber = (ArrayList<Integer>) Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        ArrayList<Integer> resultNumbers = new ArrayList<>();
        int index = 0;

        for (int i = 0; i < Math.min(firstNumbers.size(), secondNumber.size()); i++) {
            resultNumbers.add(firstNumbers.get(i));
            resultNumbers.add(secondNumber.get(i));
            index = i;
        }

        if (firstNumbers.size() > secondNumber.size()) {
            for (int i = index + 1; i < firstNumbers.size(); i++) {
                resultNumbers.add(firstNumbers.get(i));
            }
        }

        if (secondNumber.size() > firstNumbers.size()) {
            for (int i = index + 1; i < secondNumber.size(); i++) {
                resultNumbers.add(secondNumber.get(i));
            }
        }

        for (int i = 0; i < resultNumbers.size(); i++) {
            System.out.print(resultNumbers.get(i) + " ");
        }

    }
}
