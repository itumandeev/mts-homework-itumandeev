package ru.mts.homework.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mts.homework.dto.Animal;
import ru.mts.homework.exeptions.InvalidAnimalListException;
import ru.mts.homework.service.CreateAnimalServiceImpl;
import ru.mts.homework.util.SaveInfoToFile;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class AnimalsRepositoryImp implements AnimalRepository {

    @Autowired
    SaveInfoToFile saveInfoToFile;

    private List<Animal> animalsList;

    @Autowired
    CreateAnimalServiceImpl createServ;

    @PostConstruct
    public void postConstr() throws IOException {
        animalsList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            animalsList.add(createServ.createAnimal("Cat"));
        }
    }

    @Override
    public Map<String, Integer> findDuplicate() {
        Map<String, Integer> result = new HashMap<>();
        HashSet<Animal> animalSet = new HashSet<>();
        if (animalsList.isEmpty()) {
            throw new InvalidAnimalListException("Пустой объект");
        } else {
            animalsList.stream()
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
    public Map<Animal, Integer> findOlderAnimal(int age) {
        Map<Animal, Integer> result;

        if (animalsList.isEmpty()) {
            throw new InvalidAnimalListException("Пустой объект");
        } else {
            result = animalsList.stream()
                    .filter(animal -> animal.getAge() > age)
                    .collect(Collectors.toMap(animal -> animal, Animal::getAge));
            if (result.isEmpty()) {
                animalsList.stream()
                        .max(Comparator.comparing(Animal::getAge))
                        .map((a) -> result.put(a, a.getAge()));
            }
            saveInfoToFile.saveAnimalsToJson(result.keySet().stream().collect(Collectors.toList()));
            return result;
        }
    }

    @Override
    public Map<String, LocalDate> findLeapYearNames() {
        Map<String, LocalDate> leapYearNames;
        if (animalsList.isEmpty()) {
            throw new InvalidAnimalListException("Пустой объект");
        } else {
            leapYearNames = animalsList.stream()
                    .filter(animal -> animal.getBirthDate().isLeapYear())
                    .collect(Collectors.toMap((a) -> a.getClass().getSimpleName() + " " + a.getName(), Animal::getBirthDate, (a1, a2) -> a1));
            return leapYearNames;
        }
    }

    public int findAverageAge() {
        return (int) animalsList.stream()
                .mapToInt(Animal::getAge)
                .average()
                .orElse(-1);
    }

    public Double findAveragePrice() {
        return animalsList.stream()
                .mapToDouble(Animal::getCost)
                .average()
                .orElse(0);
    }

    public List<Animal> findOldAndExpensive(int age) {
        Double avgPrice = findAveragePrice();
        return animalsList.stream()
                .filter(animal -> animal.getAge() > age)
                .filter(animal -> animal.getCost() > avgPrice)
                .sorted(Comparator.comparingInt(Animal::getAge))
                .collect(Collectors.toList());
    }

    public List<Animal> findMinConstAnimals() {
        return animalsList.stream()
                .sorted(Comparator.comparingDouble(Animal::getCost))
                .limit(3)
                .sorted((a1, a2) -> -a1.getName().compareTo(a2.getName()))
                .collect(Collectors.toList());
    }
}