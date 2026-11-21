package com.example.dialogdemo;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    String[] colors = {"Red", "Green", "Blue"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnAlert).setOnClickListener(v ->
                new AlertDialog.Builder(this)
                        .setTitle("Exit")
                        .setMessage("Do you want to exit the app?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", (d, w) -> finish())
                        .setNegativeButton("No", (d, w) -> d.dismiss())
                        .show());

        findViewById(R.id.btnChoice).setOnClickListener(v ->
                new AlertDialog.Builder(this)
                        .setTitle("Pick a colour")
                        .setItems(colors, (d, which) ->
                                Toast.makeText(this, "You chose " + colors[which],
                                        Toast.LENGTH_SHORT).show())
                        .show());
    }
}
