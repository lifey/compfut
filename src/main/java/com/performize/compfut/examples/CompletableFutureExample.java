package com.performize.compfut.examples;


import java.util.concurrent.CompletableFuture;
import static java.util.concurrent.CompletableFuture.*;
import java.util.concurrent.ExecutionException;

import static com.performize.compfut.Util.*;

/**
 * Created by life on 29/4/14.
 */
public class CompletableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> f = supplyAsync(
                () -> {sleep(10000);if (false) throw new RuntimeException();return 42;}
        );
        CompletableFuture<Integer> f2 = f.thenApply((r) -> r*r);
        CompletableFuture<Void> f3 = f.thenAccept((r) -> {
            System.out.println("completed" + r);});
        System.out.println(f.getNumberOfDependents());

        System.out.println(f2.get());
    }
}
