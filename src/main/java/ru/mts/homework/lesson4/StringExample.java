package ru.mts.homework.lesson4;

import java.util.StringJoiner;

public class StringExample {
    public static void main(String[] args) {
        String first = "Первая строка";
        String third = "первая строка";


        //System.out.println(first.equals(third));
        //System.out.println(first.equalsIgnoreCase(third));
        System.out.println(first.substring(5));
        System.out.println(first.substring(5, 7));

        String second = "Вторая строка";
        String withNew = new String("Первая строка");

        //System.out.println("Строка без переменной " + " вторая строка");
        second.length();

        String name = "John";

        String message = "Hello %s %d %f";
        System.out.println(String.format(message, name, 123, 123F));

        StringBuilder stringBuilder = new StringBuilder()
                .append("Первое значение")
                .append("Второе значение")
                .append("Третье значение")
                .append("Четвертое значение")
                .append("Пятое значение");

        if (message.length() > 10) {
            stringBuilder.append("Финал");
        } else {
            stringBuilder.append("Шестое значение")
                    .append("Финал");
        }

        //System.out.println(stringBuilder.toString());

        StringJoiner stringJoiner = new StringJoiner(" -- ", "Это ", " я ввел")
                .add("Первое значение")
                .add("Второе значение")
                .add("Третье значение")
                .add("Четвертое значение")
                .add("Пятое значение");

        //System.out.println(stringJoiner.toString());
    }
}
