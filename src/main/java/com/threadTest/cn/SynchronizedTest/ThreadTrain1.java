package com.threadTest.cn.SynchronizedTest;

/**
 * 同步代码块 自定义锁，
 * 同步方法 使用this锁，
 * 同步静态方法 使用当前类的字节码文件作为锁
 */
public class ThreadTrain1 implements Runnable{
    private final static Integer max=1000;
    private int trainCount=max;

    public void run() {
            while (trainCount>0){
                sales();
        }
    }

    /*同步函数使用this锁*/
    private synchronized void sales() {
        if (trainCount>0){
            trainCount--;
            System.out.println(Thread.currentThread().getName()+"买了第"+(max-trainCount)+"张票");
        }
    }

    public static void main(String[] args) {
        ThreadTrain1 train = new ThreadTrain1();
        Thread thread1=new Thread(train,"线程一");
        Thread thread2=new Thread(train,"线程二");
        thread1.start();
        thread2.start();
    }
}
