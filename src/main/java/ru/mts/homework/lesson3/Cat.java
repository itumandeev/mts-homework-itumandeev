package ru.mts.homework.lesson3;

import java.time.LocalDate;

/**
 * @author ITUMANDEEV
 * version 0.2
 */
public class Cat extends Pet {
    /**
     * Конструктор - создание нового объекта с определенными значениями
     *
     * @param breed     - порода
     * @param name      - имя
     * @param character - характер
     * @param cost      - цена
     * @param birthDate - дата рождения
     */
    public Cat() {
        super();
        name = "Cat";
        breed = "Cat";
    }

    public Cat(String breed, String name, String character, double cost, LocalDate birthDate) {
        super("Cat", name, character, cost, birthDate);
    }


    @Override
    public String toString() {
        return "Cat{" +
                "breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", character='" + character + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", secretInfo='" + secretInfo + '\'' +
                '}';
    }
}