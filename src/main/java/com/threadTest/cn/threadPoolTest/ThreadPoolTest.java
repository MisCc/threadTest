package com.threadTest.cn.threadPoolTest;

import lombok.Data;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * newCachedThreadPool创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
 * newFixedThreadPool 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
 * newScheduledThreadPool 创建一个定长线程池，支持定时及周期性任务执行。
 * newSingleThreadExecutor 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
 */
@Data
public class ThreadPoolTest {

    private ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
    private ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
    private ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);
    private ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

    public void cachedThreadPoolRun(){
        for (int i = 0; i < 5; i++) {
            int index=i;
            cachedThreadPool.execute(()->{
                System.out.println(Thread.currentThread().getName()+":"+index);
            });
        }
    }
    public void fixedThreadPoolRun(){
        for (int i = 0; i < 5; i++) {
            int index=i;
            fixedThreadPool.execute(()->{
                System.out.println(Thread.currentThread().getName()+":"+index);
            });
        }
    }
    public void scheduledThreadPoolRun(){
        for (int i = 0; i < 5; i++) {
            int index=i;
            scheduledThreadPool.schedule(new Runnable() {
                public void run() {
                    System.out.println(Thread.currentThread().getName()+":"+index);
                }
            }, 3, TimeUnit.SECONDS);

        }
    }
    public void singleThreadExecutorRun(){
        for (int i = 0; i < 5; i++) {
            int index=i;
            singleThreadExecutor.execute(()->{
                System.out.println(Thread.currentThread().getName()+":"+index);
            });
        }
    }

    public void runing(int i){
        switch (i){
            case 1:this.cachedThreadPoolRun();break;
            case 2:this.fixedThreadPoolRun();break;
            case 3:this.scheduledThreadPoolRun();break;
            default:this.singleThreadExecutorRun();
        }
    }
    public static void main(String[] args) {
        ThreadPoolTest test = new ThreadPoolTest();
        test.runing(4);
    }
}
