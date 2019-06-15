package com.threadTest.cn.lockTest;

import com.threadTest.cn.entity.Person;
import lombok.AllArgsConstructor;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 生产者
 * lock和synchronized类似 ，lock是手动开锁关锁
 * Lock 接口能被中断地获取锁 与 synchronized 不同，获取到锁的线程能够响应中断，
 * 当获取到的锁的线程被中断时，中断异常将会被抛出，同时锁会被释放。
 Lock 接口在指定的截止时间之前获取锁，如果截止时间到了依旧无法获取锁，则返回。
 Condition的功能类似于在传统的线程技术中的,Object.wait()和Object.notify()的功能,

 */
@AllArgsConstructor
public class IntThread extends Thread {
    private Person person;

    public void run() {
        int count = 0;
        while (true) {
            try {
                Lock lock = person.getLock();
                Condition condition = person.getCondition();
                lock.lock();
                if (person.getIsRead()) {
                    condition.await();
                }
                if (count == 0) {
                    person.setUserName("余胜军");
                    person.setUserSex("男");
                } else {
                    person.setUserName("小紅");
                    person.setUserSex("女");
                }
                count = (count + 1) % 2;
                person.setIsRead(true);
                condition.signal();
            } catch (Exception e) {
                System.out.println("put error");
            } finally {
                person.getLock().unlock();
            }
        }
    }

    public static void main(String[] args) {
        Person person = new Person();
        Thread thread1 = new IntThread(person);
        Thread thread2 = new OutThread(person);
        thread1.start();
        thread2.start();
    }
}
