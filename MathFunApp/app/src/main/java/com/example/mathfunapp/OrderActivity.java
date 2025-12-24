package com.example.mathfunapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    private TextView textNumbers, textFeedback;
    private EditText inputOrder;
    private Button submitOrder;

    private List<Integer> numbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        textNumbers = findViewById(R.id.textNumbers);
        textFeedback = findViewById(R.id.textFeedback);
        inputOrder = findViewById(R.id.inputOrder);
        submitOrder = findViewById(R.id.submitOrder);

        generateNumbers();

        submitOrder.setOnClickListener(v -> checkOrder());
    }

    private void generateNumbers() {
        Random rand = new Random();
        numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int num = rand.nextInt(10);
            if (!numbers.contains(num)) {
                numbers.add(num);
            }
        }
        textNumbers.setText("Numbers: " + numbers.toString());
        textFeedback.setText("");
        inputOrder.setText("");
    }

    private void checkOrder() {
        String input = inputOrder.getText().toString().trim();
        if (input.isEmpty()) {
            textFeedback.setText("Please enter numbers.");
            return;
        }

        String[] inputParts = input.split(",");
        if (inputParts.length != 3) {
            textFeedback.setText("Enter exactly 3 numbers separated by commas.");
            return;
        }

        try {
            List<Integer> userInput = new ArrayList<>();
            for (String s : inputParts) {
                userInput.add(Integer.parseInt(s.trim()));
            }

            List<Integer> correctOrder = new ArrayList<>(numbers);
            Collections.sort(correctOrder);

            if (userInput.equals(correctOrder)) {
                textFeedback.setText("Correct! 🎉");
                generateNumbers();
            } else {
                textFeedback.setText("Try again!");
            }
        } catch (NumberFormatException e) {
            textFeedback.setText("Please enter valid numbers.");
        }
    }
}
