package concurency.delayedqueue;

import java.util.UUID;
import java.util.concurrent.BlockingQueue;

public class DelayQueueProducer implements Runnable{

    private final BlockingQueue<DelayObject> queue;
    private final Integer numberOfElementsToProduce;
    private final Integer delayOfEachProducedMessageMilliseconds;

    public DelayQueueProducer(final BlockingQueue<DelayObject> queue,
                              final Integer numberOfElementsToProduce,
                              final Integer delayOfEachProducedMessageMilliseconds) {
        this.queue = queue;
        this.numberOfElementsToProduce = numberOfElementsToProduce;
        this.delayOfEachProducedMessageMilliseconds = delayOfEachProducedMessageMilliseconds;
    }

    // standard constructor

    @Override
    public void run() {
        for (int i = 0; i < numberOfElementsToProduce; i++) {
            DelayObject object
                    = new DelayObject(
                    UUID.randomUUID().toString(), delayOfEachProducedMessageMilliseconds);
            System.out.println("Put object: " + object);
            try {
                queue.put(object);
                Thread.sleep(500);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }
}
