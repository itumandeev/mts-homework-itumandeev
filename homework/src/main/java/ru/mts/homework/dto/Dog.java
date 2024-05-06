package ru.mts.homework.dto;

import java.time.LocalDate;

/**
 * @author ITUMANDEEV
 * version 0.2
 */
public class Dog extends Pet {
    /**
     * Конструктор - создание нового объекта с определенными значениями
     *
     * @param breed     - порода
     * @param name      - имя
     * @param character - характер
     * @param cost      - цена
     * @param birthDate - дата рождения
     */
    public Dog(String breed, String name, String character, double cost, LocalDate birthDate) {
        super(breed, name, character, cost, birthDate);
    }

    Dog() {
        super();
    }

    @Override
    public String toString() {
        return "Dog{" +
                "breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", character='" + character + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", age='" + getAge() + '\'' +
                ", secretInfo='" + secretInfo + '\'' +
                '}';
    }
}