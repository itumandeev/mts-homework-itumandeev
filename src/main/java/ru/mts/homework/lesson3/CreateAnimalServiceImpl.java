package ru.mts.homework.lesson3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс реализующий интерфейс CreateAnimalService
 *
 * @author ITUMANDEEV
 * version 0.2
 */

public class CreateAnimalServiceImpl implements CreateAnimalService {
    public Map<String, List<Animal>> createAnimals(int count, String type) throws IOException {
        Map<String, List<Animal>> animalMap = new HashMap<>();
        ArrayList<Animal> animalList = new ArrayList<Animal>();
        System.out.println("Создаем животное " + type + " " + count + " раз");
        for (int i = count; i > 0; i--) {
            animalList.add(createAnimal(type));
        }
        animalMap.put(type, animalList);
        return animalMap;
    }

    @Override
    public Map<String, List<Animal>> createAnimals(String type) throws IOException {
        Map<String, List<Animal>> animalMap = new HashMap<>();
        ArrayList<Animal> animalList = new ArrayList<Animal>();
        int counter = 5;
        System.out.println("Создаем животное " + type + " " + counter + " раз");
        do {
            animalList.add(createAnimal(type));
            counter--;
        } while (counter > 0);
        animalMap.put(type, animalList);
        return animalMap;
    }

    public void createWrapper(String type) throws IOException {
        CreateAnimalService.super.createAnimals(type);
    }
}