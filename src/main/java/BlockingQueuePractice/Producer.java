package BlockingQueuePractice;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    BlockingQueue blockingQueue = null;

    public Producer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {


        while(true){
            Long currentTime = System.currentTimeMillis();
            blockingQueue.add(""+currentTime);
            sleep();
        }

    }

    private void sleep() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
