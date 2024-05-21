package ru.mts.homework.dto;

import java.time.LocalDate;

/**
 * @author ITUMANDEEV
 * version 0.1
 */
public interface Animal {
    /**
     * функция получения породы
     */
    String getBreed();

    /**
     * функция получения имени
     */
    String getName();

    /**
     * функция получения цены
     */
    double getCost();

    /**
     * функция получения характера
     */
    String getCharacter();

    /**
     * функция получения дня рождения
     */
    LocalDate getBirthDate();
    /**
     * функция получения возраста
     */
    int getAge();
}