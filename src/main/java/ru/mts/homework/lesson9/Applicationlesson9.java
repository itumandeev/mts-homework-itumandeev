package ru.mts.homework.lesson9;

import ru.mts.homework.lesson3.Animal;
import ru.mts.homework.lesson3.CreateAnimalServiceImpl;
import ru.mts.homework.lesson6.AnimalsRepositoryImp;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Applicationlesson9 {
    public static void main(String[] args) throws IOException {
        CreateAnimalServiceImpl test1 = new CreateAnimalServiceImpl();
        test1.createAnimal("Cat");
        test1.createAnimal("Cat");
        FilesExample.readAll();


        AnimalsRepositoryImp anRep = new AnimalsRepositoryImp();
        Map<String, List<Animal>> animalMap = new HashMap<>();
        animalMap = test1.createAnimals(3, "Cat");
        System.out.println("-------");
        System.out.println("---findOlderAnimal----");
        for (Map.Entry<String, List<Animal>> entry : animalMap.entrySet()) {
            System.out.println(anRep.findOlderAnimal(entry.getValue(), 5));
        }
        System.out.println("-------");
        ResultReader.readAnimalsFromJson();
        ResultReader.countJsonLines();
    }
}