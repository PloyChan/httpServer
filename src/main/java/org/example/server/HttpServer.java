package org.example.server;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
   public void start() throws IOException {
      final ServerSocket serverSocket = new ServerSocket(8080);
      while (true) {
         Socket socket = serverSocket.accept();
         new Thread(
                 () -> {
                      try {
                          BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                          BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                          String readLine = bufferedReader.readLine();
                          String method = readLine.split(" ")[0];
                          String resource = readLine.split(" ")[1];
                          System.out.println("method : "+ method);
                          System.out.println("resource : " + resource);

                          bufferedWriter.write("HTTP/1.1 200");
                          bufferedWriter.newLine();
                          bufferedWriter.newLine();
                          bufferedWriter.write("<html><body>hello ploy</body></html>");
                          bufferedWriter.flush();
                          socket.close();
                      } catch (Exception e){
                         throw new RuntimeException();
                      }
                   }
           ).start();
        }
      }
}
