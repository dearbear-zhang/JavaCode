package com.my.android;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Pc端与Android的通信, 通过:
 * adb forward tcp:10086 tcp:10086
 */
public class SocketServiceUtils {
    /**
     * 端口号
     */
    private static final int PHONE_PORT = 10086;
    public static final String HOST = "localhost";


    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PHONE_PORT);
            Socket client = null;
            ObjectInputStream ois = null;
            BufferedReader input = null;
            PrintWriter out = null;
            while (true) {
                System.out.println("Server is Start");
                client = serverSocket.accept();
                System.out.println("Get a connection from " + client.getRemoteSocketAddress().toString());
//                ois = new ObjectInputStream(client.getInputStream());
//                String somewords = (String) ois.readObject();
                input = new BufferedReader(new InputStreamReader(client.getInputStream()));
                String somewords = input.readLine();
                System.out.println("Get client data:" + somewords);
                out = new PrintWriter(new BufferedWriter(
                        new OutputStreamWriter(client.getOutputStream())), true);
                out.println("imei: null");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }


}
