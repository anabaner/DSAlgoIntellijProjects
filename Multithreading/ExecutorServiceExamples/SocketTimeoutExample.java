package ExecutorServiceExamples;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class SocketTimeoutExample {

	public static void main(String[] args) {

        String host = "example.com"; // Replace with your target host
        int port = 80; // Replace with your target port
        int timeoutMillis = 5000; // 5 seconds timeout

        try {
            Socket socket = new Socket(host, port);
            socket.setSoTimeout(timeoutMillis); // Set the timeout

            // Now, any blocking read operation on this socket's input stream
            // will throw a SocketTimeoutException if no data is received within 5 seconds.
            // Example:
            // InputStream in = socket.getInputStream();
            // int data = in.read(); // This will time out if no data arrives in 5 seconds

            System.out.println("Socket connected successfully with a timeout of " + timeoutMillis + "ms.");

            // Perform other socket operations (e.g., send/receive data)

            socket.close(); // Close the socket when done

        } catch (SocketTimeoutException e) {
            System.err.println("Socket operation timed out: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("An I/O error occurred: " + e.getMessage());
        }
    

	}

}


