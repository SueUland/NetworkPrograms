package client;

import server.TimeServer;

import java.io.IOException;
import java.net.*;
import java.util.*;
public class TimeClient {

    public static void main(String[] args) {
        // use a try with to construct the client socket
        try(Socket s = new Socket("localhost", TimeServer.PORT_NUMBER)){
           // create a Scanner object to receive the text from the Server
            // Scanners always construct with inputstream
            Scanner readFromServer = new Scanner(s.getInputStream());

            while(readFromServer.hasNextLine()){
                System.out.println(readFromServer.nextLine());
            }

        }catch (IOException e){
            System.out.println("IOException " + e.getMessage());
        }
    }
}
