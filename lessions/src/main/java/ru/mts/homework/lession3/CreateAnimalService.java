package ru.mts.homework.lession3;

import java.util.Random;
import java.util.UUID;

public interface CreateAnimalService {
   default void create(){
        int counter = 10;
        while(counter!=0){
            Cat cat = new Cat(
                    UUID.randomUUID().toString(),
                    UUID.randomUUID().toString(),
                    UUID.randomUUID().toString(),
                    new Random().nextDouble());
            System.out.println(cat);
            counter--;
        }
    }
}