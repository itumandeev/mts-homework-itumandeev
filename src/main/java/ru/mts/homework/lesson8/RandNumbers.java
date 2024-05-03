package ru.mts.homework.lesson8;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;

public class RandNumbers implements Callable<Long> {

    private final int listSize;

    RandNumbers(int listSize) {

        this.listSize = listSize;
    }

    @Override
    public Long call() throws Exception {
        long start = System.currentTimeMillis();
        List<Integer> list = new ArrayList<>(listSize);
        for (int i = 0; i < listSize; i++) {
            list.add(new Random().nextInt(10000));
        }
        return (System.currentTimeMillis() - start);
    }
}
