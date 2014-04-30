package com.performize.compfut.examples;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

import static com.performize.compfut.Util.convertFuture;
import static com.performize.compfut.Util.sleep;

/**
 * Created by life on 29/4/14.
 */
public class CompletableFutureFromFutureExample2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Future<Integer> future = ForkJoinPool.commonPool().submit(
                () -> {sleep(4000);return 42;});
        CompletableFuture<Integer> brighterFuture = convertFuture(future).thenApply((r) -> r * r);;
        System.out.println("I am here");
        System.out.println(brighterFuture.get());
    }

}
