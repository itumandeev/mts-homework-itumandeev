package ru.mts.homework.lesson9;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesExample {
    static void createDirectory() {
        Path path = Paths.get("src", "main", "java", "ru", "mts", "homework", "resources", "animals");

        try {
            Files.createDirectory(path);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    static void createFile(String pth) {
        Path path = Paths.get(pth);

        try {
            Files.createFile(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void write(String pth, String txt) {
        Path path = Paths.get(pth);

        try {
            Files.writeString(path, txt);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void readStr() {
        Path path = Paths.get("src", "main", "java", "ru", "mts", "homework", "resources", "animals", "logData.txt");
        try {
            System.out.println(Files.readString(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void readAll() {
        Path path = Paths.get("src", "main", "java", "ru", "mts", "homework", "resources", "animals", "logData.txt");
        try {
            System.out.println(Files.readAllLines(path, Charset.forName("UTF-16")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
