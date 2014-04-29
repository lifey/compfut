package com.performize.compfut.filechannel;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import static com.performize.compfut.Util.sleep;
/**
 * Created by life on 28/4/14.
 */
public class UseAsyncFileChannel {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        AsynchronousFileChannel afc = AsynchronousFileChannel.open(Paths.get("/Users/life/lifey40Video.avi"), StandardOpenOption.READ)   ;
        System.out.println(afc.getClass());
        ByteBuffer r = ByteBuffer.allocate(500*1024*1024) ;
        sleep(20000);
        System.out.println("Now");
        long s = System.currentTimeMillis();
        afc.read(r,0,r,new CompletionHandler<Integer, Object>() {
            @Override
            public void completed(Integer result, Object attachment) {
                System.out.println(System.currentTimeMillis()-s);
                System.out.println("completed");
                sleep(100000);
            }

            @Override
            public void failed(Throwable exc, Object attachment) {

            }
        });
       // Future<Integer> a = afc.read(r,10*1024*1024);

      //  int i = a.get();

        sleep(1000000);
    }

}
