package BlockingQueuePractice;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class BlockingQueueExample {

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        //BlockingQueue linkedBlockingQueue = new LinkedBlockingDeque();

        // THESE ARE THE IMPLEMENTATIONS OF BLOCKING QUEUE

        arrayBlockingQueue.put("Element 1");
        arrayBlockingQueue.put("Element 2");

        String elem1 = arrayBlockingQueue.take();
        String elem2 = arrayBlockingQueue.take();

        System.out.println("Elem1 is "+elem1+" and Elem2 is "+elem2);



    }
}
