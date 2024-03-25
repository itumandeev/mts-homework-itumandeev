package ru.mts.homework.lesson3;

import java.time.LocalDate;
import java.time.Period;

/**
 * @author ITUMANDEEV
 * version 0.2
 */
public class Predator extends AbstractAnimal {
    /**
     * Конструктор - создание нового объекта с определенными значениями
     *
     * @param breed     - порода
     * @param name      - имя
     * @param character - характер
     * @param cost      - цена
     * @param birthDate - дата рождения
     */
    Predator(String breed, String name, String character, double cost, LocalDate birthDate) {
        this.breed = breed;
        this.name = name;
        this.character = character;
        this.cost = cost;
        this.birthDate = birthDate;
    }

    Predator(String breed, String name, LocalDate birthDate) {
        this.breed = breed;
        this.name = name;
        this.birthDate = birthDate;
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

    /**
     * функция получения характера
     */
    @Override
    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    @Override
    public int getAge() {
        Period period = Period.between(getBirthDate(), LocalDate.now());
        return period.getYears();
    }
}