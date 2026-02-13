package ExecutorServiceExamples;

public class RaceConditionExample {
    public static void main(String[] args) throws InterruptedException {
        CounterIncrement inc = new CounterIncrement();
        //comment start to fix race condition
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                inc.incrementCount();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                inc.incrementCount();
            }
        }
        );

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(" count:: " + inc.count);
        //comment end to fix race condition

        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                inc.incrementCountSync();
            }
        });

        Thread t4 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                inc.incrementCountSync();
            }
        }
        );

        t3.start();
        t4.start();

        t3.join();
        t4.join();
        System.out.println(" count:: " + inc.getCount());

    }
}


class CounterIncrement{
    int count = 0 ;

    void incrementCount(){
        count++;
    }

    synchronized void incrementCountSync(){
        count++;
    }

    public synchronized int getCount() {
        return count;
    }
}
