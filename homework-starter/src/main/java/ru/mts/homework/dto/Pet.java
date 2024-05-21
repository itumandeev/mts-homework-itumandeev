package ru.mts.homework.dto;

import java.time.LocalDate;
import java.time.Period;

/**
 * @author ITUMANDEEV
 * version 0.1
 */
public class Pet extends AbstractAnimal {
    /**
     * Конструктор - создание нового объекта с определенными значениями
     *
     * @param breed     - порода
     * @param name      - имя
     * @param character - характер
     * @param cost      - цена
     * @param birthDate - дата рождения
     */
    Pet(String breed, String name, String character, double cost, LocalDate birthDate) {
        super(breed,name,cost);
        this.character = character;
        this.birthDate = birthDate;
    }
    Pet(){
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
    public String toString() {
        return super.toString();
    }

    @Override
    public int getAge() {
        Period period = Period.between(getBirthDate(), LocalDate.now());
        return period.getYears();
    }
}