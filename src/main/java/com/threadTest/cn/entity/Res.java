package com.threadTest.cn.entity;

import lombok.Data;

@Data
public class Res {
    private Integer count;
    private ThreadLocal<Integer> threadLocal= new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };
    public Integer getNum() {
        int count = threadLocal.get() + 1;
        threadLocal.set(count);
        return count;
    }

}
