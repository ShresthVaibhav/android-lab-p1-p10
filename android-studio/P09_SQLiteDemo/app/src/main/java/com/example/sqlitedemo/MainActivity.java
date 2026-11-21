package com.example.sqlitedemo;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBHelper db = new DBHelper(this);
        EditText etName = findViewById(R.id.etName);
        EditText etMarks = findViewById(R.id.etMarks);
        TextView tvData = findViewById(R.id.tvData);

        findViewById(R.id.btnAdd).setOnClickListener(v -> {
            String marks = etMarks.getText().toString().trim();
            if (marks.isEmpty()) {
                Toast.makeText(this, "Enter marks", Toast.LENGTH_SHORT).show();
                return;
            }
            boolean ok = db.insert(etName.getText().toString(), Integer.parseInt(marks));
            Toast.makeText(this, ok ? "Record inserted" : "Insert failed",
                    Toast.LENGTH_SHORT).show();
        });

        findViewById(R.id.btnView).setOnClickListener(v -> {
            Cursor c = db.getAll();
            StringBuilder sb = new StringBuilder("ID   Name   Marks\n");
            while (c.moveToNext())
                sb.append(c.getInt(0)).append("    ").append(c.getString(1))
                  .append("    ").append(c.getInt(2)).append("\n");
            c.close();
            tvData.setText(sb.toString());
        });
    }
}
