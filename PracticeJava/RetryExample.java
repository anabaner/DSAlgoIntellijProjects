public class RetryExample {

    public static void main(String[] args) {
        int maxRetries = 3;
        long delayMillis = 1000; // 1 second

        for (int attempt = 1; attempt <= maxRetries; attempt++) {
            try {
                performOperation(); // The operation to be retried
                System.out.println("Operation successful on attempt " + attempt);
                break; // Exit loop on success
            } catch (Exception e) {
                System.err.println("Operation failed on attempt " + attempt + ": " + e.getMessage());
                if (attempt < maxRetries) {
                    try {
                        Thread.sleep(delayMillis); // Wait before retrying
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                        System.err.println("Retry interrupted.");
                        break;
                    }
                } else {
                    System.err.println("Operation failed after " + maxRetries + " retries.");
                }
            }
        }
    }

    private static void performOperation() throws Exception {
        // Simulate a flaky operation that might fail
        if (Math.random() < 0.7) { // 70% chance of failure
            throw new RuntimeException("Simulated operation failure.");
        }
        System.out.println("Operation performed successfully.");
    }
}