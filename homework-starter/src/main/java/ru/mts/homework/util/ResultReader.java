package ru.mts.homework.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import ru.mts.homework.dto.AbstractAnimal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ResultReader {
    private static Path jsnPath = Paths.get("homework","src", "main", "java", "ru", "mts", "homework", "resources", "results", "findOlderAnimals.json");

    public static void readAnimalsFromJson() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            String json = Files.readString(jsnPath);
            List<AbstractAnimal> list = objectMapper.readValue(json, new TypeReference<ArrayList<AbstractAnimal>>() {});
            for (AbstractAnimal a : list) {
                System.out.println(a);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void countJsonLines() throws IOException {
        try {
            List<String> lines = Files.readAllLines(jsnPath);
            System.out.println("Число строк в файле json = " + lines.size());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}