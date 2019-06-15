package com.threadTest.cn.volatileTest;

/**
 * 仅靠volatile不能保证线程的安全性。（原子性）
 ①volatile轻量级，只能修饰变量。synchronized重量级，还可修饰方法
 ②volatile只能保证数据的可见性，不能用来同步，因为多个线程并发访问volatile修饰的变量不会阻塞。
 synchronized不仅保证可见性，而且还保证原子性，因为，只有获得了锁的线程才能进入临界区，
 从而保证临界区中的所有语句都全部执行。多个线程争抢synchronized锁对象时，会出现阻塞。

 */
public class VolatileNoAtomic extends Thread {

    private static volatile Integer count = 0;

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            count++;
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        VolatileNoAtomic[] atomics = new VolatileNoAtomic[100];
        for (int i = 0; i < atomics.length; i++) {
            atomics[i] = new VolatileNoAtomic();
        }
        for (VolatileNoAtomic atomic : atomics) {
            atomic.start();
        }
    }
}
