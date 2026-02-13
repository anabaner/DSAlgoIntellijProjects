package ExecutorServiceExamples;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrintingNumbersWithFixedThreadPool {

	public static void main(String[] args) {
		printNumbers(); // not sequential
		printNumbersSequential();
		printNumbersWithoutLambda();

	}

	private static void printNumbers() {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 100; i++) {
		int number = i;
		
		executor.submit(()->{
			  System.out.println("Thread " + Thread.currentThread().getName() + " - Number: " + number);
		});
		}
		
		executor.shutdown();
	}
	
	private static void printNumbersSequential() {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 100; i++) {
			int number = i;
			
			executor.submit(()->{
				  System.out.println( " Number: " + number);
			});
			
			}
		executor.shutdown();
		
	}
	
	private static void printNumbersWithoutLambda() {
		 ExecutorService executor = Executors.newSingleThreadExecutor();

	        for (int i = 1; i <= 100; i++) {
	            executor.submit(new NumberPrinter(i));
	        }

	        executor.shutdown();
		
	}
}
	
	
	// Separate class implementing Runnable
	class NumberPrinter implements Runnable {
	    private final int number;

	    public NumberPrinter(int number) {
	        this.number = number;
	    }

	    @Override
	    public void run() {
	        System.out.println("Number: " + number);
	    }

}

