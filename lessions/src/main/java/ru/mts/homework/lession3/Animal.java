package ru.mts.homework.lession3;

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
}