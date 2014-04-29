package com.performize.compfut;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import static java.util.concurrent.CompletableFuture.supplyAsync;

/**
 * Created by life on 29/4/14.
 */
public class Util {
    public static boolean sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public static <V> CompletableFuture<V> convertFuture(Future<V> future) {
        CompletableFuture<V> brighterFuture = supplyAsync(() -> {
            try {
                return future.get();
            } catch (Exception e1) {
                throw new RuntimeException(e1);
            }
        });
        return brighterFuture;
    }
}
