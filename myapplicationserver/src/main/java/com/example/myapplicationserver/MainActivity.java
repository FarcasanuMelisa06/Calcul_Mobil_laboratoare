package com.example.myapplicationserver;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private ServerThread singleServerThread;
    private TextView tvsIP, tvsPORT, tvsSTATUS, tvsSTATUS2;
    private String serverIP = "10.0.2.15";
    private int serverPORT = 1234;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate: ");

        tvsIP = findViewById(R.id.serverIP);
        tvsPORT = findViewById(R.id.serverPort);
        tvsSTATUS = findViewById(R.id.status);
        // tvsSTATUS2 = findViewById(R.id.status2);


        tvsIP.setText("Server IP: " + serverIP);
        tvsPORT.setText("Server PORT: " + String.valueOf(serverPORT));

    }// on create

    public void onClickStartServer(View view) {
        Log.i(TAG, "onClickStartServer: ");
        singleServerThread = new ServerThread();
        singleServerThread.startServer();

    } //start server

    public void onClickStopServer(View view) {
        Log.i(TAG, "onClickStopServer: ");
        singleServerThread.stopServer();

    }//stop server

    class ServerThread extends Thread implements Runnable {

        private boolean serverRunning;
        private ServerSocket serverSocket;
        private int count = 0;

        public void startServer() {
            Log.i(TAG, "startServer: Clasa Shared Thread");
            serverRunning = true;
            start();

        } //start server class method

        @Override
        public void run() {
            Log.i(TAG, "run: Clasa SharedThread");

            try {
                serverSocket = new ServerSocket(serverPORT);
            } catch (IOException e) {
                e.printStackTrace();
            }

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    tvsSTATUS.setText("Waiting for Clients");
                    //tvsSTATUS2.setText("...");
                }
            });

            while (serverRunning) {
                Log.i(TAG, "run: insider WHILE");
                Socket socket = null;
                try {
                    socket = serverSocket.accept();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                count++;

//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            tvsSTATUS.setText("Connected to: " + socket.getInetAddress() + ":" + socket.getLocalPort());
//
//                        }
//                    });
//
//                    PrintWriter outputServer = new PrintWriter(socket.getOutputStream());
//                    outputServer.write("Welcome to Server: " + count);
//                    outputServer.flush();
//
//                    socket.close();

                PrintWriter outputServer = null;
                try {
                    outputServer = new PrintWriter(socket.getOutputStream());
                } catch (IOException e) {
                    e.printStackTrace();
                }

                EditText message = findViewById(R.id.messageServer);
                outputServer.write(message.getText().toString());
                outputServer.flush();

                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }//while

        }//run

        public void stopServer() {
            Log.i(TAG, "stopServer:  clasa Shared Thread");
            serverRunning = false;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    if (serverSocket != null) {
                        try {
                            serverSocket.close();

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    tvsSTATUS.setText("Connection Closed");
                                    tvsSTATUS2.setText("...");
                                }
                            });
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }//stop serv er class method

    }
}