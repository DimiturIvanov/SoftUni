/*
The Anonymous have created a cyber hypervirus which steals data from the CIA. You, as the lead security developer
in CIA, have been tasked to analyze the software of the virus and observe its actions on the data. The virus is known
for his innovative and unbelievably clever technique of merging and dividing data into partitions.
You will receive a single input line containing STRINGS separated by spaces.
The strings may contain any ASCII character except whitespace.
You will then begin receiving commands in one of the following formats:
- merge {startIndex} {endIndex}
- divide {index} {partitions}
Every time you receive the merge command, you must merge all elements from the startIndex till the endIndex. In
other words, you should concatenate them.
Example: {abc, def, ghi} -> merge 0 1 -> {abcdef, ghi}
If any of the given indexes is out of the array, you must take ONLY the range that is INSIDE the array and merge it.
Every time you receive the divide command, you must DIVIDE the element at the given index into several small
substrings with equal length. The count of the substrings should be equal to the given partitions.
Example: {abcdef, ghi, jkl} -> divide 0 3 -> {ab, cd, ef, ghi, jkl}
If the string CANNOT be exactly divided into the given partitions, make all partitions except the LAST with EQUAL
LENGTHS, and make the LAST one – the LONGEST.
Example: {abcd, efgh, ijkl} -> divide 0 3 -> {a, b, cd, efgh, ijkl}
The input ends when you receive the command "3:1". At that point you must print the resulting elements, joined
by a space.
Input
- The first input line will contain the array of data
- On the next several input lines you will receive commands in the format specified above
- The input ends when you receive the command "3:1"
Output
- As output you must print a single line containing the elements of the array, joined by a space.
Constrains
The strings in the array may contain any ASCII character except whitespace
- The startIndex and the endIndex will be in range [-1000, 1000]
- The endIndex will ALWAYS be GREATER than the startIndex
- The index in the divide command will ALWAYS be INSIDE the array
- The partitions will be in range [0, 100]
 */
package Fundamentals.Lect5_Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ex8_AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> inputLine = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!"3:1".equals(command)) {
            String[] splitTheCommand = command.split("\\s+");

            switch (splitTheCommand[0]) {
                case "merge":

                    int startIndex = Integer.parseInt(splitTheCommand[1]);
                    int endIndex = Integer.parseInt(splitTheCommand[2]);

                    if (startIndex < 0) {
                        startIndex = 0;
                    }
                    if (endIndex > inputLine.size() - 1) {
                        endIndex = inputLine.size() - 1;
                    }

                    for (int i = startIndex; i < endIndex; i++) {
                        String concatenate = inputLine.get(startIndex) + inputLine.get(startIndex + 1);
                        inputLine.set(startIndex, concatenate);
                        inputLine.remove(startIndex + 1);
                    }
                    break;
                case "divide":
                    int index = Integer.parseInt(splitTheCommand[1]);
                    int partitions = Integer.parseInt(splitTheCommand[2]);

                    if (index >= 0 && index < inputLine.size() && partitions >= 0 && partitions <= 100) {
                        String element = inputLine.get(index);
                        List<String> newList = new ArrayList<>();

                        if (element.length() % partitions == 0) {
                            int portionLength = element.length() / partitions;
                            int count = 0;
                            for (int i = 0; i < partitions; i++) {
                                String concat = "";
                                for (int j = 0; j < portionLength; j++) {
                                    char symbol = element.charAt(count);
                                    concat += symbol;
                                    count++;
                                }
                                newList.add(concat);
                            }
                        } else {
                            int portionLength = element.length() / partitions;
                            int count = 0;
                            for (int i = 0; i < partitions; i++) {
                                String concat = "";

                                if (i == partitions - 1) {
                                    for (int j = count; j < element.length(); j++) {
                                        char symbol = element.charAt(count);
                                        concat += symbol;
                                        count++;
                                    }
                                } else {
                                    for (int j = 0; j < portionLength; j++) {
                                        char symbol = element.charAt(count);
                                        concat += symbol;
                                        count++;
                                    }
                                }
                                newList.add(concat);
                            }
                        }
                        inputLine.remove(index);
                        inputLine.addAll(index, newList);
                    }
                    break;
            }
            command = scanner.nextLine();
        }

        System.out.println(inputLine.toString().replaceAll("[\\[\\],]", ""));

    }
}
