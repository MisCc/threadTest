package com.threadTest.cn.atomicITest;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * atomic类具备原子性
 */
public class AtomicIntegerTest extends Thread {

    private static AtomicInteger count = new AtomicInteger(0);

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            count.incrementAndGet();
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        AtomicIntegerTest[] atomics = new AtomicIntegerTest[100];
        for (int i = 0; i < atomics.length; i++) {
            atomics[i] = new AtomicIntegerTest();
        }
        for (AtomicIntegerTest atomic : atomics) {
            atomic.start();
        }
    }
}
