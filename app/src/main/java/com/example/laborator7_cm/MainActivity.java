package com.example.laborator7_cm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.net.*;
import java.io.*;

public class MainActivity extends AppCompatActivity {
    private TextView tvcReceivedData;
    private EditText etcIP, etcPORT;
    private Button btnClient;
    private String ServerName;
    private int ServerPort;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvcReceivedData = findViewById(R.id.receivedData);
        etcIP = findViewById(R.id.adressIP);
        etcPORT = findViewById(R.id.port);
        btnClient = findViewById(R.id.btn_connect_client);


    } //on create

    public void onClickConnect(View view) {
        ServerName = etcIP.getText().toString();
        ServerPort = Integer.valueOf(etcPORT.getText().toString());

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {

                    Socket socketObj = new Socket(ServerName, ServerPort);
                    BufferedReader input = Utilities.getReader(socketObj);
                    String txtFromServer = input.readLine();


                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tvcReceivedData.setText(txtFromServer);
                        }
                    });
//                } catch (UnknownHostException e) {
//                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    } //btn onClick

} //main