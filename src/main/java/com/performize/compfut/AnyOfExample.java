package com.performize.compfut;

import java.util.concurrent.CompletableFuture;

/**
 * Created by life on 27/4/14.
 */
public class AnyOfExample {
    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<String> req1 = CompletableFuture.supplyAsync(new SupplierImpl(new FakeHttpRequest(2000,false)));
        CompletableFuture<String> req2 = CompletableFuture.supplyAsync(new SupplierImpl(new FakeHttpRequest(2500,false)));
        CompletableFuture<String> req3 = CompletableFuture.supplyAsync(new SupplierImpl(new FakeHttpRequest(1000,true)));

       CompletableFuture<Object> fastest = CompletableFuture.anyOf(req1,req2,req3);
       fastest.whenComplete((qs, t) -> System.out.println(qs +" " + t)) ;
        fastest.whenComplete((qs, t) -> System.out.println(qs +" " + t)) ;
        req3.exceptionally((e) -> e.getMessage()).thenAccept((qs)-> System.out.println(qs));

        Thread.sleep(1100);
    }
}
