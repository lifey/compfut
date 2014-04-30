package com.performize.compfut.examples;

import javax.swing.plaf.SeparatorUI;
import java.util.concurrent.CompletableFuture;

import static com.performize.compfut.Util.sleep;
import static java.util.concurrent.CompletableFuture.*;

/**
 * Created by life on 30/4/14.
 */
public class CFFromThinAir {
    public static void main(String[] args) {
        CompletableFuture<Integer> a= new CompletableFuture<>();

        CompletableFuture<Integer> b = a.thenApplyAsync((r) -> {
            System.out.println("kuku " + Thread.currentThread().getName());
            sleep(1000);
            return r * r;
        });
        CompletableFuture<Void> f = runAsync(
                () -> {
                    try {
                        long st = System.currentTimeMillis();
                        System.out.println("runAsync"+ Thread.currentThread().getName());
                        int x = b.join();
                        System.out.println("val=" + x + " TOOK:" + (System.currentTimeMillis() - st));
                    } catch (Throwable t) {
                        System.out.println("exception");
                        t.printStackTrace();
                        throw t;
                    }

                }
        );
        sleep(1235);
        a.complete(5);
        a.completeExceptionally(new IndexOutOfBoundsException());
      //  System.out.println(b.join());
        sleep(10000);


    }
}
