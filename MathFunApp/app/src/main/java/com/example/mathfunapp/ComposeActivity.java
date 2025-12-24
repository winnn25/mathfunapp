package com.example.mathfunapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class ComposeActivity extends AppCompatActivity {

    private TextView composeTargetNumber, composeFeedback;
    private EditText inputPart1, inputPart2;
    private Button submitCompose;
    private int target;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose);

        composeTargetNumber = findViewById(R.id.composeTargetNumber);
        composeFeedback = findViewById(R.id.composeFeedback);
        inputPart1 = findViewById(R.id.inputPart1);
        inputPart2 = findViewById(R.id.inputPart2);
        submitCompose = findViewById(R.id.submitCompose);

        generateTarget();

        submitCompose.setOnClickListener(v -> checkComposition());
    }

    private void generateTarget() {
        Random rand = new Random();
        target = rand.nextInt(10) + 1; // between 1 and 10
        composeTargetNumber.setText("Target Number: " + target);
        composeFeedback.setText("");
        inputPart1.setText("");
        inputPart2.setText("");
    }

    private void checkComposition() {
        String part1Str = inputPart1.getText().toString().trim();
        String part2Str = inputPart2.getText().toString().trim();

        if (part1Str.isEmpty() || part2Str.isEmpty()) {
            composeFeedback.setText("Enter both parts.");
            return;
        }

        try {
            int part1 = Integer.parseInt(part1Str);
            int part2 = Integer.parseInt(part2Str);

            if (part1 + part2 == target) {
                composeFeedback.setText("Correct! 🎉");
                generateTarget();
            } else {
                composeFeedback.setText("Try again.");
            }
        } catch (NumberFormatException e) {
            composeFeedback.setText("Please enter valid numbers.");
        }
    }
}
