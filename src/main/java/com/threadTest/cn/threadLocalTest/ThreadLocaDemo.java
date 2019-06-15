package com.threadTest.cn.threadLocalTest;

import com.threadTest.cn.entity.Res;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
/**
 　当使用ThreadLocal维护变量时，ThreadLocal为每个使用该变量的线程提供独立的变量副本
 ThreadLocal类接口很简单，只有4个方法，我们先来了解一下：
 •	void set(Object value)设置当前线程的线程局部变量的值。
 •	public Object get()该方法返回当前线程所对应的线程局部变量。
 •	public void remove()将当前线程局部变量的值删除，
 •	protected Object initialValue()返回该线程局部变量的初始值
**************ThreadLocal实现原理****************
    ThreadLoca通过map集合
    Map.put(“当前线程”,值)；

 */
public class ThreadLocaDemo extends Thread {
    private Res res;

    @Override
    public void run() {
        for (int i = 0; i <5 ; i++) {
            System.out.println(Thread.currentThread().getName()+":"+res.getNum());
        }
    }

    public static void main(String[] args) {
        Res res = new Res();
        ThreadLocaDemo threadLocaDemo1 = new ThreadLocaDemo(res);
        ThreadLocaDemo threadLocaDemo2 = new ThreadLocaDemo(res);
        ThreadLocaDemo threadLocaDemo3 = new ThreadLocaDemo(res);
        threadLocaDemo1.start();
        threadLocaDemo2.start();
        threadLocaDemo3.start();
    }
}
