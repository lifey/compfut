package com.performize.compfut.examples;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static com.performize.compfut.Util.sleep;
import static java.util.concurrent.CompletableFuture.supplyAsync;

/**
 * Created by life on 29/4/14.
 */
public class ApplyEitherExample {

    public static void main(String[] args)  {
        CompletableFuture<Integer> f1 = supplyAsync(
                () -> {sleep(2300);
                    System.out.println("done f1");return 42;});
        CompletableFuture<Integer> f2 = supplyAsync(
                () -> {sleep(2200);return 43;});

        CompletableFuture<Integer> f3 = f1.applyToEither(f2,(r) -> r * r);
      System.out.println(f3.join());

    }

}
