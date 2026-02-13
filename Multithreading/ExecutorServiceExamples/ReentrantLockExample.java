package ExecutorServiceExamples;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

        private final ReentrantLock lock = new ReentrantLock();

        public void methodA() {
            lock.lock();
            try {
                System.out.println("Inside Method A");
                methodB();  // Reentrant lock allows the same thread to enter methodB
            } finally {
                lock.unlock();
            }
        }

        public void methodB() {
            lock.lock();
            try {
                System.out.println("Inside Method B");
            } finally {
                lock.unlock();
            }
        }

        public static void main(String[] args) {
            ReentrantLockExample example = new ReentrantLockExample();
            example.methodA();
        }
}
