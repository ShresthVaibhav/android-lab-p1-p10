package com.example.smsdemo;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText etPhone = findViewById(R.id.etPhone);
        EditText etMsg = findViewById(R.id.etMsg);

        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.SEND_SMS}, 1);

        findViewById(R.id.btnSend).setOnClickListener(v -> {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)
                    != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
                return;
            }
            try {
                SmsManager sms = SmsManager.getDefault();
                sms.sendTextMessage(etPhone.getText().toString(), null,
                        etMsg.getText().toString(), null, null);
                Toast.makeText(this, "SMS sent successfully", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Toast.makeText(this, "SMS failed: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
