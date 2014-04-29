package com.performize.compfut.examples;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static com.performize.compfut.Util.sleep;
import static java.util.concurrent.CompletableFuture.supplyAsync;

/**
 * Created by life on 29/4/14.
 */
public class AnyOfExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {


        CompletableFuture<String> req1 = supplyAsync(() -> {
            sleep(2300);
            System.out.println("done req1");
            return "42";
        });
        CompletableFuture<String> req2 = supplyAsync(() -> {
            sleep(2100);
            System.out.println("done req2");
            return "43";
        });
        CompletableFuture<String> req3 = supplyAsync(() -> {
            sleep(2500);
            System.out.println("done req3");
            return "44";
        });

        CompletableFuture<Object> fastest = CompletableFuture.anyOf(req1, req2, req3);
        System.out.println((String) fastest.get());


        sleep(11000);
    }
}
