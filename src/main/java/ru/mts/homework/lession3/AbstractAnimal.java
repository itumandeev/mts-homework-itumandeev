package ru.mts.homework.lession3;

import java.time.LocalDate;

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
}