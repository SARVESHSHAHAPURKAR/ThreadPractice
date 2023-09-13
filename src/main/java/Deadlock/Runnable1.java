package Deadlock;

import java.util.concurrent.locks.Lock;

public class Runnable1 implements Runnable{

    Lock lock1 = null;
    Lock lock2 = null;

    public Runnable1(Lock lock1, Lock lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName()+" "+"Attempting to lock lock1");
        lock1.lock();
        System.out.println(Thread.currentThread().getName()+" "+"Locked lock 1");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Thread.currentThread().getName()+" "+"Attempting to lock lock2");
        lock2.lock();
        System.out.println(Thread.currentThread().getName()+" "+"Locked lock 2");


    }
}
