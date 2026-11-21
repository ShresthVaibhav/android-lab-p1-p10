# Computer Workshop-II (Android) Lab - Practicals 1 to 10

Course code **U24AIMLVSC510**, Semester V, B.Tech CSE (AI/ML), D. Y. Patil University, Pune.

Each practical is available two ways:

| Folder | What it is |
|---|---|
| `android-studio/` | Ready-to-open Android Studio projects (Java), one folder per practical |
| `app-inventor/` | MIT App Inventor `.aia` versions of the same ten practicals |

## Practicals

| No | Title | Android Studio project |
|---|---|---|
| 1 | Introduction to Android | `P01_HelloWorld` |
| 2 | Study of UI in Android | `P02_UIDemo` |
| 3 | Study of Activity Life Cycle | `P03_LifeCycleDemo` |
| 4 | Study of Intents | `P04_IntentDemo` |
| 5 | Adapters and Views (ListView) | `P05_ListViewDemo` |
| 6 | Study of Dialogs | `P06_DialogDemo` |
| 7 | Text To Speech Converter | `P07_TextToSpeechDemo` |
| 8 | Telephony (SmsManager) | `P08_SmsDemo` |
| 9 | SQLite database | `P09_SQLiteDemo` |
| 10 | App using all components and database | `P10_StudentManager` |

## Run an Android Studio project

1. Clone or download this repo.
2. Android Studio > File > Open > pick **one** folder inside `android-studio/` (for example `P10_StudentManager`).
3. Wait for Gradle sync (internet needed the first time), start an emulator, press Run.

Every project folder has its own `README.txt` with the aim, theory, code explanation, steps, and viva questions with answers.

Requirements: Android Studio Koala or newer, JDK 17 (bundled), minSdk 24, compileSdk 34.

## Run the App Inventor version

Go to [ai2.appinventor.mit.edu](https://ai2.appinventor.mit.edu), then Projects > Import project (.aia) from my computer. Details in `app-inventor/README_AppInventor.txt`.

## Testing status

- Android Studio projects: all Java sources compile against the Android API 33 `android.jar`, and layout ids, manifests and packages were cross-checked by script. Not yet built with Gradle or run on a device.
- App Inventor files: structurally validated only, not imported into App Inventor yet.
