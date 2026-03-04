package com.example.handson2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int mCounter = 0;
    private TextView myTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("ID: 24100031");
        }

        myTextView = findViewById(R.id.tvCounter);
        Button btnIncrement = findViewById(R.id.btnIncrement);

        if (savedInstanceState != null) {
            mCounter = savedInstanceState.getInt("COUNT_KEY");
            myTextView.setText(String.valueOf(mCounter));
        }

        btnIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCounter++;
                myTextView.setText(String.valueOf(mCounter));
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("COUNT_KEY", mCounter);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mCounter = savedInstanceState.getInt("COUNT_KEY");
        myTextView.setText(String.valueOf(mCounter));
    }
}