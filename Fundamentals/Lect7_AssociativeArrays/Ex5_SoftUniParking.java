/*
SoftUni just got a new parking lot. It`s so fancy, it even has online parking validation. Except, the online service
doesn`t work. It can only receive users` data, but doesn`t know what to do with it. Good thing you`re on the dev team
and know how to fix it, right?
Write a program, which validates parking for an online service. Users can register to park and unregister to leave.
The program receives 2 commands:

- "register {username} {licensePlateNumber}":
o The system only supports one car per user at the moment, so if a user tries to register another
license plate, using the same username, the system should print:
"ERROR: already registered with plate number {licensePlateNumber}"
o If the aforementioned checks pass successfully, the plate can be registered, so the
system should print:
"{username} registered {licensePlateNumber} successfully"

- "unregister {username}":
o If the user is not present in the database, the system should print:
"ERROR: user {username} not found"
o If the aforementioned check passes successfully, the system should print:
"{username} unregistered successfully"

After you execute all of the commands, print all the currently registered users and their license plates in the format:
- "{username} => {licensePlateNumber}"

Input
- First line: n - number of commands - integer
- Next n lines: commands in one of two possible formats:
o Register: "register {username} {licensePlateNumber}"
o Unregister: "unregister {username}"

The input will always be valid and you do not need to check it explicitly.
 */
package Fundamentals.Lect7_AssociativeArrays;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex5_SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        Map<String, String> nameAndNumberCar = new LinkedHashMap<>();

        for (int i = 1; i <= number; i++) {
            String[] line = scanner.nextLine().split("\\s+");

            String command = line[0];

            if (command.equals("register")) {
                String name = line[1];
                String carNumber = line[2];
                if (!nameAndNumberCar.containsKey(name)) {
                    nameAndNumberCar.put(name, carNumber);
                    System.out.printf("%s registered %s successfully%n", name, carNumber);
                } else {
                    System.out.printf("ERROR: already registered with plate number %s%n", carNumber);
                }

            } else if (command.equals("unregister")) {
                String name = line[1];
                if (!nameAndNumberCar.containsKey(name)) {
                    System.out.printf("ERROR: user %s not found%n", name);
                } else {
                    nameAndNumberCar.remove(name);
                    System.out.printf("%s unregistered successfully%n", name);
                }
            }
        }

//        for (var entry : nameAndNumberCar.entrySet()) {
//            System.out.printf("%s => %s%n", entry.getKey(), entry.getValue());
//        }

        nameAndNumberCar.forEach((key, value) -> System.out.println(key + " => " + value));

    }
}
