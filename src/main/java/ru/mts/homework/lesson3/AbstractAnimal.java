package ru.mts.homework.lesson3;

import java.time.LocalDate;
import java.util.Objects;

/**
 * @author ITUMANDEEV
 * version 0.2
 */
public abstract class AbstractAnimal implements Animal {
    /**
     * поле порода
     */
    protected String breed;
    /**
     * поле имя
     */
    protected String name;
    /**
     * поле цена
     */
    protected double cost;
    /**
     * поле характер
     */
    protected String character;
    /**
     * поле дата рождения
     */
    protected LocalDate birthDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractAnimal that = (AbstractAnimal) o;
        return Objects.equals(breed, that.breed) && Objects.equals(name, that.name) && Objects.equals(cost, that.cost)
                && Objects.equals(character, that.character) && Objects.equals(birthDate, that.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(breed, name, cost, character, birthDate);
    }
}