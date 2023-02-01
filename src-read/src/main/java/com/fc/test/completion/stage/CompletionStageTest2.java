package com.fc.test.completion.stage;

import java.util.concurrent.CompletableFuture;

public class CompletionStageTest2 {
    public static void main(String[] args) {
        CompletableFuture<Void> fo = CompletableFuture.runAsync(() -> {
            System.out.println("hello");
        });




    }
}
