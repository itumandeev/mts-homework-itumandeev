package ru.mts.homework.lession3;

public class Application {
    public static void main(String[] args) {
        CreateAnimalServiceImpl test1 = new CreateAnimalServiceImpl();
        test1.createAnimals("dog");
        System.out.println("  ");
        test1.createAnimals(3, "wolf");
        System.out.println("  ");
        test1.createWrapper("cat");
    }
}