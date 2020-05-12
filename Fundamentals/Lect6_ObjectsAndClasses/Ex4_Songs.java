/*
Define a class Song, which holds the following information about songs: Type List, Name and Time.
On the first line you will receive the number of songs - N.
On the next N-lines you will be receiving data in the following format: "{typeList}_{name}_{time}".
On the last line you will receive "Type List" / "all". Print only the Names of the songs which are from that Type List /
All songs.
 */
package Fundamentals.Lect6_ObjectsAndClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex4_Songs {

    static class Song {
        String typeList;
        String name;
        String time;

        public Song(String typeList, String name, String time) {
            this.typeList = typeList;
            this.name = name;
            this.time = time;
        }

        public String getName() {
            return name;
        }

        public String getTypeList() {
            return typeList;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Song> songs = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String[] line = scanner.nextLine().split("_");
            String typeList = line[0];
            String name = line[1];
            String time = line[2];

            Song song = new Song(typeList, name, time);
            songs.add(song);
        }

        String command = scanner.nextLine();

        if (command.equals("all")) {
            for (Song song : songs) {
                System.out.println(song.getName());
            }
        } else {
            for (Song song : songs) {
                if (command.equals(song.getTypeList())) {
                    System.out.println(song.getName());
                }
            }
        }

    }
}
