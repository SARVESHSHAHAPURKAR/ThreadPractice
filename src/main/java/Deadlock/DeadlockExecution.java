package Deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockExecution {

    public static void main(String args[]){

        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();

        Thread t1 = new Thread(new Runnable1(lock1,lock2), "Thread 1");
        Thread t2 = new Thread(new Runnable2(lock1, lock2), "Thread 2");

        t1.start();
        t2.start();


    }
}
