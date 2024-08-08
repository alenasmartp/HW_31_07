package org.example;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class HomeWorkCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> callable = () -> waitSomeTime();

        FutureTask<Integer> ft1 = new FutureTask<>(callable);
        FutureTask<Integer> ft2 = new FutureTask<>(callable);
        new Thread(ft1).start();
        new Thread(ft2).start();
        System.out.println("result is: " + (ft1.get() + ft2.get()));

    }
    public static int waitSomeTime()
    {
        int time = new Random().nextInt(1000);
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return time;
    }
}
