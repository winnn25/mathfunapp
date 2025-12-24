package com.example.mathfunapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class CompareActivity extends AppCompatActivity {

    int num1, num2;
    TextView number1, number2, textResult;
    Button buttonGreater, buttonEqual, buttonLess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare);

        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        textResult = findViewById(R.id.textResult);

        buttonGreater = findViewById(R.id.buttonGreater);
        buttonEqual = findViewById(R.id.buttonEqual);
        buttonLess = findViewById(R.id.buttonLess);

        generateNewNumbers();

        buttonGreater.setOnClickListener(v -> checkAnswer(">"));
        buttonEqual.setOnClickListener(v -> checkAnswer("="));
        buttonLess.setOnClickListener(v -> checkAnswer("<"));
    }

    private void generateNewNumbers() {
        Random random = new Random();
        num1 = random.nextInt(10); // 0-9
        num2 = random.nextInt(10);

        number1.setText(String.valueOf(num1));
        number2.setText(String.valueOf(num2));
        textResult.setText(""); // clear result
    }

    private void checkAnswer(String operator) {
        boolean isCorrect = false;

        switch (operator) {
            case ">":
                isCorrect = num1 > num2;
                break;
            case "=":
                isCorrect = num1 == num2;
                break;
            case "<":
                isCorrect = num1 < num2;
                break;
        }

        if (isCorrect) {
            textResult.setText("Correct! 🎉");
            generateNewNumbers(); // go to next
        } else {
            textResult.setText("Try again!");
        }
    }
}
