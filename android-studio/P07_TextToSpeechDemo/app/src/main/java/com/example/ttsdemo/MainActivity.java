package com.example.ttsdemo;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText etText = findViewById(R.id.etText);
        Button btnSpeak = findViewById(R.id.btnSpeak);

        tts = new TextToSpeech(this, status -> {
            if (status == TextToSpeech.SUCCESS) {
                tts.setLanguage(Locale.US);
                tts.setSpeechRate(1.0f);
            }
        });

        btnSpeak.setOnClickListener(v -> {
            String text = etText.getText().toString().trim();
            if (text.isEmpty()) {
                Toast.makeText(this, "Enter some text", Toast.LENGTH_SHORT).show();
                return;
            }
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "tts1");
            Toast.makeText(this, "Speaking...", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    protected void onDestroy() {
        if (tts != null) { tts.stop(); tts.shutdown(); }
        super.onDestroy();
    }
}
