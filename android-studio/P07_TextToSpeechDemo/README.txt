Practical 7 - Text To Speech Converter
======================================

AIM
To build an app that converts typed text into speech using the TextToSpeech API.

THEORY
- TextToSpeech class (android.speech.tts) synthesizes speech from text.
- Engine initialisation is ASYNCHRONOUS; result comes in TextToSpeech.OnInitListener (status SUCCESS or ERROR).
- Methods: setLanguage(Locale), setPitch(), setSpeechRate(), speak(text, queueMode, params, utteranceId), stop(), shutdown().
- QUEUE_FLUSH = drop pending speech and speak now; QUEUE_ADD = add to queue.
- Always shutdown() in onDestroy to release the engine.

FILES AND CODE EXPLAINED
MainActivity.java
  tts = new TextToSpeech(this, status -> { if SUCCESS: setLanguage(Locale.US); setSpeechRate(1.0f); }) -> init.
  btnSpeak click: read text; if empty -> Toast; else tts.speak(text, QUEUE_FLUSH, null, "tts1").
  onDestroy(): tts.stop(); tts.shutdown(); then super.onDestroy().
AndroidManifest.xml
  <queries> with TTS_SERVICE action: needed on Android 11+ so the app can see the TTS engine.

HOW TO RUN
1. Android Studio > File > Open > select THIS folder (P07_TextToSpeechDemo).
2. Wait for Gradle sync (internet needed the first time).
3. Device Manager > start an emulator (or plug in a phone with USB debugging).
4. Press the green Run button.
If sync fails: File > Settings > Build > Gradle > Gradle JDK = jbr-17, then Sync Project with Gradle Files.

WHAT TO DO IN THE APP
Volume up. Type text > SPEAK -> you hear it + toast 'Speaking...'. (Emulator silent? use Google Play image or real phone.)

FOR YOUR JOURNAL
Text entered with Speaking toast.

VIVA QUESTIONS AND ANSWERS
Q: What is TTS? A: Converting text to spoken audio.
Q: Why OnInitListener? A: Engine starts asynchronously; listener tells when it is ready.
Q: QUEUE_FLUSH vs QUEUE_ADD? A: Flush replaces pending speech; add appends.
Q: Why shutdown()? A: Frees engine resources, avoids leaks.
Q: How to change voice speed/pitch? A: setSpeechRate(), setPitch() (1.0 = normal).
Q: How to change language? A: setLanguage(new Locale("hi","IN")); check result for LANG_MISSING_DATA / LANG_NOT_SUPPORTED.
Q: What is utteranceId? A: Identifier to track when a specific speech starts/finishes (UtteranceProgressListener).
Q: Reverse of TTS? A: Speech-to-text (SpeechRecognizer / RecognizerIntent).
Q: Why <queries>? A: Package visibility rules on Android 11+.
Q: Is internet needed? A: Not for offline voices, depends on the engine installed.
