package ru.mts.homework.lession3;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Интерфейс с методами
 * -созданию эскземляра(10 экземпляров) нужно класса, на вход принимает String <b>type</b>
 * -генерации случайных параметров: String <b>breed</> , String <b>name</>, String <b>character</>
 *
 * @author ITUMANDEEV
 * version 0.2
 */

public interface CreateAnimalService {
    List<String> names = Arrays.asList("Вася", "Муся", "Пуся", "Дуся", "Куся", "Люся", "Вупсень", "Пупсень",
            "Обиван", "Квайгон", "Арагорн", "Фродо", "Сэм", "Легосал", "Трор");
    List<String> characters = Arrays.asList("Спокойный", "Сказочный", "Мутный", "Шабутной", "Пришибленный", "Кантуженный", "Ласковый", "Добрый",
            "Кремень", "Дикий");
    List<String> breeds = Arrays.asList("Лесной", "Степной", "Пустынный", "Капустный", "Деревянный", "Камышовый", "Домашний", "Какашный",
            "Диванный", "Коренной");

    default void createAnimals(String type) {
        int counter = 10;
        System.out.println("Создаем животное " + type + " " + counter + " раз");
        while (counter != 0) {
            createAnimal(type);
            counter--;
        }
    }

    default Object createAnimal(String type) {
        switch (type) {
            case ("cat"): {
                Cat cat = new Cat(
                        getRandomParam(breeds),
                        getRandomParam(names),
                        getRandomParam(characters),
                        new Random().nextDouble(),
                        null
                        //getRandomDate())
                        );

                System.out.println(cat);
                return cat;
            }
            case ("dog"): {
                Dog dog = new Dog(
                        getRandomParam(breeds),
                        getRandomParam(names),
                        getRandomParam(characters),
                        new Random().nextDouble(),
                        getRandomDate());
                System.out.println(dog);
                return dog;
            }
            case ("shark"): {
                Shark shark = new Shark(
                        getRandomParam(breeds),
                        getRandomParam(names),
                        getRandomDate());
                System.out.println(shark);
                return shark;
            }
            case ("wolf"): {
                Wolf wolf = new Wolf(
                        getRandomParam(breeds),
                        getRandomParam(names),
                        getRandomDate());

                System.out.println(wolf);
                return wolf;
            }
            default: {
                System.out.println("Неизвестное животное");
                return null;
            }
        }
    }

    default String getRandomParam(List<String> params) {
        Random random = new SecureRandom();
        String param = params.get(random.nextInt(params.size()));
        return param;
    }

    default LocalDate getRandomDate() {
        Random random = new Random();
        int minDay = (int) LocalDate.of(1900, 1, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(2015, 1, 1).toEpochDay();
        long randomDay = minDay + random.nextInt(maxDay - minDay);
        LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);
        return randomBirthDate;
    }
}