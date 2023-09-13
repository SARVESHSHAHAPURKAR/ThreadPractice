package BlockingQueuePractice;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class EnqueueMethods {

    public static void main(String[] args) {


        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        blockingQueue.add("3"); // --> DOESN'T BLOCK THE QUEUE.. IF NO SPACE RETURNS ILLEGAL STATE
                                // EXCEPTION

        try {
            blockingQueue.put("3"); // --> BLOCKS THE QUEUE TILL IT HAS SPACE AND THEN PUTS
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Boolean wasEnqueued = blockingQueue.offer("3"); // -> ADDS THE ELEMENT, AND RETURNS A BOOLEAN

        try {
            Boolean wasEnqueuedNew = blockingQueue.offer("3", 1000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // WILL TRY ADDING TILL 1000 MILLISECONDS, if succed then okay, otherwise throws exception

    }

}
