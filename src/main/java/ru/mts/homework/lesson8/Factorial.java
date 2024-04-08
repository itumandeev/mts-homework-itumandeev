package ru.mts.homework.lesson8;

public class Factorial {
    int result = 1;
    int start = 1;

    public void calc() {
        result = result * start;
        start++;
    }

    public int getResult() {
        return result;
    }
}
