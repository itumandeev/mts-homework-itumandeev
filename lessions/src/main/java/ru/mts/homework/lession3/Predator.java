package ru.mts.homework.lession3;

public class Predator extends AbstractAnimal{
    Predator(String breed, String name, String character, double cost){
        this.breed = breed;
        this.name = name;
        this.character = character;
        this.cost = cost;
    }
    Predator(String breed, String name){
        this.breed = breed;
        this.name = name;
    }

    @Override
    public String getBreed() {
        return this.breed;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getCost() {
        return this.cost;
    }

    @Override
    public String getCharacter() {
        return this.character;
    }
}