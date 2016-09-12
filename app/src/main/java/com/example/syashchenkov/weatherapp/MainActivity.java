package com.example.syashchenkov.weatherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String apiKey = "0754214d1efe06c4a8fb1f5bb7df1104";
        double latitude = 37.8267;
        double longitude = -122.423;
        String forecast = "https://api.forecast.io/forecast/"+apiKey+"/"+latitude+","+longitude+"";

        //Create an httpAPI client to handle out http requests
        OkHttpClient client = new OkHttpClient();
        //Create Request object
        Request request = new Request.Builder().url(forecast).build();
        //Create a call (send a request)
        Call call = client.newCall(request);
        //Get the responce (receive a callback)
        try {
            Response response = call.execute();
            if (response.isSuccessful()) {
                Log.v(TAG, response.body().string());
            }
        } catch (IOException e) {
            Log.e(TAG, "Execution caught: ", e);
        }


    }
}
