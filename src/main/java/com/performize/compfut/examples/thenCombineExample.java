package com.performize.compfut.examples;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static com.performize.compfut.Util.sleep;
import static java.util.concurrent.CompletableFuture.supplyAsync;

/**
 * Created by life on 29/4/14.
 */
public class thenCombineExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> f1 = supplyAsync(
                () -> {sleep(2100);if (false) throw new RuntimeException();return 42;});
        CompletableFuture<Integer> f2 = supplyAsync(
                () -> {sleep(2100);if (false) throw new RuntimeException();return 55;});


        CompletableFuture<Integer> f3 = f1.thenCombine(f2,
                (r1,r2) -> r1+r2)  ;
        CompletableFuture<Void> f4 = f1.thenAcceptBoth(f2,
                (r1, r2) -> System.out.println(r1 + r2))  ;
        System.out.println(f3.get());

    }

}
