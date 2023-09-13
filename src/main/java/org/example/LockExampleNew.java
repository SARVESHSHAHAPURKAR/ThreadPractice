package org.example;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//import static java.lang.Thread.sleep;

public class LockExampleNew {
    
    public static void main(String args[]){
        
        //lockExample();
        //lockInterruptibly();
        tryLock();
    }

    private static void tryLock() {

        Lock lock = new ReentrantLock();

        try {
            boolean isSuccess = lock.tryLock();

            // TRIES TO LOCK A LOCK, IF IT IS NOT LOCKED BY
            //ANY OTHER THREAD.. WE CAN ALSO PROVIDE TIME, SO IT WILL CHECK FOR THAT MUCH TIME IF IT
            // IS ABLE TO LOCK THE LOCK, OTHERWISE RETURN FALSE;
            //lock.tryLock(1000, TimeUnit.MILLISECONDS);

            System.out.println("Try lock is " + isSuccess);
        }
        catch(Exception e){

        }
        finally {
            lock.unlock();
        }
    }

    private static void lockExample() {

        Lock lock = new ReentrantLock();

        Runnable runnable = ()->{
          lockSleepUnlock(lock,1000);
        };

        Thread t1 = new Thread(runnable,"Thread 1");
        Thread t2 = new Thread(runnable,"Thread 2");
        Thread t3 = new Thread(runnable,"Thread 3");

        t1.start();
        t2.start();
        t3.start();
    }

    private static void lockInterruptibly() {

        Lock lock = new ReentrantLock();

        //Thread.currentThread().interrupt();
        // IF THIS IS UNCOMMENTED, EXCEPTION WILL BE THROWN

        try{
            lock.lockInterruptibly(); // --> LOCK WILL BE LOCKED ONLY IF THREAD IS NOT INTERRUPTED,
            // OTHERWISE THROWS EXCEPTION
            lock.unlock();
        }
        catch(InterruptedException e){
            System.out.println("Thread interrupted");
        }
    }

    private static void lockSleepUnlock(Lock lock, int time){

        try {
            lock.lock();
            printMessage(" holds the lock");
            sleep(time);
        }
        finally {
            lock.unlock();
        }
    }

    private static void printMessage(String s) {

        System.out.println(Thread.currentThread().getName()+s);
    }

    private static void sleep(int time) {

        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
