package ru.mts.homework.lesson6;

import ru.mts.homework.lesson3.Animal;
import ru.mts.homework.lesson5.SearchService;
import ru.mts.homework.lesson6.exeptions.InvalidAnimalListException;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class AnimalsRepositoryImp implements AnimalRepository, SearchService {
    @Override
    public Map<String, Integer> findDuplicate(List<Animal> animals) {
        Map<String, Integer> result = new HashMap<>();
        HashSet<Animal> animalSet = new HashSet<>();
        if (animals.isEmpty()) {
            throw new InvalidAnimalListException("Пустой объект");
        } else {
            /*реализация урока 6
            for (Animal animal : animals) {
                if (!animalSet.add(animal)) {
                    var type = animal.getClass().getSimpleName();
                    var defaultValue = 1;
                    var animalNumber = result.getOrDefault(type, defaultValue);
                    result.put(type, animalNumber + 1);
                }
            }*/
            //реализация урока 7
            animals.stream()
                    .forEach(animal -> {
                        if (!animalSet.add(animal)) {
                            var type = animal.getClass().getSimpleName();
                            var defaultValue = 1;
                            var animalNumber = result.getOrDefault(type, defaultValue);
                            result.put(type, animalNumber + 1);
                        }
                    });
            return result;
        }
    }

    @Override
    public Map<Animal, Integer> findOlderAnimal(List<Animal> animals, int age) {
        Map<Animal, Integer> result;

        if (animals.isEmpty()) {
            throw new InvalidAnimalListException("Пустой объект");
        } else {
            /*реализация урока 6
            Animal olderAnimal = animals.get(0);
            for (Animal animal : animals) {
                System.out.println(animal);
                LocalDate animalBirthDate = animal.getBirthDate();
                if (animalBirthDate.isAfter(date)) {
                    result.put(animal, animal.getAge());
                }
                if (animalBirthDate.isAfter(olderAnimal.getBirthDate())) {
                    olderAnimal = animal;
                }
            }
            if (result.isEmpty()) {
                result.put(olderAnimal, olderAnimal.getAge());
            }*/
            //реализация урока 7
            result = animals.stream()
                    .filter(animal -> animal.getAge() > age)
                    .collect(Collectors.toMap(animal -> animal, Animal::getAge));
            if (result.isEmpty()) {
                animals.stream()
                        .max(Comparator.comparing(Animal::getAge))
                        .map((a) -> result.put(a, a.getAge()));
            }
            return result;
        }
    }

    @Override
    public Map<String, LocalDate> findLeapYearNames(String type, List<Animal> animals) {
        Map<String, LocalDate> leapYearNames;
        if (animals.isEmpty()) {
            throw new InvalidAnimalListException("Пустой объект");
        } else {
            /*реализация урока 6
            for (Animal animal : animals) {
                if (checkLeapYearAnimal(animal)) {
                    leapYearNames.put(type + " " + animal.getName(), animal.getBirthDate());
                }
            }*/
            //реализация урока 7
            leapYearNames = animals.stream()
                    .filter(animal -> animal.getBirthDate().isLeapYear())
                    .collect(Collectors.toMap((a) -> a.getClass().getSimpleName() + " " + a.getName(), Animal::getBirthDate, (a1, a2) -> a1));
            return leapYearNames;
        }
    }

    public int findAverageAge(Map<String, List<Animal>> animals) {
        return (int) animals.values().stream()
                .flatMap(Collection::stream)
                .mapToInt(Animal::getAge)
                .average()
                .orElse(-1);
    }

    public Double findAveragePrice(Map<String, List<Animal>> animals) {
        return animals.values().stream()
                .flatMap(Collection::stream)
                .mapToDouble(Animal::getCost)
                .average()
                .orElse(0);
    }

    public List<Animal> findOldAndExpensive(Map<String, List<Animal>> animals, int age) {
        Double avgPrice = findAveragePrice(animals);
        return animals.values().stream()
                .flatMap(Collection::stream)
                .filter(animal -> animal.getAge() > age)
                .filter(animal -> animal.getCost() > avgPrice)
                .sorted(Comparator.comparingInt(Animal::getAge))
                .collect(Collectors.toList());
    }

    public List<Animal> findMinConstAnimals(Map<String, List<Animal>> animals) {
        return animals.values().stream()
                .flatMap(Collection::stream)
                .sorted(Comparator.comparingDouble(Animal::getCost))
                .limit(3)
                .sorted((a1, a2) -> -a1.getName().compareTo(a2.getName()))
                .collect(Collectors.toList());
    }
}