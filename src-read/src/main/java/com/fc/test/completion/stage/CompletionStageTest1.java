package com.fc.test.completion.stage;

import java.util.concurrent.CompletableFuture;

public class CompletionStageTest1 {
    public static void main(String[] args) {
        CompletableFuture<String> f0 = CompletableFuture.supplyAsync(  //supplyAsync 开启一个异步流程
                () -> "hello world" // ①
                ).thenApply(s -> s + " QQ") // ②
                .thenApply(String::toUpperCase); // ③
        System.out.println(f0.join());


    }
}
