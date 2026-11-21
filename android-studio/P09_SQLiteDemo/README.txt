Practical 9 - SQLite database
=============================

AIM
To study SQLite in Android by creating a table and doing insert and view on student records.

THEORY
- SQLite = lightweight, serverless, relational DB built into Android. Each app's DB is private: /data/data/<package>/databases/.
- SQLiteOpenHelper manages creation and versioning: onCreate() (first time) and onUpgrade() (when version number increases).
- getWritableDatabase() / getReadableDatabase() open the DB.
- insert() with ContentValues (column-value pairs); query()/rawQuery() return a Cursor; update(); delete().
- Cursor = pointer to result rows; moveToNext() walks rows; getInt/getString(columnIndex); close() when done.

FILES AND CODE EXPLAINED
DBHelper.java
  super(c, "college.db", null, 1) -> db name, factory, version.
  onCreate: CREATE TABLE student(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, marks INTEGER).
  onUpgrade: drop table and recreate.
  insert(): ContentValues cv.put("name",..); put("marks",..); returns true if row id != -1.
  getAll(): rawQuery("SELECT * FROM student").
MainActivity.java
  btnAdd -> validates marks not empty, db.insert(), Toast.
  btnView -> loop cursor with moveToNext(), build text with StringBuilder, show in tvData, close cursor.

HOW TO RUN
1. Android Studio > File > Open > select THIS folder (P09_SQLiteDemo).
2. Wait for Gradle sync (internet needed the first time).
3. Device Manager > start an emulator (or plug in a phone with USB debugging).
4. Press the green Run button.
If sync fails: File > Settings > Build > Gradle > Gradle JDK = jbr-17, then Sync Project with Gradle Files.

WHAT TO DO IN THE APP
Enter Name + Marks > ADD (toast). Repeat 2-3 times. Tap VIEW -> table appears.

FOR YOUR JOURNAL
Record inserted + view all records.

VIVA QUESTIONS AND ANSWERS
Q: What is SQLite? A: Embedded, serverless, zero-config SQL database in Android.
Q: Role of SQLiteOpenHelper? A: Creates/opens DB and manages version upgrades.
Q: onCreate vs onUpgrade? A: onCreate on first creation; onUpgrade when version increases.
Q: getWritableDatabase vs getReadableDatabase? A: Writable allows changes; readable for queries (may return writable one).
Q: What is ContentValues? A: Map of column names to values for insert/update.
Q: What is Cursor? A: Result set pointer over query rows.
Q: Why close the cursor? A: Frees resources, avoids leaks.
Q: insert() returns? A: New row id, or -1 on error.
Q: query() vs rawQuery()? A: query builds SQL from parameters; rawQuery takes a raw SQL string.
Q: Where is the DB stored? A: Private app folder /data/data/<package>/databases/.
Q: What is AUTOINCREMENT? A: Auto-generates unique increasing primary key.
Q: SQLite vs SharedPreferences? A: SQLite for structured/relational data; SharedPreferences for small key-value settings.
Q: What is Room? A: Jetpack abstraction layer over SQLite with annotations and compile-time checks.
Q: How to avoid SQL injection? A: Use placeholders (?) with whereArgs / bind args.
