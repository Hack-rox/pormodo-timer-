package com.example.pomodorotimer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
        TextView time ;
        Button start , pause  ;
        EditText settime ;

        CountDownTimer timer ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        time = findViewById(R.id.textView);
        start = findViewById(R.id.start);
        settime = findViewById(R.id.settime);
        pause = findViewById(R.id.cancel);




        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int min = Integer.parseInt(settime.getText().toString());
                int minute = min *600;

                timer = new  CountDownTimer(minute, 1000) {

                    @SuppressLint("SetTextI18n")
                    public void onTick(long millisUntilFinished) {
                        time.setText("" + millisUntilFinished / 1000);
                    }

                    @SuppressLint("SetTextI18n")
                    public void onFinish() {
                        time.setText("done!");
                    }
                }.start();


            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                timer.cancel();



            }
        });


    }
}