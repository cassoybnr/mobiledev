package com.example.handson2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int mCounter = 0;
    private TextView myTextView;
    private TextView tvDepartment; // Added for Part 1 holds references sa text labels sa layout

    @Override
    protected void onCreate(Bundle savedInstanceState) { //standard startup
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //connect Java


        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("ID: 24100031");
        }


        tvDepartment = findViewById(R.id.tvDepartment);
        Button btnChangeName = findViewById(R.id.btnChangeName); 

        btnChangeName.setOnClickListener(new View.OnClickListener() { //listen
            @Override
            public void onClick(View v) {
                tvDepartment.setText("Ms. Angie M. Ceniza-Canillo"); //update
            }
        });

        myTextView = findViewById(R.id.tvCounter);
        Button btnIncrement = findViewById(R.id.btnIncrement);


        if (myTextView != null) {
            myTextView.setText(String.valueOf(mCounter));
        }

        btnIncrement.setOnClickListener(new View.OnClickListener() { //listen
            @Override
            public void onClick(View v) {
                mCounter++; //incremenent
                myTextView.setText(String.valueOf(mCounter)); //convert num to text
            }
        });
    }



    @Override
    protected void onSaveInstanceState(Bundle outState) { //save state before destroyed
        super.onSaveInstanceState(outState);
        outState.putInt("COUNT_KEY", mCounter); //pack curr count to bundle
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) { //runs when the activity restarts
        super.onRestoreInstanceState(savedInstanceState);
        mCounter = savedInstanceState.getInt("COUNT_KEY"); //unpack saved count num and baliok sa screen
        myTextView.setText(String.valueOf(mCounter));
    }
}
