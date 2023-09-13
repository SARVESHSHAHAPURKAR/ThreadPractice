package org.example;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FuturePractice {

    public static void main(String []args) {

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future future = executorService.submit(newRunnable("Task 1"));

        executorService.shutdown();

        System.out.println(future.isDone());

        try {
            future.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        System.out.println(future.isDone());
    }

    private static Runnable newRunnable(String s) {

        return new Runnable(){

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " : "+s);
            }
        };
    }
}
