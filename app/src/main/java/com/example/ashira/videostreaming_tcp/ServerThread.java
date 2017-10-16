package com.example.ashira.videostreaming_tcp;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by ashira on 10/16/2017 AD.
 */

public class ServerThread implements Runnable{

    ServerSocket serverSocket;
    int SERVERPORT;

    ServerThread(ServerSocket socket ,int port)
    {
        serverSocket = socket;
        SERVERPORT = port;
    }

        public void run() {
            Socket socket = null;
            try {
                serverSocket = new ServerSocket(SERVERPORT);
            } catch (IOException e) {
                e.printStackTrace();
            }
            while (!Thread.currentThread().isInterrupted()) {

                try {

                    socket = serverSocket.accept();

                    CommunicationThread commThread = new CommunicationThread(socket);
                    new Thread(commThread).start();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

