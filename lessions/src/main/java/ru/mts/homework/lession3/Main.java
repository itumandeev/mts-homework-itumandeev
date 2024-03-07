package ru.mts.homework.lession3;

import java.util.Random;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        CreateAnimalServiceImpl test1 = new CreateAnimalServiceImpl();
        test1.create();
        System.out.println("  ");
        test1.create(3);
        System.out.println("  ");
        test1.createWrapper();
    }
}

class CreateAnimalServiceImpl implements CreateAnimalService{
    public void create(int count) {
        for(int i = count;i>0;i--){
            Cat cat = new Cat(
                    UUID.randomUUID().toString(),
                    UUID.randomUUID().toString(),
                    UUID.randomUUID().toString(),
                    new Random().nextDouble());
            System.out.println(cat);
        }
    }

    @Override
    public void create() {
        int counter = 5;
        do{
            Cat cat = new Cat(
                    UUID.randomUUID().toString(),
                    UUID.randomUUID().toString(),
                    UUID.randomUUID().toString(),
                    new Random().nextDouble());
            System.out.println(cat);
            counter--;
        } while (counter>0);
    }
    public void createWrapper(){
        CreateAnimalService.super.create();
    }
}