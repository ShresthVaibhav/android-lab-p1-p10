package com.example.intentdemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText etMsg = findViewById(R.id.etMsg);

        // Explicit Intent
        findViewById(R.id.btnNext).setOnClickListener(v -> {
            Intent i = new Intent(this, SecondActivity.class);
            i.putExtra("message", etMsg.getText().toString());
            startActivity(i);
        });

        // Implicit Intent
        findViewById(R.id.btnWeb).setOnClickListener(v -> {
            Intent i = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.dypatil.edu"));
            startActivity(i);
        });
    }
}
