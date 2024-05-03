package ru.mts.homework.lesson9;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import ru.mts.homework.lesson3.AbstractAnimal;
import ru.mts.homework.lesson3.Animal;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class SaveInfoToFile {
    private static Path dataPath = Paths.get("src", "main", "java", "ru", "mts", "homework", "resources", "animals", "logData.txt");
    private static Path secPath = Paths.get("src", "main", "java", "ru", "mts", "homework", "resources", "secretStore", "secretInformation.txt");
    private static Path jsnPath = Paths.get("src", "main", "java", "ru", "mts", "homework", "resources", "results", "findOlderAnimals.json");

    private String secretInformation;

    public static void saveAnimal(AbstractAnimal abstractAnimal) throws IOException {
        List<String> list = new ArrayList<>();

        try {
            if (!Files.exists(dataPath)) {
                FilesExample.createFile(dataPath);
            }
            list = Files.readAllLines(dataPath, Charset.forName("UTF-16"));
            int size = list.size() + 1;
            Files.writeString(dataPath, size + " " + abstractAnimal.toFileString() + "\n", Charset.forName("UTF-16"), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    public static void saveAnimalsToJson(List<Animal> animals) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.writeValue(new File(String.valueOf(jsnPath)), animals);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
