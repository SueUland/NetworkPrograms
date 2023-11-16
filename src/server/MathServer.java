package server;

import java.io.IOException;
import java.io.PrintWriter; // write back the 5 equation results or the math protocol error
import java.util.Scanner; // read in the 2 numbers from client
import java.net.ServerSocket;
import java.net.Socket;

public class MathServer {
    public static final int PORT_NUMBER = 9534; // set to unreserved port number

    public static void main(String[] args) {
        // create the Server Socket
        // try with clause try() will close the socket for us no matter what happens
        try (ServerSocket s = new ServerSocket(PORT_NUMBER)) {
            // starting up server
            System.out.println("Starting up Math Server....");

            // block until we receive a math request from client "10 2" "asfg" "10"
            Socket client = s.accept();

            // client is connected
            System.out.println("Math Client is connected ....");

            // we need to send text to Client --> construct PrintWriter object
            // PrintWriter always uses outputStream, set autoflush to true
            PrintWriter sendToClient = new PrintWriter(client.getOutputStream(), true);

            // we need to read numbers from Client ---> construct Scanner
            Scanner readFromClient = new Scanner(client.getInputStream());
            while (readFromClient.hasNextLine()) {
                String line = readFromClient.nextLine(); // "10 2" = line
                String[] items = line.split(" "); // items[0] = "10" items[1] = "2"

                int num1 = Integer.parseInt(items[0]);
                int num2 = Integer.parseInt(items[1]);

                System.out.println("Server sending text to client....");
                // sendToClient.println("Hello There");
            }
            /*
            10 + 2 = 12
            10 – 2 = 8
            10 * 2 = 20
            10 / 2 = 5
            10 % 2 = 0
             */


        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
}