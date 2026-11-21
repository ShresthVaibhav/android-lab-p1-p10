package com.example.studentmanager;

import android.content.*;
import android.database.Cursor;
import android.database.sqlite.*;
import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context c) { super(c, "students.db", null, 1); }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE student(id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + " name TEXT, course TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int o, int n) {
        db.execSQL("DROP TABLE IF EXISTS student");
        onCreate(db);
    }

    public void insert(String name, String course) {
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("course", course);
        getWritableDatabase().insert("student", null, cv);
    }

    public ArrayList<String> getAll(ArrayList<Integer> ids) {
        ArrayList<String> list = new ArrayList<>();
        Cursor c = getReadableDatabase().rawQuery("SELECT * FROM student", null);
        while (c.moveToNext()) {
            ids.add(c.getInt(0));
            list.add(c.getString(1) + " - " + c.getString(2));
        }
        c.close();
        return list;
    }

    public void delete(int id) {
        getWritableDatabase().delete("student", "id=?", new String[]{String.valueOf(id)});
    }
}
