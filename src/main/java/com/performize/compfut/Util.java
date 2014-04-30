package com.performize.compfut;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.function.Function;

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
    public static<T> CompletableFuture<T> holdDownExceptionally(CompletableFuture<T>f, CountDownLatch latch) {
        return f.exceptionally((t) -> {
            try {
                latch.countDown();latch.await();
            } catch (Exception e) {
                throw new RuntimeException(t);
            }
            throw new RuntimeException(t);
        }).thenApply((r) -> {latch.countDown();latch.countDown();return r;});
    }

    public static <T,U> CompletableFuture<U> myApplytoEither(CompletableFuture<T> f1, CompletableFuture<T> f2,Function<? super T, U> fn)  {
        CountDownLatch sync = new CountDownLatch(2);
        CompletableFuture<T> f1be = holdDownExceptionally(f1,sync);
        CompletableFuture<T> f2be = holdDownExceptionally(f2,sync);
        return f1be.applyToEither(f2be,fn);
    }
}
