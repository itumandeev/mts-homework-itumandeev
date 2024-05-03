package ru.mts.homework.lesson3;

import ru.mts.homework.lesson9.SaveInfoToFile;

import java.io.IOException;
import java.security.SecureRandom;
import java.time.LocalDate;
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
    List<String> names = Arrays.asList("Вася", "Муся", "Пуся", "Дуся", "Куся", "Люся", "Вупсень", "Пупсень",
            "Обиван", "Квайгон", "Арагорн", "Фродо", "Сэм", "Легосал", "Трор");
    List<String> characters = Arrays.asList("Спокойный", "Сказочный", "Мутный", "Шабутной", "Пришибленный", "Кантуженный", "Ласковый", "Добрый",
            "Кремень", "Дикий");
    List<String> breeds = Arrays.asList("Лесной", "Степной", "Пустынный", "Капустный", "Деревянный", "Камышовый", "Домашний", "Какашный",
            "Диванный", "Коренной");

    default Map<String, List<Animal>> createAnimals(String type) throws IOException {
        Map<String, List<Animal>> animalMap = new HashMap<>();
        ArrayList<Animal> animalList = new ArrayList<Animal>();
        int counter = 10;
        System.out.println("Создаем животное " + type + " " + counter + " раз");
        while (counter != 0) {
            animalList.add(createAnimal(type));
            counter--;
        }
        animalMap.put(type,animalList);
        return animalMap;
    }

    default Animal createAnimal(String type) throws IOException {
        switch (type) {
            case ("Cat"): {
                Cat cat = new Cat(
                        getRandomParam(breeds),
                        getRandomParam(names),
                        getRandomParam(characters),
                        new Random().nextDouble(),
                        getRandomDate());
                System.out.println(cat);
                SaveInfoToFile.saveAnimal(cat);
                return cat;
            }
            case ("Dog"): {
                Dog dog = new Dog(
                        getRandomParam(breeds),
                        getRandomParam(names),
                        getRandomParam(characters),
                        new Random().nextDouble(),
                        getRandomDate());
                System.out.println(dog);
                SaveInfoToFile.saveAnimal(dog);
                return dog;
            }
            case ("Shark"): {
                Shark shark = new Shark(
                        getRandomParam(breeds),
                        getRandomParam(names),
                        getRandomDate());
                System.out.println(shark);
                SaveInfoToFile.saveAnimal(shark);
                return shark;
            }
            case ("Wolf"): {
                Wolf wolf = new Wolf(
                        getRandomParam(breeds),
                        getRandomParam(names),
                        getRandomDate());
                System.out.println(wolf);
                SaveInfoToFile.saveAnimal(wolf);
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