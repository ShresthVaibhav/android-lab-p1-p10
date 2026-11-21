Practical 8 - Telephony (SmsManager)
====================================

AIM
To study the Telephony framework by sending an SMS using SmsManager.

THEORY
- android.telephony package: phone state (TelephonyManager) and SMS (SmsManager).
- SmsManager.getDefault() (deprecated; API 31+ use getSystemService(SmsManager.class)).
- sendTextMessage(destination, scAddress, text, sentIntent, deliveryIntent). scAddress null = default SMSC. divideMessage() / sendMultipartTextMessage() for long text (>160 chars).
- SEND_SMS is a DANGEROUS permission: declare in manifest AND request at runtime (Android 6.0+) using ActivityCompat.requestPermissions().
- Normal permissions (INTERNET) are granted automatically at install.

FILES AND CODE EXPLAINED
AndroidManifest.xml
  <uses-permission SEND_SMS/> and <uses-feature telephony required=false> (so it installs on emulators/tablets).
MainActivity.java
  requestPermissions(...) on start -> popup.
  Button click: checkSelfPermission(SEND_SMS) != GRANTED -> Toast 'Permission denied'.
  Else SmsManager.getDefault().sendTextMessage(phone, null, msg, null, null) inside try/catch.
Layout: etPhone (inputType phone), etMsg, btnSend.

HOW TO RUN
1. Android Studio > File > Open > select THIS folder (P08_SmsDemo).
2. Wait for Gradle sync (internet needed the first time).
3. Device Manager > start an emulator (or plug in a phone with USB debugging).
4. Press the green Run button.
If sync fails: File > Settings > Build > Gradle > Gradle JDK = jbr-17, then Sync Project with Gradle Files.

WHAT TO DO IN THE APP
Allow permission. Number: other emulator port (e.g. 5556) or real number. Type message > SEND SMS -> toast. If it fails read the toast text; try emulator-to-emulator.

FOR YOUR JOURNAL
Permission popup and SMS sent toast.

VIVA QUESTIONS AND ANSWERS
Q: Which class sends SMS? A: android.telephony.SmsManager.
Q: Permission needed? A: SEND_SMS (manifest + runtime).
Q: Dangerous vs normal permission? A: Dangerous affects privacy, needs user approval at runtime; normal is auto-granted.
Q: Parameters of sendTextMessage? A: destination, service-centre address, text, sentIntent, deliveryIntent.
Q: Send SMS longer than 160 chars? A: divideMessage() + sendMultipartTextMessage().
Q: How to know SMS was sent/delivered? A: Pass PendingIntents (sentIntent / deliveryIntent) and use a BroadcastReceiver.
Q: Why try/catch? A: Invalid number or no permission throws exceptions.
Q: TelephonyManager? A: Gives phone info (network operator, call state, IMEI needs permission).
Q: SMS vs MMS? A: MMS carries multimedia.
Q: How to test on emulator? A: Use another running emulator's port (5554, 5556...) as the number.
Q: Is getDefault() deprecated? A: Yes from API 31; use context.getSystemService(SmsManager.class).
