package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;
import java.util.Date;

public class TimeServer {

    public static final int PORT_NUMBER = 9234; // set to unreserved port number
    public static void main(String[] args) {
        // create the Server Socket
        // try with clause try() will close the socket for us no matter what happens
        try(ServerSocket s = new ServerSocket(PORT_NUMBER)){
            // starting up server
            System.out.println("Starting up Time Server....");

            // block until we receive a time request from client
            Socket client = s.accept();

            // client is connected
            System.out.println("Client is connected ....");

            // we need to send text to Client --> construct PrintWriter object
            // PrintWriter always uses outputStream, set auto flush to true
            PrintWriter sendToClient = new PrintWriter(client.getOutputStream(), true);

            System.out.println("Server sending text to client....");
            sendToClient.println(new Date());

        } catch (IOException e){
            System.out.println("IOException: " + e.getMessage());
        }
    }
}
