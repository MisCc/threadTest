package com.threadTest.cn.stopThreadTest;

public class StopThread implements Runnable {
    private boolean falg = true;

    @Override
    public void run() {
        while (falg) {
            try {
                wait();
                System.out.println(Thread.currentThread().getName()+"线程等待。。。。。。。。。。");
            } catch (Exception e) {
                System.out.println(Thread.currentThread().getName()+"线程异常。。。。。。。。。。");
                stopThread();
            }
        }
    }

    private void stopThread() {
        falg = false;
        System.out.println(Thread.currentThread().getName()+"线程停止。。。。。。。。。。");
    }

    public static void main(String[] args) throws Exception{
        StopThread stopThread = new StopThread();
        Thread thread1= new Thread(stopThread,"one");
        Thread thread2 = new Thread(stopThread,"two");
        Thread thread3 = new Thread(stopThread,"three");
        thread1.start();
        thread2.start();
        thread3.start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("...");
            if (i==999){
                thread1.interrupt();
                thread2.interrupt();
                thread3.interrupt();
            }
        }
    }
}
