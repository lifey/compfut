package com.performize.compfut.examples;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static com.performize.compfut.Util.sleep;
import static java.util.concurrent.CompletableFuture.supplyAsync;

/**
 * Created by life on 29/4/14.
 */
public class thenComposeExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> f1 = supplyAsync(
                () -> {sleep(2100);if (false) throw new RuntimeException();return 42;});



        CompletableFuture<Integer> f2 = f1.thenCompose(
                (v) -> supplyAsync(() -> {
                    System.out.println("start f2");sleep(2100);return v+42;}))  ;
        System.out.println(f2.get());

    }

}
