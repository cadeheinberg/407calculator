package com.cs407.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

public class display extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        textView = findViewById(R.id.displayResult);
        Intent intent = getIntent();
        double result = intent.getDoubleExtra("result", 0);
        String print_result = new DecimalFormat("#.############").format(result);
        textView.setText(print_result);
    }
}