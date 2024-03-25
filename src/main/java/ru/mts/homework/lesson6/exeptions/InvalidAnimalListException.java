package ru.mts.homework.lesson6.exeptions;

public class InvalidAnimalListException extends RuntimeException {
    public InvalidAnimalListException(String message) {
        super(message);
    }
}