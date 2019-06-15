package com.threadTest.cn.waitAndNotifyTest;

import com.threadTest.cn.entity.Person;
import lombok.AllArgsConstructor;

/**
 * 生产者
 *
 * * 如果在非同步控制方法里调用这些方法，程序能通过编译，但运行的时候，将得到IllegalMonitorStateException异常
 * 如果对象调用了wait方法就会使持有该对象的线程把该对象的控制权交出去，然后处于等待状态。
 •如果对象调用了notify方法就会通知某个正在等待这个对象的控制权的线程可以继续运行。
 •如果对象调用了notifyAll方法就会通知所有等待这个对象控制权的线程继续运行。

 对于sleep()方法，我们首先要知道该方法是属于Thread类中的。而wait()方法，则是属于Object类中的
 在调用sleep()方法的过程中，线程不会释放对象锁
 当调用wait()方法的时候，线程会放弃对象锁，进入等待此对象的等待锁定池，只有针对此对象调用notify()方法后本线程才进入对象锁定池准备
 */
@AllArgsConstructor
public class IntThread extends Thread {
    private Person person;

    public void run(){
        int count = 0;
        while (true) {
            synchronized (person){
                if (person.getIsRead()){
                    try {
                        person.wait();
                    }catch (Exception e){

                    }
                }
            }
            if (count == 0) {
                person.setUserName("余胜军");
                person.setUserSex("男");
            } else {
                person.setUserName("小紅");
                person.setUserSex("女");
            }
            count = (count + 1) % 2;
            synchronized (person) {
                person.setIsRead(true);
                person.notify();
            }
        }
    }

    public static void main(String[] args) {
        Person person=new Person();
        Thread thread1=new IntThread(person);
        Thread thread2= new OutThread(person);
        thread1.start();
        thread2.start();
    }
}
