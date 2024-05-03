package ru.mts.homework.lesson7;

import ru.mts.homework.lesson3.Animal;
import ru.mts.homework.lesson3.CreateAnimalServiceImpl;
import ru.mts.homework.lesson6.AnimalsRepositoryImp;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ApplicationLesson7 {
    public static void main(String[] args) throws IOException {
        AnimalsRepositoryImp anRep = new AnimalsRepositoryImp();
        CreateAnimalServiceImpl test1 = new CreateAnimalServiceImpl();
        Map<String, List<Animal>> animalMap;
        animalMap = test1.createAnimals(8, "dog");
        System.out.println("-------");
        System.out.println("---findAverageAge----");
        System.out.println(anRep.findAverageAge(animalMap));
        System.out.println("---findOldAndExpensive----");
        System.out.println(anRep.findOldAndExpensive(animalMap, 5));
        System.out.println("---findMinConstAnimals----");
        System.out.println(anRep.findMinConstAnimals(animalMap));
    }
}
