package com.performize.compfut;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

/**
 * Created by life on 27/4/14.
 */
public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FakeHttpRequest req1 = new FakeHttpRequest(1000,false);
        Future<String> f1 = ForkJoinPool.commonPool().submit(req1);
        FakeHttpRequest req2 = new FakeHttpRequest(1200,true);
        Future<String> f2 = ForkJoinPool.commonPool().submit(req2);


        System.out.println(f1.get());
        System.out.println(f2.get());
    }
}
