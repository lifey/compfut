package com.performize.compfut.examples;

import static com.performize.compfut.Util.*;


import java.util.concurrent.*;

/**
 * Created by life on 29/4/14.
 */
public class FutureExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService e = Executors.newSingleThreadExecutor();

        Future<Integer> future = e.submit(() -> {sleep(10000);return 42;});
        // do something useful ?
        System.out.println(future.get());

    }

}
