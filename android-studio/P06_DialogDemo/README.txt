Practical 6 - Study of Dialogs
==============================

AIM
To create an AlertDialog with buttons and a list dialog.

THEORY
- Dialog = small window asking the user to decide or enter info without filling the whole screen.
- AlertDialog (via AlertDialog.Builder): title, message, up to 3 buttons (Positive, Negative, Neutral), list of items, or custom layout.
- Other dialogs: DatePickerDialog, TimePickerDialog, progress indicators (ProgressDialog is deprecated, use ProgressBar).
- setCancelable(false) = does not close when touching outside or pressing Back.
- Dialog is modal (blocks interaction) unlike a Toast.

FILES AND CODE EXPLAINED
MainActivity.java
  Alert: Builder(this).setTitle("Exit").setMessage(...).setCancelable(false)
    .setPositiveButton("Yes", -> finish())   finish() closes the activity/app
    .setNegativeButton("No",  -> d.dismiss()) closes the dialog
    .show().
  List: .setItems(colors, (d, which) -> Toast of colors[which]); which = index chosen. Dialog auto-closes on pick.
Layout: two buttons btnAlert, btnChoice.

HOW TO RUN
1. Android Studio > File > Open > select THIS folder (P06_DialogDemo).
2. Wait for Gradle sync (internet needed the first time).
3. Device Manager > start an emulator (or plug in a phone with USB debugging).
4. Press the green Run button.
If sync fails: File > Settings > Build > Gradle > Gradle JDK = jbr-17, then Sync Project with Gradle Files.

WHAT TO DO IN THE APP
SHOW ALERT: No closes, Yes exits app. SHOW LIST: pick colour -> toast 'You chose Blue'.

FOR YOUR JOURNAL
Alert dialog, list dialog, toast after choosing.

VIVA QUESTIONS AND ANSWERS
Q: What is a dialog? A: Small window for decisions/input over the current screen.
Q: Types of dialog? A: AlertDialog, DatePickerDialog, TimePickerDialog, custom dialog.
Q: Max buttons in AlertDialog? A: 3 (positive, negative, neutral).
Q: What does setCancelable(false) do? A: User must press a button; outside touch/Back won't close it.
Q: dismiss() vs cancel()? A: dismiss closes it; cancel closes and triggers OnCancelListener.
Q: Dialog vs Toast? A: Dialog needs user action; Toast is passive and auto-hides.
Q: Dialog vs Snackbar? A: Snackbar appears at bottom with optional action, non-blocking.
Q: setItems vs setSingleChoiceItems? A: setItems = click closes dialog; singleChoice shows radio buttons.
Q: What is DialogFragment? A: Recommended way to host a dialog; survives rotation.
Q: What does finish() do? A: Closes the current activity.
