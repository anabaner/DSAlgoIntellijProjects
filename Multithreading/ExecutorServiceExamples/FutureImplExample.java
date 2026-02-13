package ExecutorServiceExamples;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureImplExample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		
		Future<Integer> future = new SquareCalculator().calculate(10);
	    Integer result = future.get();
	    
	    
	    ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Integer> future1 = executor.submit(new CallableTask());

        // Do some other work

        Integer result1 = future1.get(); // Blocking call to get the result
        System.out.println("Result: " + result1);

        executor.shutdown();
	   
	}

}


class SquareCalculator{	
	
	 private ExecutorService executor = Executors.newSingleThreadExecutor();
	 public Future<Integer> calculate(Integer input) {        
	        return executor.submit(() -> {
	            Thread.sleep(1000);
	            return input * input;
	        });
	    }	

}
class CallableTask implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        Random random = new Random();
        int randomNumber = random.nextInt(10);
        Thread.sleep(randomNumber * 100); // Simulate some work
        return randomNumber;
    }
}

