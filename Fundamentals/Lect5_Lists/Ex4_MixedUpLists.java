/*
Write a program that mixes up two lists by some rules. You will receive two lines of input, each one being a list of
numbers. The rules for mixing are:
- Start from the beginning of the first list and from the ending of the second
- Add element from the first and element from the second
- At the end there will always be a list in which there are 2 elements remaining
- These elements will be the range of the elements you need to print
- Loop through the result list and take only the elements that fulfill the condition
- Print the elements ordered in ascending order and separated by a space
 */
package Fundamentals.Lect5_Lists;
import java.util.*;
import java.util.stream.Collectors;

public class Ex4_MixedUpLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstList = (List<Integer>) Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> secondList = (List<Integer>) Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> mixedList = null;

        int rangeFirst = 0;
        int rangeSecond = 0;

        if (firstList.size() > secondList.size()) {
            if (firstList.get(firstList.size() - 1) > firstList.get(firstList.size() - 2)) {
                rangeFirst = firstList.get(firstList.size() - 2);
                rangeSecond = firstList.get(firstList.size() - 1);
                firstList.remove(firstList.size() - 1);
                firstList.remove(firstList.size() - 1);
            } else if (firstList.get(firstList.size() - 1) < firstList.get(firstList.size() - 2)) {
                rangeFirst = firstList.get(firstList.size() - 1);
                rangeSecond = firstList.get(firstList.size() - 2);
                firstList.remove(firstList.size() - 1);
                firstList.remove(firstList.size() - 1);
            }
            mixedList = new ArrayList<>(firstList);

            int index = 1;
            for (int i = secondList.size() - 1; i >= 0; i--) {
                mixedList.add(index, secondList.get(i));
                index += 2;
            }

        } else if (secondList.size() > firstList.size()) {
            if (secondList.get(0) > secondList.get(1)) {
                rangeFirst = secondList.get(1);
                rangeSecond = secondList.get(0);
                secondList.remove(0);
                secondList.remove(0);
            } else if (secondList.get(0) < secondList.get(1)) {
                rangeFirst = secondList.get(0);
                rangeSecond = secondList.get(1);
                secondList.remove(0);
                secondList.remove(0);
            }
            mixedList = new ArrayList<>(secondList);

            int index = 1;
            for (int i = firstList.size() - 1; i >= 0; i--) {
                mixedList.add(index, firstList.get(i));
                index += 2;
            }
        }

        for (int i = 0; i < mixedList.size(); i++) {
            if (mixedList.get(i) <= rangeFirst || rangeSecond <= mixedList.get(i)) {
                mixedList.remove(i);
                i--;
            }
        }

        Collections.sort(mixedList);
        System.out.println(mixedList.toString().replaceAll("[\\[\\],]", ""));

    }
}
