package com.example.lifecycledemo;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "LifeCycle";

    private void show(String msg) {
        Log.d(TAG, msg);
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show("onCreate called");
    }
    @Override protected void onStart()   { super.onStart();   show("onStart called"); }
    @Override protected void onResume()  { super.onResume();  show("onResume called"); }
    @Override protected void onPause()   { super.onPause();   show("onPause called"); }
    @Override protected void onStop()    { super.onStop();    show("onStop called"); }
    @Override protected void onRestart() { super.onRestart(); show("onRestart called"); }
    @Override protected void onDestroy() { super.onDestroy(); show("onDestroy called"); }
}
