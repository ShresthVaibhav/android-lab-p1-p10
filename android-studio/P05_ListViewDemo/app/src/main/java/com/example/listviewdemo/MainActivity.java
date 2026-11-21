package com.example.listviewdemo;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    String[] languages = {"Java", "Kotlin", "Python", "C++",
                          "JavaScript", "Swift", "Dart", "Go"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, languages);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) ->
                Toast.makeText(this, "Selected: " + languages[position],
                        Toast.LENGTH_SHORT).show());
    }
}
