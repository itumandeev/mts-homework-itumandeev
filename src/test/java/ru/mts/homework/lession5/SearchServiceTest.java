package ru.mts.homework.lession5;

import org.junit.jupiter.api.DisplayName;
import ru.mts.homework.lession3.Cat;
import ru.mts.homework.lession5.exeptions.InvalidAnimalBirthDateException;
import ru.mts.homework.lession5.exeptions.InvalidAnimalException;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class SearchServiceTest {
    SearchServiceimpl serv1 = new SearchServiceimpl();

    @org.junit.jupiter.api.Test
    @DisplayName("Проверка: пустой объект")
    void checkLeapYearAnimalWithNullObject() {
        InvalidAnimalException runtimeException = assertThrows(InvalidAnimalException.class, () -> serv1.checkLeapYearAnimal(null));

        assertEquals("На вход пришёл некорректный объект животного " + LocalDate.now(), runtimeException.getMessage());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Проверка: НЕ пустой объект")
    void checkLeapYearAnimalWithoutNullObject() throws InvalidAnimalBirthDateException {
        Cat catTest = new Cat("Сиамская", "Муся", "Ласковый", 666, LocalDate.now());
        assertDoesNotThrow(() -> serv1.checkLeapYearAnimal(catTest));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Проверка: на вход объект животное")
    void checkLeapYearAnimalWithObjectAnimal() {
        Cat catTest = new Cat("Сиамская", "Муся", "Ласковый", 666, LocalDate.now());
        assertDoesNotThrow(() -> serv1.checkLeapYearAnimal(catTest));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Проверка: на вход НЕ пустая дата рождения")
    void checkLeapYearAnimalWithDiffObject() {
        Cat catTest = new Cat("Сиамская", "Муся", "Ласковый", 666, LocalDate.now());
        assertDoesNotThrow(() -> serv1.checkLeapYearAnimal(catTest));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Проверка: на вход пустая дата рождения")
    void checkLeapYearAnimalWithNullBirthDate() {
        Cat catTest = new Cat("Сиамская", "Муся", "Ласковый", 666, null);
        InvalidAnimalBirthDateException runtimeException = assertThrows(InvalidAnimalBirthDateException.class, () -> serv1.checkLeapYearAnimal(catTest));

        assertEquals("У животного Муся не указана дата его рождения", runtimeException.getMessage());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Проверка: на вход высокосный год")
    void checkLeapYearAnimalWithLeapYear() throws InvalidAnimalBirthDateException {
        Cat catTest = new Cat("Сиамская", "Муся", "Ласковый", 666, LocalDate.of(2000, 1, 1));
        boolean result = serv1.checkLeapYearAnimal(catTest);
        assertEquals(true, result);
        assertNotEquals(false, result);
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Проверка: на вход высокосный год")
    void checkLeapYearAnimalWithoutLeapYear() throws InvalidAnimalBirthDateException {
        Cat catTest = new Cat("Сиамская", "Муся", "Ласковый", 666, LocalDate.of(2001, 1, 1));
        boolean result = serv1.checkLeapYearAnimal(catTest);
        assertEquals(false, result);
        assertNotEquals(true, result);
    }
}