package com.example.ashira.videostreaming_tcp;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.net.ServerSocket;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    public final int TCP_PORT = 2222;

    Handler update;
    Thread serverThread;
    private ServerSocket server;
    private Socket socket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        update = new Handler();
        this.serverThread = new Thread(new ServerThread(server));
        this.serverThread.start();




    }
}
