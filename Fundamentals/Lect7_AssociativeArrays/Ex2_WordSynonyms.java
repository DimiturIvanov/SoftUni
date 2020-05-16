/*
Write a program which keeps a map with synonyms. The key of the map will be the word. The value will be a list of
all the synonyms of that word. You will be given a number n. On the next 2 * n lines you will be given a word and a
synonym each on a separate line like this:
- {word}
- {synonym}
If you get the same word for second time, just add the new synonym to the list.
Print the words in the following format:
{word} - {synonym1, synonym2… synonymN}
 */
package Fundamentals.Lect7_AssociativeArrays;

import java.util.*;

public class Ex2_WordSynonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, List<String>> wordSynonyms = new LinkedHashMap<>();

        for (int i = 1; i <= number; i++) {
            String word = scanner.nextLine();
            String synonym = scanner.nextLine();

            if (!wordSynonyms.containsKey(word)) {
                wordSynonyms.put(word, new ArrayList<>());
            }
            wordSynonyms.get(word).add(synonym);
        }

        for (Map.Entry<String, List<String>> entry : wordSynonyms.entrySet()) {
            System.out.print(entry.getKey() + " - ");
            String synonym = String.join(", ", entry.getValue());
            System.out.println(synonym);
        }

    }
}
