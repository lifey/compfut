package com.performize.compfut.examples;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.function.Function;

import static com.performize.compfut.Util.*;

import static java.util.concurrent.CompletableFuture.supplyAsync;

/**
 * Created by life on 30/4/14.
 */
public class ApplyToEitherWithExceptions {


    public static void main(String[] args) {


        CompletableFuture<Integer> f1 = supplyAsync(
                () -> {
                    sleep(2200);
                    if (false) throw new RuntimeException();
                    System.out.println("done f1");
                    return 42;
                }
        );
        CompletableFuture<Integer> f2 = supplyAsync(
                () -> {
                    sleep(2100);
                    if (false) throw new RuntimeException();
                    return 43;
                });

        CompletableFuture<Integer> f3 = myApplytoEither(f1, f2, (r) -> r * r);
        //    CompletableFuture<Integer> f4 = f3.thenCompose(
        //          (v) -> supplyAsync(() -> {System.out.println("start f4");sleep(2100);return v+1;}))  ;
        System.out.println(f3.join());

    }
}
