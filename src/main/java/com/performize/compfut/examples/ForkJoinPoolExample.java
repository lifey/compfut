package com.performize.compfut.examples;

import java.util.concurrent.*;

import static com.performize.compfut.Util.sleep;

/**
 * Created by life on 29/4/14.
 */
public class ForkJoinPoolExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinTask<Integer> task = ForkJoinPool.commonPool().
                submit(() -> {
                    while(!sleep(1000));
                    System.out.printf("done");
                    return 42;
                });

        sleep(10);
        task.complete(43);
        System.out.println(task.get());
        task.complete(44);
        System.out.println(task.get());
        sleep(2000);
        System.out.println(task.get());
    }

}
