package com.example.echoapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class EchoActivity extends AppCompatActivity {
    private static final String TAG = "EchoActivityLog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_echo);

        Log.d(TAG, "EchoActivity launched.");

        Intent intent = getIntent();
        String message = intent.getStringExtra("USER_MESSAGE");

        if (message != null) {
            TextView tvDisplay = findViewById(R.id.tvDisplay);
            tvDisplay.setText(message);
            Log.d(TAG, "Message successfully echoed: " + message);
        }
    }
}
