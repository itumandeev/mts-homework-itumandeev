package ru.mts.homework.lession6;

import ru.mts.homework.lession3.Animal;
import ru.mts.homework.lession5.SearchService;
import ru.mts.homework.lession5.exeptions.InvalidAnimalBirthDateException;
import ru.mts.homework.lession6.exeptions.InvalidAnimalListException;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class AnimalsRepositoryImp implements AnimalRepository, SearchService {
    @Override
    public Map<String, Integer> findDuplicate(List<Animal> animals) {
        Map<String, Integer> result = new HashMap<>();
        HashSet<Animal> animalSet = new HashSet<>();
        if (animals.isEmpty()) {
            throw new InvalidAnimalListException("Пустой объект");
        } else {
            for (Animal anml : animals) {
                if (!animalSet.add(anml)) {
                    var type = anml.getClass().getSimpleName();
                    var defaultValue = 1;
                    var animalNumber = result.getOrDefault(type, defaultValue);
                    result.put(type, animalNumber + 1);
                }
            }
            return result;
        }
    }

    @Override
    public Map<Animal, Integer> findOlderAnimal(List<Animal> animals, LocalDate date) {
        Map<Animal, Integer> leapYearNames = new HashMap<>();
        ArrayList<Integer> ages = new ArrayList<Integer>();

        if (animals.isEmpty()) {
            throw new InvalidAnimalListException("Пустой объект");
        } else {
            Animal olderAnimal = animals.get(0);
            for (Animal animal : animals) {
                System.out.println(animal);
                LocalDate animalBirthDate = animal.getBirthDate();
                if (animalBirthDate.isAfter(date)) {
                    Period period = Period.between(animalBirthDate, LocalDate.now());
                    leapYearNames.put(animal, period.getYears());
                    ages.add(period.getYears());
                }
                if (animalBirthDate.isAfter(olderAnimal.getBirthDate())) {
                    olderAnimal = animal;
                }
            }
            if (leapYearNames.isEmpty()) {
                Period period = Period.between(olderAnimal.getBirthDate(), LocalDate.now());
                leapYearNames.put(olderAnimal, period.getYears());
            }
            return leapYearNames;
        }
    }

    @Override
    public Map<String, LocalDate> findLeapYearNames(String type, List<Animal> animals) throws InvalidAnimalBirthDateException {
        Map<String, LocalDate> leapYearNames = new HashMap<>();
        if (animals.isEmpty()) {
            throw new InvalidAnimalListException("Пустой объект");
        } else {
            for (Animal animal : animals) {
                if (checkLeapYearAnimal(animal)) {
                    leapYearNames.put(type + " " + animal.getName(), animal.getBirthDate());
                }
            }
            return leapYearNames;
        }
    }
}
