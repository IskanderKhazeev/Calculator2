package com.geekbrains.calculator2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private TextView textCalculation;
private TextView textResult;
private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button0;
    private Button buttonDot;
    private Button buttonDivide;
    private Button buttonMultiply;
    private Button buttonMinus;
    private Button buttonPlus;
    private Button buttonEqually;
    private Button buttonDelete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textCalculation = findViewById(R.id.text_calculation);
        textResult = findViewById(R.id.text_result);
        button1 = findViewById(R.id.button_1);
        button2 = findViewById(R.id.button_2);
        button3 = findViewById(R.id.button_3);
        button4 = findViewById(R.id.button_4);
        button5 = findViewById(R.id.button_5);
        button6 = findViewById(R.id.button_6);
        button7 = findViewById(R.id.button_7);
        button8 = findViewById(R.id.button_8);
        button9 = findViewById(R.id.button_9);
        button0 = findViewById(R.id.button_0);
        buttonDot = findViewById(R.id.button_dot);
        buttonDivide = findViewById(R.id.button_divide);
        buttonMultiply = findViewById(R.id.button_multiply);
        buttonMinus = findViewById(R.id.button_minus);
        buttonPlus = findViewById(R.id.button_plus);
        buttonEqually = findViewById(R.id.button_equally);
        buttonDelete = findViewById(R.id.button_delete);

        mySetOnClickListener(button1);
        mySetOnClickListener(button2);
        mySetOnClickListener(button3);
        mySetOnClickListener(button4);
        mySetOnClickListener(button5);
        mySetOnClickListener(button6);
        mySetOnClickListener(button7);
        mySetOnClickListener(button8);
        mySetOnClickListener(button9);
        mySetOnClickListener(button0);
        mySetOnClickListener(buttonDot);
        mySetOnClickListener(buttonDivide);
        mySetOnClickListener(buttonMultiply);
        mySetOnClickListener(buttonMinus);
        mySetOnClickListener(buttonPlus);
        mySetOnClickListener(buttonEqually);
        mySetOnClickListener(buttonDelete);

    }

    public void mySetOnClickListener (Button btn){
        btn.setOnClickListener(v -> textCalculation.setText((textCalculation.getText()) + String.valueOf(btn.getText())));
    }
}