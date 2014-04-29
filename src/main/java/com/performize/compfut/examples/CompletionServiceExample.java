package com.performize.compfut.examples;

import java.util.concurrent.*;
import static com.performize.compfut.Util.*;

/**
 * Created by life on 29/4/14.
 */
public class CompletionServiceExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService e = Executors.newFixedThreadPool(10);
        Executors.newSingleThreadExecutor() ;

        CompletionService<Integer> completionService = new ExecutorCompletionService<>(e);

        completionService.submit(() -> {sleep(10000);return 42;})  ;
        Future<Integer> future    = completionService.take();
        System.out.println("taken");

        System.out.println(future.get());
        e.shutdown();

    }

}
