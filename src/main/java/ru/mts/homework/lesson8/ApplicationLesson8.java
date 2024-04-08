package ru.mts.homework.lesson8;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class ApplicationLesson8 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //Параллельная проверка на простоту чисел
        int listSize = 10;
        List<Integer> result = new ArrayList<>(listSize);
        List<Integer> list = new ArrayList<>(listSize);
        for (int i = 0; i < listSize; i++) {
            list.add(new Random().nextInt(15));
        }

        System.out.println(list);

        int threadNum = 2;
        int chunkSize = listSize / threadNum;

        ExecutorService exec = Executors.newFixedThreadPool(threadNum);
        Future<List<Integer>>[] futures = new Future[2];
        for (int i = 0; i < threadNum; i++) {
            int startIndex = i * chunkSize;
            int endIndex = (i + 1) * chunkSize;
            Future<List<Integer>> future = exec.submit(new TaskIsPrime(list, startIndex, endIndex));
            futures[i] = future;
        }
        for (Future<List<Integer>> f : futures) {
            result.addAll(f.get());
        }
        System.out.println("Multi thread max: " + result);
        System.out.println("Single thread max: " + new TaskIsPrime(list, 0, listSize).call());


        //Генерация случайных чисел
        long start = System.currentTimeMillis();
        List<Integer> list3 = new ArrayList<>(60000);
        for (int i = 0; i < 60000; i++) {
            list3.add(new Random().nextInt(10000));
        }
        System.out.println("Генерация в 1 потока. Время " + (System.currentTimeMillis() - start));

        Future<Long>[] futuresRndmNum = new Future[2];
        for (int i = 0; i < threadNum; i++) {
            Future<Long> future = exec.submit(new RandNumbers(30000));
            futuresRndmNum[i] = future;
        }
        Long time = 0L;
        for (Future<Long> f : futuresRndmNum) {
            time += f.get();
        }
        System.out.println("Генерация в "+threadNum+" потока. Время " + time);

//        //Параллельное вычисление факториала:
//        Factorial fctr = new Factorial();
//        for (int i = 0; i < 10; i++) {
//            exec.submit(() -> fctr.calc());
//        }
//        exec.shutdown();
//        exec.awaitTermination(Long.MAX_VALUE, TimeUnit.HOURS);
//        System.out.println("значение gth " + fctr.getResult());

        //Потокобезопасный счетчик:
        /*Counter countClass = new Counter();
        for (int i = 0; i < 1000; i++){
            exec.submit(()->countClass.increment());
        }
        System.out.println("Значение счетчика Класса " + countClass.getValue());*/
        AtomicInteger counterAtom = new AtomicInteger(0);
        IntStream.range(0, 1000).forEach(i -> exec.submit(counterAtom::incrementAndGet));
        exec.shutdown();
        exec.awaitTermination(Long.MAX_VALUE, TimeUnit.HOURS);
        System.out.println("Значение счетчика переменной " + counterAtom.get());
    }
}