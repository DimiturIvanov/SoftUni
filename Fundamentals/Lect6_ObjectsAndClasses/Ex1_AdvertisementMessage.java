/*
Write a program that generates random fake advertisement message to extol some product. The messages must
consist of 4 parts: laudatory phrase + event + author + city. Use the following predefined parts:
- Phrases – {"Excellent product.", "Such a great product.", "I always use that product.", "Best product of its
category.", "Exceptional product.", "I can’t live without this product."}
- Events – {"Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the
results!", "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"}
- Authors – {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"}
- Cities – {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"}
The format of the output message is: {phrase} {event} {author} – {city}.
As an input, you take the number of messages to be generated. Print each random message on a separate line.
 */
package Fundamentals.Lect6_ObjectsAndClasses;

import java.util.Random;
import java.util.Scanner;

public class Ex1_AdvertisementMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] phrases = {"Excellent product.", "Such a great product.", "I always use that product.",
                "Best product of its category.", "Exceptional product.", "I can’t live without this product."};

        String[] events = {"Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!",
                "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"};

        String[] authors = {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};

        String[] cities = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

        Random random = new Random();

        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= number; i++) {
            int phrasesIndex = random.nextInt(phrases.length);
            int eventsIndex = random.nextInt(events.length);
            int authorsIndex = random.nextInt(authors.length);
            int citiesIndex = random.nextInt(cities.length);

            System.out.printf("%s %s %s - %s%n", phrases[phrasesIndex], events[eventsIndex], authors[authorsIndex], cities[citiesIndex]);
        }

    }
}
