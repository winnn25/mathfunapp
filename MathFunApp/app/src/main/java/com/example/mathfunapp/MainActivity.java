package com.example.mathfunapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Button btnCompare, btnOrder, btnCompose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCompare = findViewById(R.id.btnCompare);
        btnOrder = findViewById(R.id.btnOrder);
        btnCompose = findViewById(R.id.btnCompose);

        btnCompare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open CompareNumbersActivity (we'll create it next)
                startActivity(new Intent(MainActivity.this, CompareActivity.class));
            }
        });

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, OrderActivity.class));
            }
        });

        btnCompose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ComposeActivity.class));
            }
        });
    }
}