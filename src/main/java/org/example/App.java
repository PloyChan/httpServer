package org.example;

import org.example.server.HttpServer;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        HttpServer httpServer = new HttpServer();
        httpServer.start();
    }
}
