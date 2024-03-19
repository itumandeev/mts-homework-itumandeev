package ru.mts.homework.lession6.exeptions;

public class InvalidAnimalListException extends RuntimeException {
    public InvalidAnimalListException(String message) {
        super(message);
    }
}