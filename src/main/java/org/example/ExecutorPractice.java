package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorPractice {

    public static void main(String []args) {

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(newRunnable("Task 1"));
        executorService.execute(newRunnable("Task 2"));
        executorService.execute(newRunnable("Task 3"));
        executorService.execute(newRunnable("Task 4"));
        executorService.execute(newRunnable("Task 5"));
        executorService.execute(newRunnable("Task 6"));

        executorService.shutdown();
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
