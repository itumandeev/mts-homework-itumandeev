package ru.mts.homework.exeptions;

public class InvalidAnimalException extends RuntimeException {
    private static final String ERROR_MESSAGE = "На вход пришёл некорректный объект животного";

    public InvalidAnimalException() {
        super(ERROR_MESSAGE);
    }

    public InvalidAnimalException(String message, Throwable cause) {
        super(message, cause);
    }
}