package com.example.uidemo;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etName = findViewById(R.id.etName);
        Button btnSubmit = findViewById(R.id.btnSubmit);
        TextView tvResult = findViewById(R.id.tvResult);

        btnSubmit.setOnClickListener(v -> {
            String name = etName.getText().toString().trim();
            if (name.isEmpty()) {
                Toast.makeText(this, "Please enter a name", Toast.LENGTH_SHORT).show();
            } else {
                tvResult.setText("Welcome, " + name + "!");
                Toast.makeText(this, "Submitted", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
