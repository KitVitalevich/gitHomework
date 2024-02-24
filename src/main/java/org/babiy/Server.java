package org.babiy;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {

        QuoteGenerator quoteGenerator = new QuoteGenerator();

        try (ServerSocket serverSocket = new ServerSocket(Util.PORT);
             Socket socket = serverSocket.accept();
             PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()))) {

            writer.println(quoteGenerator.Quote());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
