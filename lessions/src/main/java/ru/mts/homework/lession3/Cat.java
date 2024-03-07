package ru.mts.homework.lession3;

public class Cat extends Pet {
    Cat(String breed, String name, String character, double cost){
        super(breed, name, character,cost);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", character='" + character + '\'' +
                '}';
    }
}