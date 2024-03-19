package ru.mts.homework.lession6;

import ru.mts.homework.lession3.Animal;
import ru.mts.homework.lession5.exeptions.InvalidAnimalBirthDateException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface AnimalRepository {
    Map<String, LocalDate> findLeapYearNames(String type, List<Animal> animals) throws InvalidAnimalBirthDateException;

    Map<Animal, Integer> findOlderAnimal(List<Animal> animals, LocalDate date);

    Map<String, Integer> findDuplicate(List<Animal> animals);
}