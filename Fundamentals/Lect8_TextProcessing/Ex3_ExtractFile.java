/*
Write a program that reads the path to a file and subtracts the file name and its extension.
 */
package Fundamentals.Lect8_TextProcessing;

import java.util.Scanner;

public class Ex3_ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        StringBuilder fileName = returnFileName(line, indexOfStartfileName(line), findIndexOfPoint(line));
        StringBuilder extension = returnExtension(line, findIndexOfPoint(line));

        System.out.printf("File name: %s%n", fileName);
        System.out.printf("File extension: %s", extension);

    }

    public static int findIndexOfPoint(String line) {
        int index = -1;

        for (int i = line.length() - 1; i >= 0; i--) {
            char symbol = line.charAt(i);
            if (symbol == '.') {
                index = i;
                break;
            }
        }
        return index;
    }

    public static int indexOfStartfileName(String line) {
        int index = -1;
        for (int i = line.length() - 1; i >= 0; i--) {
            char symbol = line.charAt(i);
            if (symbol == '\\') {
                index = i;
                break;
            }
        }
        return index;
    }

    public static StringBuilder returnFileName(String line, int indexStart, int indexEnd) {
        StringBuilder fileName = new StringBuilder();

        for (int i = indexStart + 1; i < indexEnd; i++) {
            char symbol = line.charAt(i);
            fileName.append(line.charAt(i));
        }
        return fileName;
    }

    public static StringBuilder returnExtension(String line, int index) {
        StringBuilder extension = new StringBuilder();

        for (int i = index + 1; i < line.length(); i++) {
            extension.append(line.charAt(i));
        }
        return extension;
    }

}
