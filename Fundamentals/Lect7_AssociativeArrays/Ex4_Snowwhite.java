package Fundamentals.Lect7_AssociativeArrays;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex4_Snowwhite {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, LinkedHashMap<String, Integer>> dwarfs = new LinkedHashMap<>();

        String inPut = scanner.nextLine();

        while (!"Once upon a time".equals(inPut)) {

            String[] line = inPut.split(" <:> ");

            String name = line[0];
            String color = line[1];
            int physics = Integer.parseInt(line[2]);

            dwarfs.putIfAbsent(color, new LinkedHashMap<>());
            dwarfs.get(color).putIfAbsent(name, physics);

            if (dwarfs.get(color).get(name) < physics) {
                dwarfs.get(color).put(name, physics);
            }

            inPut = scanner.nextLine();
        }


        Map<String, Integer> print = new LinkedHashMap<>();

        for(Map.Entry<String, LinkedHashMap<String, Integer>> entry : dwarfs.entrySet()) {
            for(Map.Entry<String, Integer> secondEntry : entry.getValue().entrySet()) {
                print.put(entry.getKey() + " " + secondEntry.getKey() + " " + entry.getValue().size(), secondEntry.getValue());
            }
        }

        print
                .entrySet()
                .stream()
                .sorted((pair2, pair1) -> {
            int sort = Integer.compare(pair1.getValue(), pair2.getValue());
            if (sort == 0) {
                String[] sort1 = pair1.getKey().split(" ");
                String[] sort2 = pair2.getKey().split(" ");
                sort = sort1[2].compareTo(sort2[2]);
            }
            return sort;
        }).forEach(pair -> {
            String[] printing = pair.getKey().split(" ");
            System.out.printf("(%s) %s <-> %d%n", printing[0], printing[1], pair.getValue());
        });

    }
}
