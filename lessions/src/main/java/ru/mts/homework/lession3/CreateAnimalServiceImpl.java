package ru.mts.homework.lession3;

/**
 * Класс реализующий интерфейс CreateAnimalServiceс
 *
 * @author ITUMANDEEV
 * version 0.2
 */

class CreateAnimalServiceImpl implements CreateAnimalService {
    public void createAnimals(int count, String type) {
        System.out.println("Создаем животное " + type + " " + count + " раз");
        for (int i = count; i > 0; i--) {
            createAnimal(type);
        }
    }

    @Override
    public void createAnimals(String type) {
        int counter = 5;
        System.out.println("Создаем животное " + type + " " + counter + " раз");
        do {
            createAnimal(type);
            counter--;
        } while (counter > 0);
    }

    public void createWrapper(String type) {
        CreateAnimalService.super.createAnimals(type);
    }
}