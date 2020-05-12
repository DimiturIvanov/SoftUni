/*
Create an article class with the following properties:
- Title – a string
- Content – a string
- Author – a string
The class should have a constructor and the following methods:
- Edit (new content) – change the old content with the new one
- ChangeAuthor (new author) – change the author
- Rename (new title) – change the title of the article
- override ToString – print the article in the following format:
"{title} - {content}:{author}"
Write a program that reads an article in the following format "{title}, {content}, {author}". On the next line, you will
get a number n. On the next n lines, you will get one of the following commands: "Edit: {new content}";
"ChangeAuthor: {new author}"; "Rename: {new title}". At the end, print the final article.
 */
package Fundamentals.Lect6_ObjectsAndClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex2_Articles {

    static class Article {
        private String title;
        private String content;
        private String author;

        public Article(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void setAuthor(String author) {
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

        String[] line = scanner.nextLine().split(", ");

        List<Article> articles = new ArrayList<>();

        String title = line[0];
        String content = line[1];
        String author = line[2];

        Article article = new Article(title, content, author);
        articles.add(article);

        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= number; i++) {
            String[] changeLine = scanner.nextLine().split(": ");
            String text = changeLine[1];

            switch (changeLine[0]) {
                case "Edit":
                    article.setContent(text);
                    break;
                case "ChangeAuthor":
                    article.setAuthor(text);
                    break;
                case "Rename":
                    article.setTitle(text);
                    break;
                default:
                    break;
            }
        }

        System.out.println(article);

    }
}
