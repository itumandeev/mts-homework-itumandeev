package ru.mts.homework.lession3;

/**
 * @author ITUMANDEEV
 * version 0.1
 */
public class Predator extends AbstractAnimal {
    /**
     * Конструктор - создание нового объекта с определенными значениями
     *
     * @param breed     - порода
     * @param name      - имя
     * @param character - характер
     * @param cost      - цена
     */
    Predator(String breed, String name, String character, double cost) {
        this.breed = breed;
        this.name = name;
        this.character = character;
        this.cost = cost;
    }

    Predator(String breed, String name) {
        this.breed = breed;
        this.name = name;
    }
    /**
     * функция получения породы
     */
    @Override
    public String getBreed() {
        return this.breed;
    }
    /**
     * функция получения имени
     */
    @Override
    public String getName() {
        return this.name;
    }
    /**
     * функция получения цены
     */
    @Override
    public double getCost() {
        return this.cost;
    }
    /**
     * функция получения характера
     */
    @Override
    public String getCharacter() {
        return this.character;
    }
}