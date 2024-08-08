package org.example;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;


public class PoolTester {
    public static void main(String[] args) throws InterruptedException {
        Runnable r = () -> {
            int time = new Random().nextInt(500);
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("time: " + time);
        };

        var pool = ForkJoinPool.commonPool();
        IntStream.range(0, 5)
                .forEach(
                        i -> pool.submit(r)
                );

        pool.awaitTermination(4, TimeUnit.SECONDS);
    }
}
