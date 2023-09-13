package org.example;

import java.util.concurrent.*;

public class CallablePractice {

    public static void main(String []args) {

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future future = executorService.submit(newCallable("Task 1"));

        executorService.shutdown();

        System.out.println(future.isDone());

        try {
            String s = (String) future.get();
            System.out.println(s);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        System.out.println(future.isDone());
    }

    private static Callable newCallable(String s) {

        return new Callable(){


            @Override
            public Object call() throws Exception {

                String result = Thread.currentThread().getName()+" : "+s;
                return result;
            }
        };
    }
}
