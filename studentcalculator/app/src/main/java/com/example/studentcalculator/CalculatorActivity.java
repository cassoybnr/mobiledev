package com.example.studentcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class CalculatorActivity extends AppCompatActivity {

    private TextView tvDisplay;
    private String currentInput = "";
    private String operator = "";
    private double firstOperand = 0;

    // Keys used to store state values during screen rotation
    private static final String KEY_INPUT = "currentInput";
    private static final String KEY_OPERATOR = "operator";
    private static final String KEY_FIRST_OPERAND = "firstOperand";
    private static final String KEY_DISPLAY = "display";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        tvDisplay = findViewById(R.id.tvDisplay);

        if (savedInstanceState != null) {
            currentInput = savedInstanceState.getString(KEY_INPUT, "");
            operator = savedInstanceState.getString(KEY_OPERATOR, "");
            firstOperand = savedInstanceState.getDouble(KEY_FIRST_OPERAND, 0);
            tvDisplay.setText(savedInstanceState.getString(KEY_DISPLAY, "0"));
        }

        View.OnClickListener calculatorListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button) v;
                String buttonText = button.getText().toString();
                int id = v.getId();

                if (id == R.id.btnClear) {
                    currentInput = "";
                    operator = "";
                    firstOperand = 0;
                    tvDisplay.setText("0");
                } else if (id == R.id.btnAdd || id == R.id.btnSubtract ||
                        id == R.id.btnMultiply || id == R.id.btnDivide) {
                    if (!currentInput.isEmpty()) {
                        firstOperand = Double.parseDouble(currentInput);
                        operator = buttonText;
                        currentInput = "";
                    }
                } else if (id == R.id.btnEquals) {
                    if (!currentInput.isEmpty() && !operator.isEmpty()) {
                        double secondOperand = Double.parseDouble(currentInput);
                        double result = calculateResult(firstOperand, secondOperand, operator);

                        displayResult(result);
                        currentInput = tvDisplay.getText().toString();
                        operator = "";
                    }
                } else {
                    currentInput += buttonText;
                    tvDisplay.setText(currentInput);
                }
            }
        };

        int[] buttonIds = {
                R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
                R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9,
                R.id.btnAdd, R.id.btnSubtract, R.id.btnMultiply, R.id.btnDivide,
                R.id.btnClear, R.id.btnEquals
        };

        for (int id : buttonIds) {
            findViewById(id).setOnClickListener(calculatorListener);
        }

        // Task 1: Show ID
        findViewById(R.id.btnShowId).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String studentId = getIntent().getStringExtra("STUDENT_ID");
                if (studentId != null) {
                    tvDisplay.setText(studentId);
                    currentInput = studentId;
                }
            }
        });

        // Task 2: Square (x²)
        findViewById(R.id.btnSquare).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String displayText = tvDisplay.getText().toString();
                if (!displayText.isEmpty()) {
                    try {
                        double value = Double.parseDouble(displayText);
                        double result = value * value;
                        displayResult(result);
                        currentInput = tvDisplay.getText().toString();
                    } catch (NumberFormatException e) {
                    }
                }
            }
        });

        // Task 3: Turn Off
        findViewById(R.id.btnTurnOff).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CalculatorActivity.this, GoodbyeActivity.class);
                startActivity(intent);
            }
        });
    }

    private void displayResult(double result) {
        if (result == (long) result) {
            tvDisplay.setText(String.format("%d", (long) result));
        } else {
            tvDisplay.setText(String.valueOf(result));
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_INPUT, currentInput);
        outState.putString(KEY_OPERATOR, operator);
        outState.putDouble(KEY_FIRST_OPERAND, firstOperand);
        outState.putString(KEY_DISPLAY, tvDisplay.getText().toString());
    }

    private double calculateResult(double num1, double num2, String op) {
        if (Objects.equals(op, "+")) return num1 + num2;
        if (Objects.equals(op, "-")) return num1 - num2;
        if (Objects.equals(op, "*")) return num1 * num2;
        if (Objects.equals(op, "/")) {
            if (num2 == 0) return 0;
            return num1 / num2;
        }
        return 0;
    }
}
