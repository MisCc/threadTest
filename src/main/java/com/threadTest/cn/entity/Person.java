package com.threadTest.cn.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String userSex;
    private String userName;
    private Boolean isRead = false;
    private Lock lock=new ReentrantLock();
    private Condition condition = lock.newCondition();
}
