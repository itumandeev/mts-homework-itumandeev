package ru.mts.homework.lession3;

public class Pet extends AbstractAnimal{
    Pet(String breed, String name, String character, double cost){
        this.breed = breed;
        this.name = name;
        this.character = character;
        this.cost = cost;
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

    @Override
    public String toString() {
        return super.toString();
    }
}