package org.example;

//import sun.nio.ch.ThreadPool;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {

    public static void main(String args[]){

        Lock lock = new ReentrantLock();

        // Lock lock = new ReentrantLock(true)
        // true means lock will be fair.. that is it will keep record of which thread was
        // first in the waiting queue.. and will execute it once unlocked, thus avoiding
        // starvation .. false means fairness
        // not guaranteed...no argument means false by default

        // REENTRANT LOCK MEANS A THREAD CAN LOCK THE AGAIN MULTIPLE TIMES.. ALTHOUGH IT HAS TO UNLOCK
        // THE LOCK THAT MANY TIMES

        lock.lock();

        // critical section


        lock.unlock();
    }
}
