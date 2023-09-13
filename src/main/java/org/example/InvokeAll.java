package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class InvokeAll {

    public static void main(String args[]) throws InterruptedException, ExecutionException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        List<Callable<String>> callables = new ArrayList<>();

        callables.add(newCallable("Task 1"));
        callables.add(newCallable("Task 2"));
        callables.add(newCallable("Task 3"));
        callables.add(newCallable("Task 4"));
        callables.add(newCallable("Task 5"));

        List<Future<String>> result = executorService.invokeAll(callables);

        for(Future future : result){
            String s = (String) future.get();
            System.out.println(s);
        }

        executorService.shutdown();


    }

    private static Callable<String> newCallable(String s) {

        return new Callable(){

            @Override
            public Object call() throws Exception {
                String result = Thread.currentThread().getName() + " : "+ s;
                return result;
            }
        };
    }
}
