package org.example;

class HiNew2 implements Runnable{

    @Override
    public void run(){
        for(int i=0; i<5; i++){
            System.out.println("HiNew2");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}

class HelloNew2 implements Runnable{

    @Override
    public void run(){
        for(int i=0; i<5; i++){
            System.out.println("HelloNew2");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}

public class RunnableExample {

    public static void main(String args[]) throws InterruptedException {

        Runnable obj1 = new HiNew2();
        Runnable obj2 = new HelloNew2();

        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);

        t1.start();
        Thread.sleep(10);
        t2.start();

        System.out.println("T1 IS "+ t1.isAlive());
        System.out.println("T2 IS "+ t2.isAlive());

        t1.join();
        t2.join();

        System.out.println("T1 IS "+ t1.isAlive());
        System.out.println("T2 IS "+ t1.isAlive());

        // JOIN MEANS MAIN THREAD WILL WAIT UNTIL T1 AND T2 IS DIED.. OTHERWISE BYE WILL BE
        // PRINTED IN BETWEEN

        System.out.println("Bye");

    }


}
