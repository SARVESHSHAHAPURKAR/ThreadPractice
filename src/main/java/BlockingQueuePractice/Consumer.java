package BlockingQueuePractice;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{

    BlockingQueue blockingQueue = null;

    public Consumer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {

        while (true){
            try {
                String s = (String) blockingQueue.take();
                System.out.println("Consumed : "+s);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
