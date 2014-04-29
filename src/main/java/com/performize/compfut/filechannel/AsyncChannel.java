package com.performize.compfut.filechannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.Future;

/**
 * Created by life on 29/4/14.
 */
public class AsyncChannel {
    public static void main(String[] args) throws Exception {
        AsynchronousSocketChannel sc = AsynchronousSocketChannel.open();
        System.out.println(sc.getClass());
        Future connected = sc.connect(new InetSocketAddress("localhost", 9999));
// later ensure we are connected.
        connected.get();

        ByteBuffer bb = ByteBuffer.allocateDirect(4096);
// populate bb
        Future<Integer> writeFuture = sc.write(bb);
    }
}
