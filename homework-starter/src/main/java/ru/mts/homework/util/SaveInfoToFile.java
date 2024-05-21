package ru.mts.homework.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Component;
import ru.mts.homework.dto.AbstractAnimal;
import ru.mts.homework.dto.Animal;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

@Component
public class SaveInfoToFile {
    private Path dataPath = Paths.get("homework-application","resources", "animals", "logData.txt");
    private Path secPath = Paths.get("homework-application","resources", "secretStore", "secretInformation.txt");
    private Path jsnPath = Paths.get("homework-application","resources", "results", "findOlderAnimals.json");

    private String secretInformation;

    public void saveAnimal(AbstractAnimal abstractAnimal) throws IOException {
        List<String> list = new ArrayList<>();

        try {
            if (!Files.exists(dataPath)) {
                createFile(dataPath);
            }
            list = Files.readAllLines(dataPath, Charset.forName("UTF-8"));
            int size = list.size() + 1;
            Files.writeString(dataPath, size + " " + abstractAnimal.toFileString() + "\n", Charset.forName("UTF-8"), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    public void saveAnimalsToJson(List<Animal> animals) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.writeValue(new File(String.valueOf(jsnPath)), animals);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createFile(Path pth) {
        try {
            Files.createFile(pth);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
