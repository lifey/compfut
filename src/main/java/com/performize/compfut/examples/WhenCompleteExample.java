package com.performize.compfut.examples;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static com.performize.compfut.Util.sleep;
import static java.util.concurrent.CompletableFuture.supplyAsync;

/**
 * Created by life on 29/4/14.
 */
public class WhenCompleteExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> f = supplyAsync(
                () -> {sleep(3000);if (true) throw new RuntimeException(); return 42;}
        );
        CompletableFuture<Integer> f2 = f.handle((res, throwable) -> (throwable == null) ? res * res : 2);
        CompletableFuture<Integer> f3 = f.whenComplete((res, throwable) -> {System.out.println("done");});
        System.out.println(f2.get());
        System.out.println(f3.get());

    }
}
