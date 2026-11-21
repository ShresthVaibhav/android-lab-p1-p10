package com.example.studentmanager;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.*;
import java.util.ArrayList;

public class StudentListActivity extends AppCompatActivity {
    DBHelper db;
    ListView listView;
    ArrayList<Integer> ids = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);
        db = new DBHelper(this);
        listView = findViewById(R.id.listView);
        loadList();

        listView.setOnItemLongClickListener((p, view, pos, id) -> {
            new AlertDialog.Builder(this)
                    .setTitle("Delete")
                    .setMessage("Delete this student?")
                    .setPositiveButton("Yes", (d, w) -> {
                        db.delete(ids.get(pos));
                        loadList();
                        Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show();
                    })
                    .setNegativeButton("No", null).show();
            return true;
        });
    }

    private void loadList() {
        ids.clear();
        listView.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, db.getAll(ids)));
    }
}
