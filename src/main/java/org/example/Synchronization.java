package org.example;

class Counter{

    int count;

    public synchronized void increment(){
        count++;
    }
}

public class Synchronization {

    public static void main (String args[]) throws InterruptedException {
        Counter c = new Counter();

        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                for(int i=0; i<1000;i++) {
                    c.increment();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {

                for(int i=0; i<1000;i++) {
                    c.increment();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        // IF increment() method is not synchronized, count may not reach upto 2000 in some cases. As
        // it may happen that t1 and t2 approach the method simultaneously, and it is incremented only once.
        // synchronized method means... only one thread can use it at a time.. the other thread has to wait

        System.out.println("Count is "+c.count);

    }
}
