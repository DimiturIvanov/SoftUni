package Advanced.OOP.Lect1_WorkingWithAbstraction.Demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        List<Person> people = new ArrayList<>();

        for (int i = 1; i <= number; i++) {
         String name = scanner.next();
         int age = scanner.nextInt();

         Person person = new Person(name, age);
         people.add(person);
        }

        List<String> names = new ArrayList<>();
        School school = new School(names);

        for (Person person: people) {
            if(school.over18Years(person.getAge())){
                names.add(person.name);
            }
        }

        System.out.println(names);

    }
}
