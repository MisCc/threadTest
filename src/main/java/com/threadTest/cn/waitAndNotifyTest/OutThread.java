package com.threadTest.cn.waitAndNotifyTest;

import com.threadTest.cn.entity.Person;
import lombok.AllArgsConstructor;

/**
 消费者
 */
@AllArgsConstructor
public class OutThread extends Thread {

    private Person person;

    public void run() {
        while (true) {
            synchronized (person){
                if (!person.getIsRead()){
                    try {
                        person.wait();
                    }catch (Exception e){

                    }
                }
            }
            System.out.println(person.getUserName() + "--" + person.getUserSex());
            synchronized (person) {
                person.setIsRead(false);
                person.notify();
            }
        }
    }
}
