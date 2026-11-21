Practical 5 - Adapters and ListView
===================================

AIM
To display a list using ListView and ArrayAdapter and handle item clicks.

THEORY
- Adapter = bridge between data source (array, list, database) and an AdapterView (ListView, GridView, Spinner). It creates a View for each data item.
- ArrayAdapter: simplest; binds an array/List to a layout with one TextView (android.R.layout.simple_list_item_1).
- Other adapters: SimpleAdapter, CursorAdapter, custom BaseAdapter.
- ListView = vertically scrolling list; click handled with setOnItemClickListener.
- Views are recycled while scrolling so only visible rows exist in memory.

FILES AND CODE EXPLAINED
activity_main.xml
  One ListView (id listView) filling the screen.
MainActivity.java
  languages[] = data source.
  new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, languages) -> context, row layout, data.
  listView.setAdapter(adapter) -> connects data to list.
  setOnItemClickListener((parent, view, position, id) -> Toast of languages[position]).
  position = index of clicked row (0 based).

HOW TO RUN
1. Android Studio > File > Open > select THIS folder (P05_ListViewDemo).
2. Wait for Gradle sync (internet needed the first time).
3. Device Manager > start an emulator (or plug in a phone with USB debugging).
4. Press the green Run button.
If sync fails: File > Settings > Build > Gradle > Gradle JDK = jbr-17, then Sync Project with Gradle Files.

WHAT TO DO IN THE APP
Tap any item (e.g. Kotlin) -> toast 'Selected: Kotlin'. Scroll to see all 8.

FOR YOUR JOURNAL
List with toast after tapping an item.

VIVA QUESTIONS AND ANSWERS
Q: What is an adapter? A: Connects data source to AdapterView and supplies row views.
Q: ArrayAdapter parameters? A: Context, layout resource, data array/list.
Q: simple_list_item_1? A: Built-in row layout with a single TextView.
Q: Name AdapterViews. A: ListView, GridView, Spinner, Gallery.
Q: Other adapters? A: SimpleAdapter, CursorAdapter, BaseAdapter (custom).
Q: What does position mean? A: Index of clicked item.
Q: ListView vs RecyclerView? A: RecyclerView is newer, enforces ViewHolder, more flexible and efficient.
Q: What is ViewHolder? A: Pattern to cache row views and avoid repeated findViewById.
Q: How to update list after data change? A: adapter.notifyDataSetChanged().
Q: Single vs multiple choice list? A: setChoiceMode(CHOICE_MODE_SINGLE / MULTIPLE).
