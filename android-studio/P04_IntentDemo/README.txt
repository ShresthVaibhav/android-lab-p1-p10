Practical 4 - Study of Intents
==============================

AIM
To study explicit and implicit Intents by moving between activities with data and opening a web page.

THEORY
- Intent = messaging object to request an action from another component: start activity, start service, send broadcast.
- Explicit Intent: names the exact class, e.g. new Intent(this, SecondActivity.class). Used inside same app.
- Implicit Intent: states an action (ACTION_VIEW, ACTION_DIAL, ACTION_SEND) + data (Uri); system finds a matching app (browser, dialer...).
- Data between activities: putExtra(key, value) and getIntent().getStringExtra(key).
- Every activity must be declared in AndroidManifest.xml.

FILES AND CODE EXPLAINED
MainActivity.java
  Explicit: new Intent(this, SecondActivity.class); i.putExtra("message", text); startActivity(i).
  Implicit: new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dypatil.edu")); startActivity(i) -> browser opens.
SecondActivity.java
  getIntent().getStringExtra("message") reads the data; setText("Received: " + msg).
AndroidManifest.xml
  <activity .SecondActivity> declared (without it the app crashes).
Layouts: activity_main (etMsg, btnNext, btnWeb), activity_second (tvReceived).

HOW TO RUN
1. Android Studio > File > Open > select THIS folder (P04_IntentDemo).
2. Wait for Gradle sync (internet needed the first time).
3. Device Manager > start an emulator (or plug in a phone with USB debugging).
4. Press the green Run button.
If sync fails: File > Settings > Build > Gradle > Gradle JDK = jbr-17, then Sync Project with Gradle Files.

WHAT TO DO IN THE APP
Type message > NEXT -> second screen shows it. Back > OPEN WEBSITE -> browser opens (needs internet).

FOR YOUR JOURNAL
MainActivity, SecondActivity, Browser.

VIVA QUESTIONS AND ANSWERS
Q: What is an Intent? A: Message object used to request an action from another component.
Q: Explicit vs implicit? A: Explicit names the target class; implicit gives an action and system picks the app.
Q: How to pass data? A: putExtra() / getStringExtra() (stored in a Bundle).
Q: Uses of Intent? A: Start activity, start service, deliver broadcast.
Q: startActivity vs startActivityForResult? A: Second one expects a result back (now replaced by Activity Result API).
Q: What is an intent-filter? A: Declares which implicit intents a component can handle.
Q: ACTION_DIAL vs ACTION_CALL? A: DIAL opens dialer (no permission); CALL calls directly (needs CALL_PHONE permission).
Q: What is Uri.parse? A: Converts a string into a Uri object.
Q: What if activity not in manifest? A: ActivityNotFoundException crash.
Q: What is PendingIntent? A: Intent wrapper that lets another app/system fire it later (notifications, alarms).
Q: Intent extras types? A: String, int, boolean, Serializable, Parcelable, etc.
