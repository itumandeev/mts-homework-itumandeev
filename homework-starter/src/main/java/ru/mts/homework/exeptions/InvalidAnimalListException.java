package ru.mts.homework.exeptions;

public class InvalidAnimalListException extends RuntimeException {
    public InvalidAnimalListException(String message) {
        super(message);
    }
}