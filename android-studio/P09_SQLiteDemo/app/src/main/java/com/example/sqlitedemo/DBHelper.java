package com.example.sqlitedemo;

import android.content.*;
import android.database.Cursor;
import android.database.sqlite.*;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context c) { super(c, "college.db", null, 1); }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE student(id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + " name TEXT, marks INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int o, int n) {
        db.execSQL("DROP TABLE IF EXISTS student");
        onCreate(db);
    }

    public boolean insert(String name, int marks) {
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("marks", marks);
        return getWritableDatabase().insert("student", null, cv) != -1;
    }

    public Cursor getAll() {
        return getReadableDatabase().rawQuery("SELECT * FROM student", null);
    }
}
