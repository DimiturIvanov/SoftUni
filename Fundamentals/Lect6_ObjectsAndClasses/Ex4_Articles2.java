    /*
Change the program from the second problem, so you can store a list of articles. You will not need the methods
anymore (except the ToString method). On the first line, you will get a number n. On the next n lines, you will get
some articles in the same format as the previous task ("{title}, {content}, {author}"). Finally, you will get one of the
three inputs: "title", "content", "author". You need to order the articles alphabetically based on the command and
print them sorted by the given criteria.
 */
package Fundamentals.Lect6_ObjectsAndClasses;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Ex4_Articles2 {

    static class Article {
        private String title;
        private String content;
        private String author;

        public Article(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public String getContent() {
            return content;
        }

        public String getAuthor() {
            return author;
        }

        @Override
        public String toString() {
            return String.format("%s - %s: %s", getTitle(), getContent(), getAuthor());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Article> articles = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String[] line = scanner.nextLine().split(", ");
            String title = line[0];
            String content = line[1];
            String author = line[2];

            Article article = new Article(title, content, author);
            articles.add(article);
        }

        String command = scanner.nextLine();

        switch (command) {
            case "title":
                articles.sort(Comparator.comparing(Article::getTitle));
                break;
            case "content":
                articles.sort(Comparator.comparing(Article::getContent));
                break;
            case "author":
                articles.sort(Comparator.comparing(Article::getAuthor));
                break;
            default:
                break;
        }


        for (Article article : articles) {
            System.out.println(article);
        }

    }
}
