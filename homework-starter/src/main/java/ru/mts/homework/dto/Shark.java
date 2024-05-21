package ru.mts.homework.dto;

import java.time.LocalDate;

/**
 * @author ITUMANDEEV
 * version 0.2
 */
public class Shark extends Predator {
    /**
     * Конструктор - создание нового объекта с определенными значениями
     *
     * @param breed     - порода
     * @param name      - имя
     * @param birthDate - дата рождения
     */
    public Shark(String breed, String name, LocalDate birthDate) {
        super(breed, name, birthDate);
    }
    Shark(){
        super();
    }
    @Override
    public String toString() {
        return "Shark{" +
                "breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", character='" + character + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", secretInfo='" + secretInfo + '\'' +
                '}';
    }
}