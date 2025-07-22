import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class SimpleHTTPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);

        System.out.println("Listening for connection on port 8080 ....");

        while (true){
            //spin forever

            try (Socket client = server.accept()){

                //1. Read HTTP request from client socket
                //2. Prepare an HTTP response
                //3. Send HTTP response to client
                //4. Close the socket

                InputStreamReader isr = new InputStreamReader(client.getInputStream()); //What kind of request is happening from the client to the server
                BufferedReader reader = new BufferedReader(isr);
                String line = reader.readLine();
                while(!line.isEmpty()){
                    System.out.println(line);
                    line = reader.readLine();
                }
                //Sending todays date to the thing
                Date today = new Date();
                String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + today;
                client.getOutputStream().write(httpResponse.getBytes("UTF-8"));
            
            }

            
        }
    }
}
