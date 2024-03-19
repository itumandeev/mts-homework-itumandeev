package ru.mts.homework.lession6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.mts.homework.lession3.Animal;
import ru.mts.homework.lession3.CreateAnimalServiceImpl;
import ru.mts.homework.lession6.exeptions.InvalidAnimalListException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AnimalsRepositoryImpTest {
    CreateAnimalServiceImpl test1 = new CreateAnimalServiceImpl();
    AnimalsRepositoryImp repository = new AnimalsRepositoryImp();

    @Test
    @DisplayName("findLeapYearNamesNullObject: пустой объект")
    void findLeapYearNamesNullObject() {
        ArrayList<Animal> animalsList = new ArrayList<Animal>();
        InvalidAnimalListException runtimeException = assertThrows(InvalidAnimalListException.class, () -> repository.findLeapYearNames(null, animalsList));
        assertEquals("Пустой объект", runtimeException.getMessage());
    }

    @Test
    @DisplayName("findLeapYearNamesNullObject: НЕ пустой объект")
    void findLeapYearNamesWithoutNullObject() {
        Map<String, List<Animal>> animalMap = new HashMap<>();
        animalMap = test1.createAnimals(3, "dog");
        for (Map.Entry<String, List<Animal>> entry : animalMap.entrySet()) {
            assertDoesNotThrow(() -> repository.findLeapYearNames(entry.getKey(), entry.getValue()));
        }
    }

    @Test
    @DisplayName("findOlderAnimal: пустой объект")
    void findOlderAnimalNullObject() {
        ArrayList<Animal> animalsList = new ArrayList<Animal>();
        InvalidAnimalListException runtimeException = assertThrows(InvalidAnimalListException.class, () -> repository.findOlderAnimal(animalsList, LocalDate.now()));
        assertEquals("Пустой объект", runtimeException.getMessage());
    }

    @Test
    @DisplayName("findOlderAnimal: пустой объект")
    void findOlderAnimalWithoutNullObject() {
        Map<String, List<Animal>> animalMap = new HashMap<>();
        animalMap = test1.createAnimals(3, "dog");
        for (Map.Entry<String, List<Animal>> entry : animalMap.entrySet()) {
            assertDoesNotThrow(() -> repository.findOlderAnimal(entry.getValue(), LocalDate.of(2000,01,12)));
        }
    }

    @Test
    @DisplayName("findDuplicate:пустой объект")
    void findDuplicateNullObject() {
        ArrayList<Animal> animalsList = new ArrayList<Animal>();
        InvalidAnimalListException runtimeException = assertThrows(InvalidAnimalListException.class, () -> repository.findDuplicate(animalsList));
        assertEquals("Пустой объект", runtimeException.getMessage());
    }

    @Test
    @DisplayName("findDuplicate: НЕ пустой объект")
    void findDuplicateWithoutNullObject() {
        Map<String, List<Animal>> animalMap = new HashMap<>();
        animalMap = test1.createAnimals(3, "dog");
        for (Map.Entry<String, List<Animal>> entry : animalMap.entrySet()) {
            assertDoesNotThrow(() -> repository.findDuplicate(entry.getValue()));
        }
    }
}