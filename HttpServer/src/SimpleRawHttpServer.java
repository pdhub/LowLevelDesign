import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleRawHttpServer {
    static final int PORT = 8000;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)){
            System.out.println("Server started on "+PORT);

            while (true){
                try (Socket clientSocket = serverSocket.accept()){
                    handleClientRequest(clientSocket);
                }catch (IOException e){
                    System.err.println("Error handling client");
                }
            }
        }catch (IOException e){
            System.err.println("Could not start server..");
        }
    }

    private static void handleClientRequest(Socket clientSocket) throws IOException {
        BufferedReader in =new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        OutputStream out = clientSocket.getOutputStream();

        String requestLine = in.readLine();
        if (requestLine == null) return;
        System.out.println("Received request " + requestLine);

        String[] requestParts = requestLine.split(" ");
        String method = requestParts[0];
        String path = requestParts.length > 1 ? requestParts[1] : "/";

        String response;
        if("/".equals(path))
            response = "hello from root";
        else if ("/hello".equals(path)) {
            response = "hello from api hello";
        }
        else
            response = "Not found";

        String httpResponse = "HTTP/1.1 200 OK\r\n";
        out.write(httpResponse.getBytes());
        out.flush();

        in.close();
        out.close();
    }
}

