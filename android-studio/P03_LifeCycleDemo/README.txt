Practical 3 - Activity Life Cycle
=================================

AIM
To study the Activity life cycle by overriding callback methods and observing their order.

THEORY
- An Activity moves through states; the system calls callbacks:
  onCreate()  - first created, set layout here
  onStart()   - becoming visible
  onResume()  - in foreground, user can interact (RUNNING)
  onPause()   - losing focus / partially covered (save light data, pause animations)
  onStop()    - no longer visible
  onRestart() - coming back after stop
  onDestroy() - being destroyed (release resources)
- Order: Launch = onCreate > onStart > onResume.
  Press Home = onPause > onStop. Reopen = onRestart > onStart > onResume.
  Press Back = onPause > onStop > onDestroy.
- Rotation destroys and recreates the activity (onPause, onStop, onDestroy, then onCreate, onStart, onResume).
- Three loops: entire lifetime (onCreate-onDestroy), visible lifetime (onStart-onStop), foreground lifetime (onResume-onPause).

FILES AND CODE EXPLAINED
MainActivity.java
  TAG = "LifeCycle" -> filter name in Logcat.
  show(msg): Log.d(TAG, msg) writes to Logcat + Toast shows on screen.
  Each callback calls super.xxx() FIRST (mandatory) then show("xxx called").
activity_main.xml
  Single centered TextView "Activity Life Cycle".

HOW TO RUN
1. Android Studio > File > Open > select THIS folder (P03_LifeCycleDemo).
2. Wait for Gradle sync (internet needed the first time).
3. Device Manager > start an emulator (or plug in a phone with USB debugging).
4. Press the green Run button.
If sync fails: File > Settings > Build > Gradle > Gradle JDK = jbr-17, then Sync Project with Gradle Files.

WHAT TO DO IN THE APP
Open Logcat, filter LifeCycle. Launch, press Home, reopen, press Back. Watch toasts + log order.

FOR YOUR JOURNAL
Toast on screen and Logcat output.

VIVA QUESTIONS AND ANSWERS
Q: List life cycle methods. A: onCreate, onStart, onResume, onPause, onStop, onRestart, onDestroy.
Q: Which method is called first / last? A: onCreate / onDestroy.
Q: Home button pressed? A: onPause, onStop (not destroyed).
Q: Back button pressed? A: onPause, onStop, onDestroy.
Q: Dialog or transparent activity covers the screen? A: Only onPause (still visible, so no onStop).
Q: onPause vs onStop? A: onPause = lost focus but may be visible; onStop = fully invisible.
Q: What happens on screen rotation? A: Activity destroyed and recreated; use onSaveInstanceState / ViewModel to keep data.
Q: Why call super.onXxx()? A: Parent class does required system work; skipping throws SuperNotCalledException.
Q: What is Logcat? A: Android Studio window showing system and app logs.
Q: Log levels? A: Log.v verbose, d debug, i info, w warn, e error.
Q: Where to release resources? A: onPause/onStop/onDestroy depending on resource (camera in onPause).
