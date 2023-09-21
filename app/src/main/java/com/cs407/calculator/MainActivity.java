package com.cs407.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public int getFirstNumber() throws Exception{
        TextView tv1 = (TextView) findViewById(R.id.firstNumber);
        int firstNumber = Integer.parseInt(tv1.getText().toString());
        System.out.println("helloooooooooo");
        return firstNumber;
    }

    public int getSecondNumber() throws Exception {
        TextView tv2 = (TextView) findViewById(R.id.secondNumber);
        int secondNumber = Integer.parseInt(tv2.getText().toString());

        return secondNumber;
    }

    public int[] getBothNumbers(){
        int firstNumber = 0;
        int secondNumber = 0;
        try{
            firstNumber = getFirstNumber();
            secondNumber = getSecondNumber();
        }catch (Exception e){
            Toast.makeText(MainActivity.this, "Bad input", Toast.LENGTH_LONG).show();
            return null;
        }
        return new int[]{firstNumber, secondNumber};
    }

    public void goToActivity(double result){
        Intent intent = new Intent(this, display.class);
        intent.putExtra("result", result);
        startActivity(intent);
    }

    public void clickAdd(View view){
        int[] numbers = getBothNumbers();
        if(numbers == null){
            return;
        }
        double result = numbers[0] + numbers[1];
        goToActivity(result);
    }

    public void clickMinus(View view){
        int[] numbers = getBothNumbers();
        if(numbers == null){
            return;
        }
        double result = numbers[0] - numbers[1];
        goToActivity(result);
    }

    public void clickMultiply(View view){
        int[] numbers = getBothNumbers();
        if(numbers == null){
            return;
        }
        double result = numbers[0] * numbers[1];
        goToActivity(result);
    }

    public void clickDivide(View view){
        int[] numbers = getBothNumbers();
        if(numbers == null){
            return;
        }
        if(numbers[1] == 0){
            Toast.makeText(MainActivity.this, "Can't divide by zero", Toast.LENGTH_LONG).show();
            return;
        }
        double result = (double) numbers[0] / numbers[1];
        goToActivity(result);
    }


}