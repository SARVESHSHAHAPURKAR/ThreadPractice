package BlockingQueuePractice;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class OtherMethods {

    public static void main(String[] args) {

        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        String s = blockingQueue.peek(); // --> JUST RETURNS THE FIRST ELEMENT, DOESN'T REMOVE IT
        String k = blockingQueue.element(); // --> returns first element, if empty, throws exception

        int m = blockingQueue.size();
        int n = blockingQueue.remainingCapacity();
        boolean containsElement = blockingQueue.contains("s");

        // ABOVE 3 METHODS ARE SELF-EXPLANATORY
    }
}
