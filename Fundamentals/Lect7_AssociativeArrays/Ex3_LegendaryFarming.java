/*
You`ve beaten all the content and the last thing left to accomplish is own a legendary item. However, it&#39;s a tedious
process and requires quite a bit of farming.
Anyway, you are not too pretentious - any legendary will do. The possible items are:
- Shadowmourne - requires 250 Shards
- Valanyr - requires 250 Fragments
- Dragonwrath - requires 250 Motes
Shards, Fragments and Motes are the key materials, all else is junk. You will be given lines of input, such as
"2 motes 3 ores 15 stones". Keep track of the key materials - the first that reaches the 250 mark wins the race. At
that point, print the corresponding legendary obtained. Then, print the remaining shards, fragments, motes,
ordered by quantity in descending order, then by name in ascending order, each on a new line. Finally, print the
collected junk items, in alphabetical order.
Input
Each line of input is in format {quantity} {material} {quantity} {material} … {quantity} {material}
Output
- On the first line, print the obtained item in format {Legendary item} obtained!
- On the next three lines, print the remaining key materials in descending order by quantity
o If two key materials have the same quantity, print them in alphabetical order
- On the final several lines, print the junk items in alphabetical order
o All materials are printed in format {material}: {quantity}
o All output should be lowercase, except the first letter of the legendary
 */
package Fundamentals.Lect7_AssociativeArrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Ex3_LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().split("\\s+");

        Map<String, Integer> keyMaterials = new HashMap<>();

        Map<String, Integer> junk = new TreeMap<>();

        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);

        boolean isTrue = true;

        while (isTrue) {
            for (int i = 0; i < line.length; i++) {
                if (i % 2 == 0) {
                    String materials = line[i + 1].toLowerCase();
                    int quantity = Integer.parseInt(line[i]);

                    if (materials.equals("shards") || materials.equals("fragments") || materials.equals("motes")) {
                        int count = keyMaterials.get(materials);
                        keyMaterials.put(materials, count + quantity);


                        if (keyMaterials.get(materials) >= 250) {
                            int difference = keyMaterials.get(materials) - 250;
                            keyMaterials.put(materials, difference);
                            if (materials.equals("shards")) {
                                System.out.println("Shadowmourne obtained!");
                            } else if (materials.equals("fragments")) {
                                System.out.println("Valanyr obtained!");
                            } else if (materials.equals("motes")) {
                                System.out.println("Dragonwrath obtained!");
                            }
                            isTrue = false;
                            break;
                        }
                    } else {
                        if (!junk.containsKey(materials)) {
                            junk.put(materials, quantity);
                        } else {
                            int count = junk.get(materials);
                            junk.put(materials, count + quantity);
                        }
                    }
                }
            }
            if (isTrue) {
                line = scanner.nextLine().split("\\s+");
            }
        }

        keyMaterials.entrySet()
                .stream()
                .sorted((f, s) -> {
                    int result = s.getValue().compareTo(f.getValue());

                    if (result == 0) {
                        result = f.getKey().compareTo(s.getKey());
                    }
                    return result;
                })
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        junk.forEach((key, value) -> System.out.println(key + ": " + value));

    }
}
