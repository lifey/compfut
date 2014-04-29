package com.performize.compfut.filechannel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

import static com.performize.compfut.Util.sleep;

/**
 * Created by life on 29/4/14.
 */
public class UseAsyncFileChannelCompletableFuture {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        AsynchronousFileChannel afc = AsynchronousFileChannel.open(Paths.get("/Users/life/lifey40Video.avi"), StandardOpenOption.READ)   ;
        System.out.println(afc.getClass());
        ByteBuffer r = ByteBuffer.allocate(500*1024*1024) ;
        CompletableFuture<Integer> cf = new CompletableFuture<>();
      //  sleep(20000);
        System.out.println("Now");
        long s = System.currentTimeMillis();
        Future<Integer> c = afc.read(r,0);
        // Future<Integer> a = afc.read(r,10*1024*1024);

        CompletableFuture<Integer> cf2 = cf.thenApplyAsync((res) -> {
            sleep(1000);
            System.out.println("mush");
            return res;
        }, ForkJoinPool.commonPool());
        System.out.println("mish"+cf2.get());
        //  int i = a.get();

        sleep(1000000);
    }
}
