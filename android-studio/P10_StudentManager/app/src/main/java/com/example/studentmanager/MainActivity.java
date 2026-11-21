package com.example.studentmanager;

import android.content.Intent;
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
        EditText etCourse = findViewById(R.id.etCourse);

        findViewById(R.id.btnSave).setOnClickListener(v -> {
            db.insert(etName.getText().toString(), etCourse.getText().toString());
            Toast.makeText(this, "Student saved", Toast.LENGTH_SHORT).show();
            etName.setText("");
            etCourse.setText("");
        });
        findViewById(R.id.btnList).setOnClickListener(v ->
                startActivity(new Intent(this, StudentListActivity.class)));
    }
}
