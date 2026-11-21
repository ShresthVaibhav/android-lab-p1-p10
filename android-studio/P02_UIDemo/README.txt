Practical 2 - Study of UI in Android
====================================

AIM
To design a UI using layouts and basic widgets (TextView, EditText, Button) and handle a button click.

THEORY
- UI is built from View (visible widget: TextView, EditText, Button, ImageView, CheckBox) and ViewGroup (invisible container that arranges views: LinearLayout, RelativeLayout, ConstraintLayout, FrameLayout).
- Layout is written in XML (res/layout) and linked to Java using findViewById(R.id.xxx).
- Events are handled with listeners, e.g. View.OnClickListener via setOnClickListener().
- Toast = small popup message that disappears automatically.
- LinearLayout arranges children in one row/column (orientation vertical/horizontal).

FILES AND CODE EXPLAINED
activity_main.xml
  Vertical LinearLayout (padding 24dp) with EditText (etName, hint), Button (btnSubmit), TextView (tvResult).
  match_parent = fill parent; wrap_content = only as big as content.
MainActivity.java
  findViewById x3 -> connect XML views to Java variables.
  btnSubmit.setOnClickListener(v -> {...}) -> lambda runs on click.
  getText().toString().trim() -> read the input, remove spaces.
  If empty -> Toast "Please enter a name"; else tvResult.setText("Welcome, " + name + "!") and Toast "Submitted".

HOW TO RUN
1. Android Studio > File > Open > select THIS folder (P02_UIDemo).
2. Wait for Gradle sync (internet needed the first time).
3. Device Manager > start an emulator (or plug in a phone with USB debugging).
4. Press the green Run button.
If sync fails: File > Settings > Build > Gradle > Gradle JDK = jbr-17, then Sync Project with Gradle Files.

WHAT TO DO IN THE APP
Type a name (e.g. Rahul) > tap SUBMIT -> 'Welcome, Rahul!' + toast. Tap SUBMIT with empty box -> 'Please enter a name'.

FOR YOUR JOURNAL
Initial screen and screen after Submit.

VIVA QUESTIONS AND ANSWERS
Q: View vs ViewGroup? A: View = widget; ViewGroup = container of views.
Q: Name layouts. A: Linear, Relative, Constraint, Frame, Table, Grid.
Q: What does findViewById do? A: Finds a view in the layout by its id and returns the object.
Q: What is a listener? A: Interface/callback that responds to events like click.
Q: match_parent vs wrap_content? A: Fill parent vs fit content.
Q: padding vs margin? A: Padding = space inside the view; margin = space outside.
Q: hint vs text? A: Hint is grey placeholder that disappears when typing; text is real content.
Q: What is a Toast? A: Short auto-disappearing message. LENGTH_SHORT ~2s, LENGTH_LONG ~3.5s.
Q: Why trim()? A: Removes leading/trailing spaces so " " counts as empty.
Q: What is a lambda here? A: Short form of new View.OnClickListener(){ onClick(View v){...} }.
Q: ConstraintLayout? A: Flexible layout positioning views using constraints to parent/siblings; fewer nested layouts.
