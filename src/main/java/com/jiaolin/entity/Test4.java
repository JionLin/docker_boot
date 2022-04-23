package com.jiaolin.entity;/**
 * @author johnny
 * @Classname Test4
 * @Description
 * @Date 2022/3/22 4:09 下午
 */
public class Test4 {
    {
        System.out.println("我是构造块");
    }

    public Test4() {
        System.out.println("我是构造方法");
    }

    static public int h1 = 12;
    static {
        System.out.println("我是静态块");
    }


    public int h2 = 13;

    static {
        System.out.println(h1);
        Test4 m3 = new Test4();
        System.out.println(h1);
        System.out.println(m3.h2);
        System.out.println(m3.h1);
        print();
    }

    public static void print() {
        System.out.println("已调用静态方法");
    }

    public static void main(String args[]) {
        Test4 m1 = new Test4();
        Test4 m2 = new Test4();
        {
            String info = "床前明月光";
            System.out.println(info);
        }
        String info = "一枝红杏出墙来";
        System.out.println(info);
    }
}