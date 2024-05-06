package ru.mts.homework.service;

import org.springframework.stereotype.Service;
import ru.mts.homework.dto.AbstractAnimal;
import ru.mts.homework.exeptions.InvalidAnimalBirthDateException;
import ru.mts.homework.exeptions.InvalidAnimalException;

import java.io.InvalidObjectException;
import java.time.LocalDate;
import java.util.Objects;


public interface SearchService {
    boolean checkLeapYearAnimal(Object animal) throws InvalidAnimalBirthDateException;
}