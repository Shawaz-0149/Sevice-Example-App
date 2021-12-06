package com.example.services;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    private boolean state = true;
    private Button button;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button = findViewById(R.id.button);

        button.setOnClickListener(v -> {

            Intent intent = new Intent(getApplicationContext(), MyService.class);
            if (state) {
                startService(intent);
                button.setText("Stop Service");
                state = false;

            } else {
                stopService(intent);
                button.setText("Start Service");
                state = true;


            }

        });


    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onPause() {
        super.onPause();

        /*
         Stop the Service when activity Paused , not service will  run in  until the Destroy
         Intent intent = new Intent(getApplicationContext(), MyService.class);
         stopService(intent);
        state = true;
         button.setText("Start Service");
        */

    }
}