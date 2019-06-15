package com.threadTest.cn.volatileTest;

/**
 * Volatile 关键字的作用是变量在多个线程之间可见
 */
public class ThreadVolatileDemo extends Thread {

    public volatile  boolean flag = true;

    public void setRuning(boolean flag) {
        this.flag = flag;
    }

   @Override
   public void run() {
       System.out.println("开始执行子线程....");
       while (flag) {
          // System.out.println("runing................,flag=" + flag);  加了这个线程变量会更新
       }
       System.out.println("线程停止");
   }

    public static void main(String[] args) throws Exception {
        ThreadVolatileDemo threadVolatileDemo = new ThreadVolatileDemo();
        threadVolatileDemo.start();
        Thread.sleep(3000);
        threadVolatileDemo.setRuning(false);
        System.out.println("flag 已经设置成false");
        Thread.sleep(1000);
        System.out.println(threadVolatileDemo.flag);

    }
}
