package ru.mts.homework.lession3;

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
     */
    Wolf(String breed, String name) {
        super(breed, name);
    }

    @Override
    public String toString() {
        return "Wolf{" +
                "breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", character='" + character + '\'' +
                '}';
    }
}