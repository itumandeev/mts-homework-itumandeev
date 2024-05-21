package ru.mts.homework.service;

import ru.mts.homework.dto.*;

import java.io.IOException;
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

    Map<String, List<Animal>> createAnimals(String type) throws IOException;

    Animal createAnimal(String type) throws IOException;

}