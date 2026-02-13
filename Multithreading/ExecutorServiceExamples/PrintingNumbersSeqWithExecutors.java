package ExecutorServiceExamples;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PrintingNumbersSeqWithExecutors {
    private static final Object lock = new Object();
    private static int currentNumber = 1;
    private static final int LIMIT = 10;
    private static final int NO_OF_THREADS = 3;

    static class NumberPrinter implements Runnable {
        private final int threadId;

        public NumberPrinter(int threadId) {
            this.threadId = threadId;
        }

        @Override
        public void run() {
            while (currentNumber <= LIMIT) {
                synchronized (lock) {
                    // Use a while loop to handle spurious wake-ups and re-check the condition.
                    while (currentNumber <= LIMIT && (currentNumber % NO_OF_THREADS) != threadId) {
                        try {
                            lock.wait(); // Not this thread's turn, so wait.
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }

                    if (currentNumber <= LIMIT) {
                        System.out.println("Thread " + Thread.currentThread().getName() + " prints: " + currentNumber);
                        currentNumber++;
                        lock.notifyAll(); // Wake up all waiting threads to check if it is their turn.
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        // Create a fixed-size thread pool.
        ExecutorService executor = Executors.newFixedThreadPool(NO_OF_THREADS);

        // Submit tasks to the thread pool
        for (int i = 0; i < NO_OF_THREADS; i++) {
            // Assign thread IDs using modulo logic (e.g., if threads = 3, IDs 1, 2, 0)
            // The number '1' is assigned to the first thread to start the sequence from 1.
            executor.submit(new NumberPrinter((i + 1) % NO_OF_THREADS));
        }

        executor.shutdown(); // Initiate an orderly shutdown.
        try {
            // Wait for all tasks to complete.
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}

