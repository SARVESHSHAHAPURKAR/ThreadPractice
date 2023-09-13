package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;


public class InvokeAny {


    public static void main(String args[]){

        Long startTime = System.currentTimeMillis();

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        List<Callable<String>> callables = new ArrayList<>();
        callables.add(newCallable("Task 1"));
        callables.add(newCallable("Task 2"));
        callables.add(newCallable("Task 3"));
        callables.add(newCallable("Task 4"));
        callables.add(newCallable("Task 5"));
        callables.add(newCallable("Task 6"));
        callables.add(newCallable("Task 7"));
        callables.add(newCallable("Task 8"));
        callables.add(newCallable("Task 9"));
        callables.add(newCallable("Task 10"));

        try {
            String s = executorService.invokeAny(callables);
            System.out.println(s);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        executorService.shutdown();

        long endTime = System.currentTimeMillis();
        System.out.println("TIme elapsed : "+(endTime-startTime));

    }

    private static Callable<String> newCallable(String s) {

        return new Callable(){

            @Override
            public Object call() throws Exception {
                String result = Thread.currentThread().getName()+" : "+s;
                return result;
            }
        };
    }
}
