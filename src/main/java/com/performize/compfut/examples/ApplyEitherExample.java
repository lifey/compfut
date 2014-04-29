package com.performize.compfut.examples;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static com.performize.compfut.Util.sleep;
import static java.util.concurrent.CompletableFuture.supplyAsync;

/**
 * Created by life on 29/4/14.
 */
public class ApplyEitherExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> f1 = supplyAsync(
                () -> {sleep(2300);
                    System.out.println("done f1");return 42;});
        CompletableFuture<Integer> f2 = supplyAsync(
                () -> {sleep(2200);if (true) throw new RuntimeException();return 43;});

        CompletableFuture<Integer> f3 = f1.applyToEither(f2,(r) -> r * r);
    //    CompletableFuture<Integer> f4 = f3.thenCompose(
      //          (v) -> supplyAsync(() -> {System.out.println("start f4");sleep(2100);return v+1;}))  ;
        System.out.println(f3.get());

    }

}
