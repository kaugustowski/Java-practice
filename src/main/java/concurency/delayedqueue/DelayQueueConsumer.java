package concurency.delayedqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class DelayQueueConsumer implements Runnable {
    private final BlockingQueue<DelayObject> queue;
    private final Integer numberOfElementsToTake;
    public AtomicInteger numberOfConsumedElements = new AtomicInteger();

    public DelayQueueConsumer(final BlockingQueue<DelayObject> queue,
                              final Integer numberOfElementsToTake) {
        this.queue = queue;
        this.numberOfElementsToTake = numberOfElementsToTake;
    }

    @Override
    public void run() {
        for (int i = 0; i < numberOfElementsToTake; i++) {
            try {
                DelayObject object = queue.take();
                numberOfConsumedElements.incrementAndGet();
                System.out.println("Consumer take: " + object);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
