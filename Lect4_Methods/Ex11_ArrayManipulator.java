/*
Trifon has finally become a junior developer and has received his first task. It`s about manipulating an array of
integers. He is not quite happy about it, since he hates manipulating arrays. They are going to pay him a lot of
money, though, and he is willing to give somebody half of it if to help him do his job. You, on the other hand, love
arrays (and money) so you decide to try your luck.
The array may be manipulated by one of the following commands:
- exchange {index} – splits the array after the given index and exchanges the places of the two resulting
subarrays. E.g. [1, 2, 3, 4, 5] -> exchange 2 -> result: [4, 5, 1, 2, 3]
o If the index is outside the boundaries of the array, print "Invalid index".
- max even/odd– returns the INDEX of the max even/odd element -> [1, 4, 8, 2, 3] -> max odd -> print 4
- min even/odd – returns the INDEX of the min even/odd element -> [1, 4, 8, 2, 3] -> min even -> print 3
o If there are two or more equal min/max elements, return the index of the rightmost one.
o If a min/max even/odd element cannot be found, print "No matches".
- first {count} even/odd– returns the first {count} elements -> [1, 8, 2, 3] -> first 2 even -> print [8, 2]
- last {count} even/odd – returns the last {count} elements -> [1, 8, 2, 3] -> last 2 odd -> print [1, 3]
o If the count is greater than the array length, print "Invalid count".
o If there are not enough elements to satisfy the count, print as many as you can. If there are zero
even/odd elements, print an empty array "[]".
- end – stop taking input and print the final state of the array.
Input
The input data should be read from the console.
- On the first line, the initial array is received as a line of integers, separated by a single space.
- On the next lines, until the command "end" is received, you will receive the array manipulation commands.
- The input data will always be valid and in the format described. There is no need to check it explicitly.
Output
- The output should be printed on the console.
- On a separate line, print the output of the corresponding command
- On the last line, print the final array in square brackets with its elements separated by a comma and a space
- See the examples below to get a better understanding of your task
Constrains
- The number of input lines will be in the range [2 … 50].
- The array elements will be integers in the range [0 … 1000].
- The number of elements will be in the range [1 ... 50]
- The split index will be an integer in the range [-2 31 … 2 31 – 1]
- first/last count will be an integer in the range [1 … 2 31 – 1]
- There will not be redundant whitespace anywhere in the input
 */
package Fundamentals.Lect4_Methods;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ex11_ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String[] input = scanner.nextLine().split(" ");

        while (!input[0].equals("end")) {

            switch (input[0]) {
                case "exchange":
                    int index = Integer.parseInt(input[1]);

                    if (0 <= index && index < list.size()) {
                        Collections.rotate(list, -(index + 1));
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;

                case "max":
                case "min":
                    List<Integer> sub = getNums(list, input[1]);

                    if (!sub.isEmpty()) {

                        if (input[0].equals("max")) {
                            System.out.println(list.lastIndexOf(Collections.max(sub)));
                        } else {
                            System.out.println(list.lastIndexOf(Collections.min(sub)));
                        }

                    } else {
                        System.out.println("No matches");
                    }
                    break;

                case "first":
                case "last":
                    int count = Integer.parseInt(input[1]);

                    if (count <= list.size()) {
                        sub = getNums(list, input[2]);

                        if (input[0].equals("first")) {
                            System.out.println(sub.stream().limit(count).collect(Collectors.toList()));
                        } else {
                            printLast(sub, count);
                        }

                    } else {
                        System.out.println("Invalid count");
                    }
                    break;
            }

            input = scanner.nextLine().split(" ");
        }

        System.out.println(list);

    }

    private static void printLast(List<Integer> sub, int count) {
        Collections.reverse(sub);
        sub = sub.stream().limit(count).collect(Collectors.toList());
        Collections.reverse(sub);
        System.out.println(sub);
    }

    private static List<Integer> getNums(List<Integer> list, String s) {
        int num;
        if (s.equals("even")) {
            num = 0;
        } else {
            num = 1;
        }
        return list.stream().filter(n -> n % 2 == num).collect(Collectors.toList());
    }
}