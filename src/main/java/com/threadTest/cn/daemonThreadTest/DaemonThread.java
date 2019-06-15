package com.threadTest.cn.daemonThreadTest;

/**
 * Java中有两种线程，一种是用户线程，另一种是守护线程。
 当进程不存在或主线程停止，守护线程也会被停止。
 使用setDaemon(true)方法设置为守护线程
 */
public class DaemonThread {

    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            while (true){
                System.out.println("我是守护线程。。。。。。。。");
            }
        });
        thread.setDaemon(true);
        thread.start();
       /* for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
        System.out.println("主线程结束！！！！！！！！！！！！！！");
    }
}
