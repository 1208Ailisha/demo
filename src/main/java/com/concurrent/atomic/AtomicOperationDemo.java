package com.concurrent.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

//http://blog.csdn.net/bigtree_3721/article/details/51296064
public class AtomicOperationDemo {
    //static Integer count = new Integer(0);
    static AtomicInteger count = new AtomicInteger(0);

    public static class AddThread implements Runnable {
        public void run() {
            for (int k = 0; k < 1000; k++) {
                //count++;
                count.incrementAndGet();
            }
        }
    }

    public static void AtomicIntShow() {
        System.out.println("AtomicIntShow() enter");
        ExecutorService threadpool = Executors.newFixedThreadPool(10);

        for (int k = 0; k < 100; k++) {
            threadpool.submit(new AddThread());
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("result of acumulated sum=" + count);
        threadpool.shutdown();
        System.out.println("AtomicIntShow() exit");
        return;
    }

    public static void main(String[] args) {
        //AtomicOperationDemo.AtomicIntShow();  
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        Long h = 2L;

        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(c == (a + b));
        System.out.println(c.equals(a + b));
        System.out.println(g == (a + b));
        System.out.println(g.equals(a + b));
        System.out.println(g.equals(a + h));
        
       /*
       1）对于==，如果作用于基本数据类型的变量，则直接比较其存储的 “值”是否相等；

           　　　　如果作用于引用类型的变量，则比较的是所指向的对象的地址

           　　2）对于equals方法，注意：equals方法不能作用于基本数据类型的变量

           　　　　如果没有对equals方法进行重写，则比较的是引用类型的变量所指向的对象的地址；

           　　　　诸如String、Date等类对equals方法进行了重写的话，比较的是所指向的对象的内容。
         */
        
        String str1 = new String("hello");
        String str2 = new String("hello");
                 
        System.out.println(str1==str2);
        System.out.println(str1.equals(str2));
    }
}
