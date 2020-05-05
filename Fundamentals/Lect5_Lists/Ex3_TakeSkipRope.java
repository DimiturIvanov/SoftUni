/*
Write a program, which reads a string and skips through it, extracting a hidden message. The algorithm you have to
implement is as follows:
Let’s take the string “skipTest_String044170” as an example.
Take every digit from the string and store it somewhere. After that, remove all the digits from the string. After this
operation, you should have two lists of items: the numbers list and the non-numbers list:
- Numbers list: [0, 4, 4, 1, 7, 0]
- Non-numbers: [s, k, i, p, T, e, s, t, _, S, t, r, i, n, g]
After that, take every digit in the numbers list and split it up into a take list and a skip list, depending on whether
the digit is in an even or an odd index:
- Numbers list: [0, 4, 4, 1, 7, 0]
- Take list: [0, 4, 7]
- Skip list: [4, 1, 0]
Afterwards, iterate over both of the lists and skip {skipCount} characters from the non-numbers list, then take
{takeCount} characters and store it in a result string. Note that the skipped characters are summed up as they go.
The process would look like this on the aforementioned non-numbers list:
Example: "skipTest_String"
1. Take 0 characters  Taken: "", skip 4 characters  Skipped: "skip" Result: ""
2. Take 4 characters Taken: "Test", skip 1 characters  Skipped: "_" Result: "Test"
3. Take 7 characters Taken: "String", skip 0 characters  Skipped: "" Result: "TestString"
After that, just print the result string on the console.
Input
- The encrypted message as a string
Output
- The decrypted message as a string
Constraints
- The count of digits in the input string will always be even.
- The encrypted message will contain any printable ASCII character.
 */
package Fundamentals.Lect5_Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex3_TakeSkipRope {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        List<Integer> numberList = new ArrayList<>();
        List<Character> nonNumberList = new ArrayList<>();

        for (int i = 0; i < line.length(); i++) {
            if (Character.isDigit(line.charAt(i))) {
                int number = Integer.parseInt(line.charAt(i) + "");
                numberList.add(Integer.parseInt(line.charAt(i) + ""));
            } else {
                nonNumberList.add(line.charAt(i));
            }
        }

        //I create and fill in two list of numbers (even and odd index)
        List<Integer> takeList = new ArrayList<>();
        List<Integer> skipList = new ArrayList<>();
        for (int i = 0; i < numberList.size(); i++) {
            if (i % 2 == 0) {
                takeList.add(numberList.get(i));
            } else {
                skipList.add(numberList.get(i));
            }
        }

        //I start to loop and use the numbers of takeList and skipList, and determine which letters from nonNumberList to take
        String result = "";
        for (int i = 0; i < Math.max(takeList.size(), skipList.size()); i++) {
            int take = takeList.get(i);
            int skip = skipList.get(i);

            for (int j = 0; j < take; j++) {
                if (take > nonNumberList.size()) {
                    for (int k = 0; k < nonNumberList.size(); k++) {
                        result += nonNumberList.get(k);
                    }
                }
                if (take <= nonNumberList.size()) {
                    result += nonNumberList.get(j);
                } else {
                    break;
                }
            }

            for (int j = 0; j < skip + take; j++) {
                if (take > nonNumberList.size()) {
                    break;
                }
                nonNumberList.remove(nonNumberList.get(0));
            }
        }

        System.out.println(result);

    }
}
