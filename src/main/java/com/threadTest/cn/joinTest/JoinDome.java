package com.threadTest.cn.joinTest;

/**
 * join作用是让其他线程变为等待
 * yield()将导致线程从运行状态转到可运行状态
 */
public class JoinDome extends Thread{
    private int count=0;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            count++;
            System.out.println(Thread.currentThread().getName()+":"+count);
        }
    }

    public static void main(String[] args) throws Exception{
        JoinDome joinDome1 = new JoinDome();
        JoinDome joinDome2 = new JoinDome();
        JoinDome joinDome3 = new JoinDome();
        joinDome1.start();
        joinDome1.join();
        joinDome2.start();
        joinDome2.join();
        joinDome3.start();
    }
}
