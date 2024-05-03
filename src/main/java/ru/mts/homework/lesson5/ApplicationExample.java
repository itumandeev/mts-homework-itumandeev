package ru.mts.homework.lesson5;

import ru.mts.homework.lesson3.CreateAnimalServiceImpl;
import ru.mts.homework.lesson5.exeptions.InvalidAnimalBirthDateException;
import ru.mts.homework.lesson5.exeptions.InvalidAnimalException;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class ApplicationExample {
    public static void main(String[] args) throws Exception {
        CreateAnimalServiceImpl test1 = new CreateAnimalServiceImpl();
        SearchServiceimpl serv1 = new SearchServiceimpl();

            /*serv1.checkLeapYearAnimal(cat1);
            serv1.checkLeapYearAnimal(dog1);*/
            Object catTestWithoutBirthDay = /*new Object();*/ test1.createAnimal("cat");
            //catTestWithoutBirthDay = null;
            //serv1.checkLeapYearAnimal(catTestWithoutBirthDay);
            Object catTest = test1.createAnimal("dog");
            serv1.checkLeapYearAnimal(catTest);
    }
}