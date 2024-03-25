package ru.mts.homework.lesson4.exeptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InvalidObjectException;

public class ExceptionExample {

    private static final Integer CONSTANT = 100;

    public static void main(String[] args) {
        //System.out.println(delit(null, 10));

        int result;

        try {
            result = delitWithChecked(null, 10);
            //result = delitWithChecked(10, null);
        } catch (InvalidObjectException | CustomException e) {
            try {
                throw new Exception("При делении произошла ошибка", e);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        } finally {
            System.out.println("Вызываем finally");
        }

        //работа с несуществующим файлом
        try (FileInputStream fileInputStream = new FileInputStream("example.txt")) {
            //проводим работу над fileInputStream
            InputStreamReader reader = new InputStreamReader(fileInputStream);
        } catch (IOException e) {
            //ловим ошибку
        }

        // System.out.println("Продолжаем исполнение: " + result);
    }

    public static int delit(Integer first, Integer second) {
        if (first == null || first < 0) {
            throw new RuntimeException("Был передан некорректный параметр");
        }
        return first / second;
    }

    public static int delitWithChecked(Integer first, Integer second) throws InvalidObjectException {
        if (first == null || first < 0) {
            throw new InvalidObjectException("Был передан некорректный параметр");
        }

        if (second == null) {
            throw new CustomException("Ошибка! Нет второго поля", new NullPointerException("Пустое поле"));
        }

        return first / second;
    }
}
