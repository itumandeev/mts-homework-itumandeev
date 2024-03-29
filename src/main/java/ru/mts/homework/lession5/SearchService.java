package ru.mts.homework.lession5;

import ru.mts.homework.lession3.AbstractAnimal;
import ru.mts.homework.lession5.exeptions.InvalidAnimalBirthDateException;
import ru.mts.homework.lession5.exeptions.InvalidAnimalException;

import java.io.InvalidObjectException;
import java.time.LocalDate;
import java.util.Objects;

public interface SearchService {
    default boolean checkLeapYearAnimal(Object animal) throws InvalidAnimalBirthDateException {
        if (Objects.isNull(animal)) {
            throw new InvalidAnimalException("На вход пришёл некорректный объект животного " + LocalDate.now(), new NullPointerException("Пустой объект"));
        } else {
            if (AbstractAnimal.class.isAssignableFrom(animal.getClass())) {
                LocalDate date = ((AbstractAnimal) animal).getBirthDate();
                if (date == null) {
                    throw new InvalidAnimalBirthDateException("У животного " + ((AbstractAnimal) animal).getName() + " не указана дата его рождения", new NullPointerException("Пустая дата рождения"));
                } else {
                    int year = date.getYear();
                    boolean leapyear = (year > 1584 && ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)));
                    if (leapyear) {
                        System.out.println(((AbstractAnimal) animal).getName() + " был рожден в високосный год");
                        return true;
                    } else {
                        System.out.println(((AbstractAnimal) animal).getName() + " не был рожден в високосный год.");
                        return false;
                    }
                }
            } else {
                throw new InvalidAnimalException("На вход пришёл НЕ объект животного", new InvalidObjectException("Неправильный объект"));
            }
        }
    }
}
