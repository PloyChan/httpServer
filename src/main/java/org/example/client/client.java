package org.example.client;

import java.io.*;
import java.net.Socket;

public class client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.32.82",8080);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        bufferedWriter.write("GET http://localhost:8080");
        bufferedWriter.newLine();
        bufferedWriter.flush();

        String s = bufferedReader.readLine();
        System.out.println(s);
        socket.close();
    }
}
