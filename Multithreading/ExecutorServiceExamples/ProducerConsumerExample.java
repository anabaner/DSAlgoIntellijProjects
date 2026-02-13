package ExecutorServiceExamples;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// The Producer class
class Producer implements Runnable {
    private final BlockingQueue<Integer> sharedQueue;

    public Producer(BlockingQueue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("Produced: " + i);
                sharedQueue.put(i); // Blocks if the queue is full
                Thread.sleep(100); // Simulate some production time
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

// The Consumer class
class Consumer implements Runnable {
    private final BlockingQueue<Integer> sharedQueue;

    public Consumer(BlockingQueue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Integer item = sharedQueue.take(); // Blocks if the queue is empty
                System.out.println("Consumed: " + item);
                Thread.sleep(200); // Simulate some consumption time
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

// Main class to run the threads
public class ProducerConsumerExample {
    public static void main(String[] args) {
        // Creating a shared ArrayBlockingQueue with capacity 5
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

        // Creating producer and consumer
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        // Creating and starting threads
        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();
    }
}

