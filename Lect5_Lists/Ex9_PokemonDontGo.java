/*
Ely likes to play Pokemon Go a lot. But Pokemon Go bankrupted… So, the developers made Pokemon Don&#39;t Go out of
depression. And so, Ely now plays Pokemon Don`t Go. In Pokemon Don`t Go, when you walk to a certain pokemon,
those closer to you, naturally get further, and those further from you, get closer.
You will receive a sequence of integers, separated by spaces - the distances to the pokemons.
Then you will begin receiving integers, which will correspond to indexes in that sequence.
When you receive an index, you must remove the element at that index from the sequence (as if you`ve captured
the pokemon).
- You must INCREASE the value of all elements in the sequence which are LESS or EQUAL to the removed
element, with the value of the removed element.
- You must DECREASE the value of all elements in the sequence which are GREATER than the removed
element, with the value of the removed element.
If the given index is LESS than 0, remove the first element of the sequence, and COPY the last element to its place.
If the given index is GREATER than the last index of the sequence, remove the last element from the sequence, and
COPY the first element to its place.
The increasing and decreasing of elements should be done in these cases, also. The element, whose value you
should use, is the REMOVED element.
The program ends when the sequence has no elements (there are no pokemons left for Ely to catch).
Input
- On the first line of input you will receive a sequence of integers, separated by spaces
- On the next several lines you will receive integers – the indexes
Output
- When the program ends, you must print on the console, the summed up value of all REMOVED elements
Constrains
- The input data will consist ONLY of valid integers in the range [-2.147.483.648, 2.147.483.647]
 */
package Fundamentals.Lect5_Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ex9_PokemonDontGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> sequenceIntegers = (ArrayList<Integer>) Arrays.stream(scanner.nextLine()
                .split("\\s+")).map(Integer::parseInt)
                .collect(Collectors.toList());

        int sum = 0;

        while (!sequenceIntegers.isEmpty()) {
            int ind = Integer.parseInt(scanner.nextLine());

            if (ind >= 0 && ind <= sequenceIntegers.size() - 1) {
                int element = sequenceIntegers.get(ind);
                sum += element;
                sequenceIntegers.remove(ind);
                changeListContent(sequenceIntegers, element);
            } else if (ind < 0) {
                int element = sequenceIntegers.get(0);
                sum += element;
                sequenceIntegers.set(0, sequenceIntegers.get(sequenceIntegers.size() - 1));
                changeListContent(sequenceIntegers, element);
            } else {
                int element = sequenceIntegers.get(sequenceIntegers.size() - 1);
                sum += element;
                sequenceIntegers.set((sequenceIntegers.size() - 1), sequenceIntegers.get(0));
                changeListContent(sequenceIntegers, element);
            }
        }
        System.out.println(sum);
    }

    static void changeListContent(ArrayList<Integer> sequenceIntegers, int element) {
        for (int i = 0; i < sequenceIntegers.size(); i++) {
            if (sequenceIntegers.get(i) <= element) {
                sequenceIntegers.set(i, sequenceIntegers.get(i) + element);
            } else {
                sequenceIntegers.set(i, sequenceIntegers.get(i) - element);
            }
        }
    }

}
