package ru.mts.homework.lesson8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

public class TaskIsPrime implements Callable<List<Integer>> {
    private List<Integer> list = new ArrayList<>();
    private final int start;
    private final int end;

    public TaskIsPrime(List<Integer> list, int start, int end) {
        this.list = list;
        this.start = start;
        this.end = end;
    }

    @Override
    public List<Integer> call() {
        List<Integer> result = new ArrayList<>();
        for (int i = start; i < end; i++) {
            if (isPrime(list.get(i))) {
                result.add(list.get(i));
            }
        }
        return result;
    }

    public boolean isPrime(int number) {
        if (number <= 1) {
            return false; // числа 0 и 1 не являются простыми
        }
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false; // если делится без остатка нацело, то не является простым
            }
        }
        return true; // если после проверки все циклы пройдены успешно, то число простое
    }
}
