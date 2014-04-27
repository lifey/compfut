package com.performize.compfut;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Created by life on 27/4/14.
 */
public class CompMainAfterCompletion {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> s = CompletableFuture.supplyAsync(new SupplierImpl(new FakeHttpRequest(2000,true)));
        Thread.sleep(10000);
        System.out.println("now");
        s.
                whenComplete((qs, t) -> System.out.println(qs)).
                thenRun(() -> System.exit(0));
      //  s.complete("walla");
       // System.out.println(s.get());
        Thread.sleep(100000);
    }
}
