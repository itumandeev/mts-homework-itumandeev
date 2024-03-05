package ru.mts.homework.lession3;

import java.security.SecureRandom;
import java.util.*;

/**
 * Интерфейс с методами
 * -созданию эскземляра(10 экземпляров) нужно класса, на вход принимает String <b>type</b>
 * -генерации случайных параметров: String <b>breed</> , String <b>name</>, String <b>character</>
 *
 * @author ITUMANDEEV
 * version 0.2
 */

public interface CreateAnimalService {
    default void createAnimals(String type) {
        int counter = 10;
        System.out.println("Создаем животное " + type + " " + counter + " раз");
        while (counter != 0) {
            createAnimal(type);
            counter--;
        }
    }

    default void createAnimal(String type) {
        switch (type) {
            case ("cat"): {
                Cat cat = new Cat(
                        getRandomName(),
                        getRandomBreed(),
                        getRandomCharacter(),
                        new Random().nextDouble());
                System.out.println(cat);
                break;
            }
            case ("dog"): {
                Dog dog = new Dog(
                        getRandomName(),
                        getRandomBreed(),
                        getRandomCharacter(),
                        new Random().nextDouble());
                System.out.println(dog);
                break;
            }
            case ("shark"): {
                Shark shark = new Shark(
                        getRandomName(),
                        getRandomBreed());
                System.out.println(shark);
                break;
            }
            case ("wolf"): {
                Wolf wolf = new Wolf(
                        getRandomName(),
                        getRandomBreed());
                System.out.println(wolf);
                break;
            }
            default: {
                System.out.println("Неизвестное животное");
            }
        }
    }

    default String getRandomName() {
        Random random = new SecureRandom();
        List<String> list = Arrays.asList("Вася", "Муся", "Пуся", "Дуся", "Куся", "Люся", "Вупсень", "Пупсень",
                "Обиван", "Квайгон", "Арагорн", "Фродо", "Сэм", "Легосал", "Трор");
        String name = list.get(random.nextInt(list.size()));
        return name;
    }

    default String getRandomCharacter() {
        Random random = new SecureRandom();
        List<String> list = Arrays.asList("Спокойный", "Сказочный", "Мутный", "Шабутной", "Пришибленный", "Кантуженный", "Ласковый", "Добрый",
                "Кремень", "Дикий");
        String name = list.get(random.nextInt(list.size()));
        return name;
    }

    default String getRandomBreed() {
        Random random = new SecureRandom();
        List<String> list = Arrays.asList("Лесной", "Степной", "Пустынный", "Капустный", "Деревянный", "Камышовый", "Домашний", "Какашный",
                "Диванный", "Коренной");
        String name = list.get(random.nextInt(list.size()));
        return name;
    }
}