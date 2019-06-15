package com.threadTest.cn.lockTest;

import com.threadTest.cn.entity.Person;
import lombok.AllArgsConstructor;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 消费者
 */
@AllArgsConstructor
public class OutThread extends Thread {

    private Person person;

    public void run() {
        while (true) {
            try {
                Lock lock = person.getLock();
                Condition condition = person.getCondition();
                lock.lock();
                if (!person.getIsRead()) {
                    condition.await();
                }
                System.out.println(person.getUserName() + "--" + person.getUserSex());
                person.setIsRead(false);
                condition.signal();
            } catch (Exception e) {
                System.out.println("out error");
            } finally {
                person.getLock().unlock();
            }
        }
    }
}
