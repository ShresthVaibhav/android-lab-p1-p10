Practical 1 - Introduction to Android
=====================================

AIM
To study the Android platform and its architecture, set up Android Studio and create a Hello World app.

THEORY
- Android = open-source, Linux-based mobile OS by Google. Apps written in Java/Kotlin, UI in XML, built in Android Studio (official IDE) using Gradle.
- Architecture (bottom to top, 5 layers):
  1. Linux Kernel - drivers, memory, power management
  2. HAL (Hardware Abstraction Layer) - standard interfaces to camera, sensors etc.
  3. Native Libraries + Android Runtime (ART) - C/C++ libs (SQLite, OpenGL, WebKit); ART runs the app
  4. Application Framework - Activity Manager, Window Manager, Content Providers, Notification Manager
  5. Applications - Phone, Browser, your app
- 4 app components: Activity (one screen), Service (background work), Broadcast Receiver (system-wide events like battery low), Content Provider (share data between apps).
- AndroidManifest.xml declares components, permissions, launcher activity, app name/theme.
- Build flow: Java/XML -> compiled -> .dex -> packed into APK -> installed on device/emulator (AVD).

FILES AND CODE EXPLAINED
activity_main.xml
  LinearLayout (vertical, gravity=center) holds one TextView with text "Hello World!". Layout = what the screen looks like.
MainActivity.java
  extends AppCompatActivity. onCreate() runs when the screen is created:
  super.onCreate(...) -> parent setup; setContentView(R.layout.activity_main) -> attaches the XML to this screen.
AndroidManifest.xml
  <activity .MainActivity> with intent-filter MAIN + LAUNCHER = the screen that opens when you tap the app icon.
app/build.gradle
  namespace/applicationId = package name, minSdk 24 (Android 7.0+), compileSdk/targetSdk 34.

HOW TO RUN
1. Android Studio > File > Open > select THIS folder (P01_HelloWorld).
2. Wait for Gradle sync (internet needed the first time).
3. Device Manager > start an emulator (or plug in a phone with USB debugging).
4. Press the green Run button.
If sync fails: File > Settings > Build > Gradle > Gradle JDK = jbr-17, then Sync Project with Gradle Files.

WHAT TO DO IN THE APP
Just launch. Nothing to tap.

FOR YOUR JOURNAL
Screenshot of Hello World screen.

VIVA QUESTIONS AND ANSWERS
Q: What is Android? A: Open-source Linux-based mobile OS by Google.
Q: Name the architecture layers. A: Linux Kernel, HAL, Native libs + ART, Application Framework, Applications.
Q: ART vs Dalvik? A: ART compiles ahead-of-time (AOT, faster, less battery); old Dalvik used JIT.
Q: What is an APK? A: Android Package, the installable app file.
Q: What is AVD? A: Android Virtual Device = emulator.
Q: What is the R class? A: Auto-generated; gives int ids to resources (R.layout.activity_main, R.id.tvHello).
Q: What is Bundle savedInstanceState? A: Saved state passed to onCreate (e.g. after rotation); null on first launch.
Q: What is Gradle? A: Build system that compiles code, manages dependencies, makes the APK.
Q: Difference dp vs sp? A: dp = size of views (density independent); sp = text size (respects user font setting).
Q: What is minSdk? A: Lowest Android version the app supports.
Q: Which file is the entry point? A: Activity with MAIN/LAUNCHER intent-filter in the manifest.
