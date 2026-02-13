package ExecutorServiceExamples;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledTask {

	public static void main(String[] args) {


        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        
        scheduler.schedule(() -> {
            System.out.println("Code executed after delay using ScheduledExecutorService.");
            scheduler.shutdown(); // Shut down the scheduler after execution
        }, 3, TimeUnit.SECONDS); // Delay for 3 seconds
    
		
	}

}
