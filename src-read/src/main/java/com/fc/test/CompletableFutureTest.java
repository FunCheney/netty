package com.fc.test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;

/**
 * @author Fchen
 * @date 2021/1/6 3:24 下午
 * @desc 测试类
 */
public class CompletableFutureTest {

    public static ConcurrentHashMap hashMap = new ConcurrentHashMap<>();
    static {
        hashMap.put("1", 0);
        hashMap.put("2", 0);
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> runAsync = CompletableFuture.runAsync(() -> System.out.println(123));

        CompletableFuture<Integer> supplyAsync = CompletableFuture.supplyAsync(() -> 100)
                .thenApply(i -> i * 10)
                .thenApplyAsync(i -> i + 1000);
        System.out.println(supplyAsync.get());
    }
}
