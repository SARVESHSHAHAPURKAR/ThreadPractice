package org.example;

public class LambdaExample {

    // AS RUNNABLE IS A FUNCTIONAL INTERFACE, WE CAN CREATE ITS INSTANCE USING LAMBDA EXPRESSION
    // USING () -> , AS THERE IS ONLY ONE METHOD, WE DONT NEED TO MENTION ITS NAME

    public static void main(String args[]) throws InterruptedException {

        Thread t1 = new Thread(()->
        {
            for (int i = 0; i < 5; i++) {
                System.out.println("HiNew4");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t2 = new Thread(()->
        {
            for (int i = 0; i < 5; i++) {
                System.out.println("HelloNew4");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        Thread.sleep(10);
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Bye");


    }
}
