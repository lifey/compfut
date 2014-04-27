package com.performize.compfut;

import java.util.concurrent.Callable;

/**
 * Created by life on 27/4/14.
 */
public class FakeHttpRequest implements Callable<String> {
    public static class FakeRequestException extends RuntimeException{};
    long period;
    boolean throwException ;

    public FakeHttpRequest(long period,boolean throwException) {
        this.period = period;
        this.throwException = throwException;
    }

    @Override
    public String call() throws Exception {
        try {
            Thread.sleep(period);
        } catch (InterruptedException e) {
            return "I was interrupted" + e;
        }
        if (throwException) throw new FakeRequestException();

        return "I have been sleeping for " + period + "ms. It was fun";
    }
}
