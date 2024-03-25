package ru.mts.homework.lesson6;

import ru.mts.homework.lesson3.Animal;
import ru.mts.homework.lesson5.exeptions.InvalidAnimalBirthDateException;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface AnimalRepository {
    Map<String, LocalDate> findLeapYearNames(String type, List<Animal> animals) throws InvalidAnimalBirthDateException;

    Map<Animal, Integer> findOlderAnimal(List<Animal> animals, int age);

    Map<String, Integer> findDuplicate(List<Animal> animals);

    public int findAverageAge(Map<String, List<Animal>> animals);

    public List<Animal> findOldAndExpensive(Map<String, List<Animal>> animals, int age);

    public List<Animal> findMinConstAnimals(Map<String, List<Animal>> animals);
}