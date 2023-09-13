package org.example;

public class SynchronizedReentrance {

    int count=0;

    public synchronized void inc(){
        this.count++;
    }

    public synchronized int incAndGet(){
        inc();

        // EVEN THOUGH BOTH INC() AND INCNDGET() ARE SYNCHRONIZED ON THE SAME MONITOR OBJECT, INC()
        // CAN STILL BE ACCESSED FROM THE INSIDE OF INCANDGET()
        return count;
    }
}
