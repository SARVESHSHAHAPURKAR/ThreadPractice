package BlockingQueuePractice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class DequeMethods {

    public static void main(String[] args) {

        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        // THE TAKE METHOD BLOCKS THE QUEUE UNTIL ATLEAST ONE VALUE IS AVAILABLE IN THE QUEUE, AND THEN
        // PULLS THAT VALUE OUT. SINCE IT BLOCKS THE QUEUE, THE THEREAD CAN BE INTERRUPTED, AND SO WE
        // NEED TO HANDLE INTERRUPTED EXCEPTION
        try {
            String s = blockingQueue.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String s = blockingQueue.poll();
        // IF AVAILABLE, POLL REMOVES AND RETURNS THE FIRST ELEM IN QUEUE, ELSE RETURNS NULL


        // IF PROVIDED WITH TIME AND UNITS, POLL() WILL BLOCK THE QUEUE UNTIL THAT TIME, HENCE WE NEED
        // TO HANDLE THE INTERRUPTEDEXCEPTION
        try {
            String k = blockingQueue.poll(1000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // REMOVES the first occurance of the element and returns true if it is successfully removed
        blockingQueue.remove("3");

        List<String> list = new ArrayList<>();

        // REMOVES THE TOP 5 ELEMENTS FROM THE QUEUE AND PUTS IN THE LIST, IF SIZE LESS THAN 5, REMOVES
        // ALL ELEMENTS
        blockingQueue.drainTo(list,5);
    }
}
