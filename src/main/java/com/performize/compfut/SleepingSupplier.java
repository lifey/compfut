package com.performize.compfut;

import java.util.function.Supplier;

/**
 * Created by life on 27/4/14.
 */
public class SleepingSupplier extends FakeHttpRequest implements Supplier<String> {
    public SleepingSupplier(long period,boolean throwException) {
        super(period,throwException);
    }

    @Override
    public String get() {
        String s = null;
        try {
            s = call();
        } catch (Exception e) {
           throw new RuntimeException(e);
        }
        return s;
    }
}
