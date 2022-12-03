package com.example.lab6_tema;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int userNumber;
    int myNumber;
    int threadNumber;
    private static final Handler mainHandler = new Handler();
    private volatile boolean stopThread = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickStart(View view) {
        stopThread = false;
        ThreadClass fir = new ThreadClass();
        new Thread(fir).start();
    }

    public int randomNumber() {
        TextView limitaInterval = findViewById(R.id.extremaInterval);
        Random random = new Random();

        int randomInterval, limita;

        limita = Integer.parseInt(limitaInterval.getText().toString());
        randomInterval = random.nextInt(limita);

        return randomInterval;
    }


    public void onVerificaNumar(View view) {

        ComparareUser(userNumber);
    }

    public void ComparareUser(int nrDeAles) {
        TextView numarulMeu = findViewById(R.id.numarulMeu);
        myNumber = Integer.parseInt(numarulMeu.getText().toString());

        TextView castigator = findViewById(R.id.textView1);
        if (myNumber == nrDeAles) {
            castigator.setText("A castigat User");
            stopThread = true;
        } else {
            castigator.setText("Nimeni nu a castigat, inca");
        }
    }

    class ThreadClass implements Runnable {

        ThreadClass() {
        }

        @Override
        public void run() {
            userNumber = randomNumber();
            while (!stopThread) {
                mainHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        threadNumber = randomNumber();
                        TextView numbers = findViewById(R.id.afisareNumere);
                        numbers.setText("Numarul generat de fir este: " + threadNumber);


                        TextView castigator = findViewById(R.id.textView1);
                        if (threadNumber == userNumber) {
                            castigator.setText("A castigat firul ");
                            stopThread = true;
                        } else {
                            castigator.setText("Nimeni nu a castigat, inca");
                        }

                    }
                });
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}