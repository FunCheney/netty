package com.fc.test;

import java.util.concurrent.*;

public class CompletableFutureTest2 {
    static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
            1,
            1,
            20,
            TimeUnit.SECONDS,
            new SynchronousQueue<>(),
            new ThreadPoolExecutor.CallerRunsPolicy());
    public static void main(String[] args) {
        CompletableFuture.runAsync(() ->{
            System.out.println("T1:洗水壶...");
        }, threadPoolExecutor);
    }
}
