package ru.mts.homework.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import ru.mts.homework.dto.*;
import ru.mts.homework.util.SaveInfoToFile;

import java.io.IOException;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.*;

/**
 * Класс реализующий интерфейс CreateAnimalService
 *
 * @author ITUMANDEEV
 * version 0.2
 */


public class CreateAnimalServiceImpl implements CreateAnimalService {

    List<String> names;
    List<String> characters;
    List<String> breeds;

    SaveInfoToFile saveInfoToFile;
    public CreateAnimalServiceImpl(List<String> names, List<String> characters, List<String> breeds,SaveInfoToFile saveInfoToFile){
        this.breeds=breeds;
        this.characters=characters;
        this.names=names;
        this.saveInfoToFile=saveInfoToFile;
    }

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

    public Animal createAnimal(String type) throws IOException {
        switch (type) {
            case ("Cat"): {
                Cat cat = new Cat(
                        getRandomParam(breeds),
                        getRandomParam(names),
                        getRandomParam(characters),
                        new Random().nextDouble(),
                        getRandomDate());
                System.out.println(cat);
                saveInfoToFile.saveAnimal(cat);
                return cat;
            }
            case ("Dog"): {
                Dog dog = new Dog(
                        getRandomParam(breeds),
                        getRandomParam(names),
                        getRandomParam(characters),
                        new Random().nextDouble(),
                        getRandomDate());
                System.out.println(dog);
                saveInfoToFile.saveAnimal(dog);
                return dog;
            }
            case ("Shark"): {
                Shark shark = new Shark(
                        getRandomParam(breeds),
                        getRandomParam(names),
                        getRandomDate());
                System.out.println(shark);
                saveInfoToFile.saveAnimal(shark);
                return shark;
            }
            case ("Wolf"): {
                Wolf wolf = new Wolf(
                        getRandomParam(breeds),
                        getRandomParam(names),
                        getRandomDate());
                System.out.println(wolf);
                saveInfoToFile.saveAnimal(wolf);
                return wolf;
            }
            default: {
                System.out.println("Неизвестное животное");
                return null;
            }
        }
    }

    public String getRandomParam(List<String> params) {
        Random random = new SecureRandom();
        String param = params.get(random.nextInt(params.size()));
        return param;
    }

    public LocalDate getRandomDate() {
        Random random = new Random();
        int minDay = (int) LocalDate.of(1900, 1, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(2015, 1, 1).toEpochDay();
        long randomDay = minDay + random.nextInt(maxDay - minDay);
        LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);
        return randomBirthDate;
    }
}