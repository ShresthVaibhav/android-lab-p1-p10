Practical 10 - Student Manager (all components + database)
==========================================================

AIM
To develop an app combining Activities, widgets, Intents, ListView with Adapter, Dialogs, Toasts and SQLite.

THEORY
- Activities = screens; layouts/widgets = UI; Intents = navigation; Adapter = binds data to ListView; Dialog = confirm actions; Toast = feedback; SQLite = persistent storage.
- Flow: MainActivity saves student to SQLite > explicit Intent opens StudentListActivity > ListView shows all records through ArrayAdapter > long-press an item > AlertDialog asks confirmation > record deleted > list refreshed.
- Data is persistent: stays after the app closes.

FILES AND CODE EXPLAINED
DBHelper.java
  Table student(id, name, course). insert(name, course); delete(id) using delete("student","id=?", new String[]{id}) (parameterised);
  getAll(ids) fills list of "name - course" strings AND fills the ids list with DB row ids.
MainActivity.java
  btnSave -> db.insert(), Toast, clear boxes. btnList -> explicit Intent to StudentListActivity.
StudentListActivity.java
  loadList(): ids.clear(); builds new ArrayAdapter from db.getAll(ids); setAdapter.
  setOnItemLongClickListener: shows AlertDialog "Delete this student?" Yes -> db.delete(ids.get(pos)); loadList(); Toast. Returns true = event consumed (no normal click after).
  ids list maps list POSITION -> database ID, that is how the correct row gets deleted.
AndroidManifest.xml
  Both activities declared.

HOW TO RUN
1. Android Studio > File > Open > select THIS folder (P10_StudentManager).
2. Wait for Gradle sync (internet needed the first time).
3. Device Manager > start an emulator (or plug in a phone with USB debugging).
4. Press the green Run button.
If sync fails: File > Settings > Build > Gradle > Gradle JDK = jbr-17, then Sync Project with Gradle Files.

WHAT TO DO IN THE APP
Enter Name + Course > SAVE (add few). VIEW STUDENTS -> list. Long-press a student > Yes to delete.

FOR YOUR JOURNAL
Save screen, student list, delete confirmation.

VIVA QUESTIONS AND ANSWERS
Q: Explain the flow of your app. A: Save to SQLite > Intent > list via ArrayAdapter > long-press > dialog > delete > refresh.
Q: Why is the ids list used? A: List position differs from DB id; ids.get(pos) gives the real row id to delete.
Q: Why does the long-click listener return true? A: It means the event is handled; otherwise onItemClick may also fire.
Q: How is deletion safe from SQL injection? A: Uses where clause "id=?" with whereArgs.
Q: How is list refreshed? A: loadList() rebuilds the adapter (better: update list + notifyDataSetChanged, or use RecyclerView).
Q: Which components are used? A: Activity, Intent, ListView, Adapter, AlertDialog, Toast, SQLite.
Q: Explicit intent used where? A: MainActivity to StudentListActivity.
Q: Why must StudentListActivity be in the manifest? A: Unregistered activities cause a crash.
Q: Why close Cursor? A: Prevents resource leak.
Q: How would you add edit/update? A: db.update() with ContentValues and "id=?" + a dialog with EditText.
Q: Improvements? A: Room database, RecyclerView, validation, search, background thread for DB.
Q: Does data persist after closing the app? A: Yes, stored in SQLite file.
