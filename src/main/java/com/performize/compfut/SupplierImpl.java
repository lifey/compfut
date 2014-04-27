package com.performize.compfut;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

/**
 * Created by life on 27/4/14.
 */
public class SupplierImpl<V> implements Supplier<V>{
    Callable<V> c;

    public SupplierImpl(Callable<V> c) {
        this.c = c;
    }

    @Override
    public V get() {
        V v = null;
        try {
            v = c.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return v;
    }
}
