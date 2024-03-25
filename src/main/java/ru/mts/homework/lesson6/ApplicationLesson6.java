package ru.mts.homework.lesson6;

import ru.mts.homework.lesson3.Animal;
import ru.mts.homework.lesson3.Cat;
import ru.mts.homework.lesson3.CreateAnimalServiceImpl;
import ru.mts.homework.lesson3.Dog;
import ru.mts.homework.lesson5.exeptions.InvalidAnimalBirthDateException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApplicationLesson6 {
    public static void main(String[] args) throws InvalidAnimalBirthDateException {
        AnimalsRepositoryImp anRep = new AnimalsRepositoryImp();
        CreateAnimalServiceImpl test1 = new CreateAnimalServiceImpl();
        Map<String, List<Animal>> animalMap = new HashMap<>();
        animalMap = test1.createAnimals(3, "dog");
        System.out.println("-------");
        System.out.println("---findLeapYearNames----");
        for (Map.Entry<String, List<Animal>> entry : animalMap.entrySet()) {
            System.out.println(anRep.findLeapYearNames(entry.getKey(), entry.getValue()));
        }
        System.out.println("-------");
        System.out.println("---findOlderAnimal----");
        for (Map.Entry<String, List<Animal>> entry : animalMap.entrySet()) {
            System.out.println(anRep.findOlderAnimal(entry.getValue(), 22222));
        }
        System.out.println("-------");
        ArrayList<Animal> animalsList = new ArrayList<Animal>();
        Cat cat1 = (Cat) test1.createAnimal("cat");
        animalsList.add(cat1);
        animalsList.add(cat1);
        animalsList.add(cat1);
        Dog dog1 = (Dog) test1.createAnimal("dog");
        animalsList.add(dog1);
        animalsList.add(dog1);
        System.out.println(animalsList);
        System.out.println("-------");
        System.out.println("---findDuplicate----");
        System.out.println(anRep.findDuplicate(animalsList));
    }
}