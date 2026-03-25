package com.example.echoapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityLog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate method has successfully started.");

        EditText etMessage = findViewById(R.id.etMessage);
        Button btnSend = findViewById(R.id.btnSend);
        Button btnShare = findViewById(R.id.btnShare);

        btnSend.setOnClickListener(v -> {
            String message = etMessage.getText().toString();
            Log.i(TAG, "User clicked Send. Message: " + message);

            Intent intent = new Intent(MainActivity.this, EchoActivity.class); // [cite: 311]
            intent.putExtra("USER_MESSAGE", message);
            startActivity(intent);
        });


        btnShare.setOnClickListener(v -> {
            String message = etMessage.getText().toString();
            Log.d(TAG, "Implicit Intent triggered for message: " + message); // [cite: 346]


            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain"); // Set data type to plain text
            shareIntent.putExtra(Intent.EXTRA_TEXT, message); // Add text as an extra


            startActivity(Intent.createChooser(shareIntent, "Share message via:"));
        });
    }
}