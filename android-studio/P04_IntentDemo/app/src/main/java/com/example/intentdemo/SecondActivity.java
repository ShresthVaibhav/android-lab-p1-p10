package com.example.intentdemo;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView tv = findViewById(R.id.tvReceived);
        String msg = getIntent().getStringExtra("message");
        tv.setText("Received: " + msg);
    }
}
