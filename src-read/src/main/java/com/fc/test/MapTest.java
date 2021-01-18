package com.fc.test;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author Fchen
 * @Description TODO
 * @CreateTime 2021-01-18 14:36:00
 */
public class MapTest {
    public static void main(String[] args) {
        ConcurrentHashMap hashMap = CompletableFutureTest.hashMap;
        System.out.println(hashMap);
        hashMap.put("1", 1);
        System.out.println(CompletableFutureTest.hashMap);
    }
}
