package com.jiaolin.entity;

/**
 * @author johnny
 * @Classname Test3
 * @Description
 * @Date 2022/3/22 4:06 下午
 */

class Student{
    Student(){
        System.out.println("Student-Constructor");
    }
    {
        System.out.println("Student 构造块");
    }
    static {
        System.out.println("Student");
    }
}

public class Test3 {

    {
        System.out.println("Test3 构造块");
    }

    static {
        System.out.println("Test3");
    }

    Test3(){
        System.out.println("Test3-Constructor");
    }

    public static void main(String[] args) {
        System.out.println("启动");
        new Student();
        System.out.println("-------我是1分界线---------");
        new Student();
        System.out.println("-------我是2分界线---------");
        new Test3();
    }
    // 静态代码块>构造块>构造方法
}
