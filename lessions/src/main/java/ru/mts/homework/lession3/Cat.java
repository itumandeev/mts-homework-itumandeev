package ru.mts.homework.lession3;

/**
 * @author ITUMANDEEV
 * version 0.1
 */
public class Cat extends Pet {
    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param breed - порода
     * @param name - имя
     * @param character - характер
     * @param cost - цена
     */
    Cat(String breed, String name, String character, double cost) {
        super(breed, name, character, cost);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", character='" + character + '\'' +
                '}';
    }
}