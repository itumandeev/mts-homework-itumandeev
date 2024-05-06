package ru.mts.homework.dto;

import java.time.LocalDate;

/**
 * @author ITUMANDEEV
 * version 0.1
 */
public class Wolf extends Predator {
    /**
     * Конструктор - создание нового объекта с определенными значениями
     *
     * @param breed     - порода
     * @param name      - имя
     * @param birthDate - дата рождения
     */
    public Wolf(String breed, String name, LocalDate birthDate) {
        super(breed, name, birthDate);
    }

    Wolf() {
        super();
    }

    @Override
    public String toString() {
        return "Wolf{" +
                "breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", character='" + character + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", secretInfo='" + secretInfo + '\'' +
                '}';
    }
}