package ru.mts.homework.repository;

import ru.mts.homework.dto.Animal;
import ru.mts.homework.exeptions.InvalidAnimalBirthDateException;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface AnimalRepository {
    Map<String, LocalDate> findLeapYearNames() throws InvalidAnimalBirthDateException;

    Map<Animal, Integer> findOlderAnimal(int age);

    Map<String, Integer> findDuplicate();

    public int findAverageAge();

    public Double findAveragePrice();

    public List<Animal> findOldAndExpensive(int age);

    public List<Animal> findMinConstAnimals();
}