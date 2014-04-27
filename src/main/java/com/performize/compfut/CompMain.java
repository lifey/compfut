package com.performize.compfut;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Created by life on 27/4/14.
 */
public class CompMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> req1 = CompletableFuture.supplyAsync(new SupplierImpl(new FakeHttpRequest(2000,false)));
        CompletableFuture<String> req2 = CompletableFuture.supplyAsync(new SupplierImpl(new FakeHttpRequest(2000,true)));

        req2.exceptionally(ex -> {System.out.println("we have a problem"); return ex.getMessage();});
        req1.exceptionally(ex -> {System.out.println("we have a problem"); return ex.getMessage();});
     //   CompletableFuture<Void> req3 =  req1.acceptEitherAsync(req2, (res) -> System.out.println(res));
     //   req3.
     //           whenComplete((qs, t) -> System.out.println(qs)).
     //           thenRun(() -> System.exit(0));
      //  s.complete("walla");
       // System.out.println(s.get());
        Thread.sleep(1100);
    }
}
