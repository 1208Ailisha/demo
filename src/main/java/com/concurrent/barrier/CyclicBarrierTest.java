package com.concurrent.barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 创建一组任务，它们并发地执行工作，另外的一个任务在这一组任务并发执行结束前一直阻塞等待，直到该组任务全部执行结束，这个任务才得以执行。
 * <p></p>
 * @author zengjx
 * @version $Id: CyclicBarrierTest.java 2017年8月10日 下午3:47:14 zengjx $
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {
        //创建CyclicBarrier对象，  
        //并设置执行完一组5个线程的并发任务后，再执行MainTask任务  
        CyclicBarrier cb = new CyclicBarrier(5, new MainTask());
        new SubTask("A", cb).start();
        new SubTask("B", cb).start();
        new SubTask("C", cb).start();
        new SubTask("D", cb).start();
        new SubTask("E", cb).start();
    }
}

/**  
* 最后执行的任务 
*/
class MainTask implements Runnable {
    public void run() {
        System.out.println("......终于要执行最后的任务了......");
    }
}

/**  
* 一组并发任务  
*/
class SubTask extends Thread {
    private String        name;
    private CyclicBarrier cb;

    SubTask(String name, CyclicBarrier cb) {
        this.name = name;
        this.cb = cb;
    }

    public void run() {
        System.out.println("[并发任务" + name + "]  开始执行");
        for (int i = 0; i < 10000; i++); //模拟耗时的任务   
        System.out.println("[并发任务" + name + "]  开始执行完毕，通知障碍器");
        try {
            //每执行完一项任务就通知障碍器   
            cb.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}