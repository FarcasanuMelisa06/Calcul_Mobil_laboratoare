package com.example.tema8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    String jsonURL = "https://www.floatrates.com/daily/ron.json";
    private static final String TAG = "MainActivity";
    private TextView sumaFinala;
    double rata;
    private EditText sumaInitiala;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sumaFinala = findViewById(R.id.sumaFinala);
        sumaInitiala = findViewById(R.id.sumaInitiala);
    }

    public void ConvertUSD(View view) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(jsonURL)
                .build();

        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.i(TAG, "onFailure: ");
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {

                String recData = response.body().string();
                JSONObject emp = null;

                try {
                    emp = (new JSONObject(recData)).getJSONObject("usd");
                    Log.i(TAG, "json: " + emp);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                try {
                    rata = emp.getDouble("inverseRate");
                    Log.i(TAG, "rata: " + rata);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                double sumFinal = Double.parseDouble(String.valueOf(sumaInitiala.getText())) * rata;
                Log.i(TAG, "sumFinal: " + sumFinal);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        sumaFinala.setText(String.valueOf(sumFinal));
                    }
                });
            }
        });
    }

    public void ConvertEUR(View view) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(jsonURL)
                .build();

        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.i(TAG, "onFailure: ");
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {

                String recData = response.body().string();
                JSONObject emp = null;

                try {
                    emp = (new JSONObject(recData)).getJSONObject("eur");
                    Log.i(TAG, "json: " + emp);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                try {
                    rata = emp.getDouble("inverseRate");
                    Log.i(TAG, "rate: " + rata);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                double sumFinal = Double.parseDouble(String.valueOf(sumaInitiala.getText())) * rata;
                Log.i(TAG, "sumFinal: " + sumFinal);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        sumaFinala.setText(String.valueOf(sumFinal));
                    }
                });
            }
        });
    }

    public void ConvertGBP(View view) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(jsonURL)
                .build();

        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.i(TAG, "onFailure: ");
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {

                String recData = response.body().string();
                JSONObject emp = null;

                try {
                    emp = (new JSONObject(recData)).getJSONObject("gbp");
                    Log.i(TAG, "json: " + emp);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                try {
                    rata = emp.getDouble("inverseRate");
                    Log.i(TAG, "rata: " + rata);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                double sumFinal = Double.parseDouble(String.valueOf(sumaInitiala.getText())) * rata;
                Log.i(TAG, "sumFinal: " + sumFinal);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        sumaFinala.setText(String.valueOf(sumFinal));
                    }
                });
            }
        });
    }

    public void ConvertMDL(View view) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(jsonURL)
                .build();

        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.i(TAG, "onFailure: ");
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                String recData = response.body().string();
                JSONObject emp = null;
                try {
                    emp = (new JSONObject(recData)).getJSONObject("mdl");
                    Log.i(TAG, "json: " + emp);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                try {
                    rata = emp.getDouble("inverseRate");
                    Log.i(TAG, "rata: " + rata);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                double sumFinal = Double.parseDouble(String.valueOf(sumaInitiala.getText())) * rata;
                Log.i(TAG, "sumFinal: " + sumFinal);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        sumaFinala.setText(String.valueOf(sumFinal));
                    }
                });
            }
        });
    }
}