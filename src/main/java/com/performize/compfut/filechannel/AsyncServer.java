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
public class AsyncServer {
    public static void main(String[] args) throws Exception {
        final AsynchronousServerSocketChannel ssc =
                AsynchronousServerSocketChannel.open().bind(new InetSocketAddress("localhost", 9999));
        Future<AsynchronousSocketChannel> accepted = ssc.accept();
        AsynchronousSocketChannel sc2 = accepted.get();

        ByteBuffer bb = ByteBuffer.allocateDirect(4096);
        Future<Integer> readFuture = sc2.read(bb);
    }
}
