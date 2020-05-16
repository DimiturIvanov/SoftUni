/*
The force users are struggling to remember which side are the different forceUsers from, because they switch them
too often. So you are tasked to create a web application to manage their profiles.
You should store information for every unique forceUser, registered in the application.
You will receive several input lines in one of the following formats:
{forceSide} | {forceUser}
{forceUser} -> {forceSide}
The forceUser and forceSide are strings, containing any character.
If you receive forceSide | forceUser you should check if such forceUser already exists, and if not - add him/her to
the corresponding side.
If you receive a forceUser -> forceSide you should check if there is such forceUser already and if so, change his/her
side. If there is no such forceUser, add him/her to the corresponding forceSide, treating the command as new
registered forceUser.
Then you should print on the console: "{forceUser} joins the {forceSide} side!"
You should end your program when you receive the command "Lumpawaroo". At that point you should print each
force side, ordered descending by forceUsers count, than ordered by name. For each side print the forceUsers,
ordered by name.
In case there are no forceUsers in a side, you shouldn`t print the side information.
Input
- The input comes in the form of commands in one of the formats specified above
- The input ends when you receive the command "Lumpawaroo"
Output
- As output for each forceSide, ordered descending by forceUsers count, then by name, you must print all
the forceUsers, ordered by name alphabetically
- The output format is:
Side: {forceSide}, Members: {forceUsers.Count}
! {forceUser}
! {forceUser}
! {forceUser}
- In case there are NO forceUsers, don`t print this side
 */
package Fundamentals.Lect7_AssociativeArrays;

import java.util.*;
import java.util.stream.Collectors;

public class Ex9_ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> sides = new TreeMap<>();

        String inPut = scanner.nextLine();

        while (!inPut.equals("Lumpawaroo")) {

            String forceSide = "";
            String forceUser = "";

            if (inPut.contains("|")) {
                int index = inPut.lastIndexOf("|");
                forceUser = inPut.substring(index + 2);
                forceSide = inPut.substring(0, index - 1);


                boolean isTrue = false;

                for (Map.Entry<String, List<String>> current : sides.entrySet()) {
                    if (current.getValue().contains(forceUser)) {
                        isTrue = true;
                        break;
                    }
                }

                if (!isTrue) {
                    if (!sides.containsKey(forceSide)) {
                        sides.put(forceSide, new ArrayList<>());
                        sides.get(forceSide).add(forceUser);
                    } else {
                        sides.get(forceSide).add(forceUser);
                        Collections.sort(sides.get(forceSide));
                    }
                }

            } else if (inPut.contains("->")) {

                int index = inPut.lastIndexOf("->");
                forceUser = inPut.substring(0, index - 1);
                forceSide = inPut.substring(index + 3);

                for (Map.Entry<String, List<String>> entry : sides.entrySet()) {
                    if (entry.getValue().contains(forceUser)) {
                        entry.getValue().remove(forceUser);
                        break;
                    }
                }

                if (!sides.containsKey(forceSide)) {
                    sides.put(forceSide, new ArrayList<>());
                    sides.get(forceSide).add(forceUser);
                    System.out.printf("%s joins the %s side!%n", forceUser, forceSide);
                } else if (sides.containsKey(forceSide) && !sides.get(forceSide).contains(forceUser)) {
                    sides.get(forceSide).add(forceUser);
                    System.out.printf("%s joins the %s side!%n", forceUser, forceSide);
                }

            }
            inPut = scanner.nextLine();
        }

        sides
                .entrySet()
                .stream()
                .filter(users -> users.getValue().size() > 0)
                .sorted(Map.Entry.<String, List<String>>comparingByValue(Comparator.comparing(List::size)).reversed())
                .forEach(s -> {
                    System.out.printf("Side: %s, Members: %d%n", s.getKey(), s.getValue().size());

                    s.getValue()
                            .stream()
                            .sorted(String::compareTo)
                            .forEach(person -> System.out.printf("! %s%n", person));
                });

    }
}
