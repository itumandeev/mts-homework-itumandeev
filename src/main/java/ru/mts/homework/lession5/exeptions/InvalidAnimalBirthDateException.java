package ru.mts.homework.lession5.exeptions;

public class InvalidAnimalBirthDateException extends Exception {
    private static final String ERROR_MESSAGE = "у животного не указана дата его рождения";

    public InvalidAnimalBirthDateException() {
        super(ERROR_MESSAGE);
    }

    public InvalidAnimalBirthDateException(String message, Throwable cause) {
        super(message, cause);
    }
}
