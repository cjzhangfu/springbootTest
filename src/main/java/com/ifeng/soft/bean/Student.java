package com.ifeng.soft.bean;

/**
 * @author zhangfu
 * @description TODO
 * @date 2022/3/25 6:16 下午
 **/
public class Student implements Person{
    @Override
    public void rentingHouse() {
        System.out.println("我是学生需要租房");
    }
}
