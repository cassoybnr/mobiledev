package com.example.exercise02;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.exercise02.databinding.ActivityPasswordBinding;

public class PasswordActivity extends AppCompatActivity {

    private ActivityPasswordBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnSubmit.setOnClickListener(v -> validateLogin());
    }

    private void validateLogin() {

        String studentId = binding.etStudentId.getText().toString().trim();
        String password  = binding.etPassword.getText().toString().trim();


        if (studentId.length() < 2) {
            binding.tvResult.setText("Please enter a valid Student ID.");
            return;
        }


        String lastTwo = studentId.substring(studentId.length() - 2);

        String wallColor = "blue";
        String expectedPassword = wallColor + lastTwo;

        if (password.equalsIgnoreCase(expectedPassword)) {
            binding.tvResult.setText("✅ Access Granted! Welcome.");
        } else {
            binding.tvResult.setText("❌ Wrong password. Try again.");
        }
    }
}