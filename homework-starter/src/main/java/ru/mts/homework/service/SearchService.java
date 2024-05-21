package ru.mts.homework.service;

import ru.mts.homework.dto.AbstractAnimal;
import ru.mts.homework.exeptions.InvalidAnimalBirthDateException;
import ru.mts.homework.exeptions.InvalidAnimalException;


public interface SearchService {
    boolean checkLeapYearAnimal(Object animal) throws InvalidAnimalBirthDateException;
}