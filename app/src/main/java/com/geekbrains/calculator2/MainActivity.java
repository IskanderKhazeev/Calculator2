package com.geekbrains.calculator2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.radiobutton.MaterialRadioButton;

public class MainActivity extends BaseActivity {
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
    private double result;
    private double numberOne;
    private double numberTwo;
    private String parcelable_tag;
    private Button buttonSettings;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(getAppTheme(R.style.AppThemeLight));
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
        buttonSettings = findViewById(R.id.button_settings);

        equallySetOnClickListener(buttonEqually);
        deleteSetOnClickListener(buttonDelete);
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
        settingsSetOnClickListener(buttonSettings);
    }

    private void settingsSetOnClickListener(Button btn) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });
    }






    public void onSaveInstanceState(@NonNull Bundle instanceState) {
        super.onSaveInstanceState(instanceState);
        SaveTextViews saveTextView = new SaveTextViews(textCalculation, textResult);
        saveTextView.setTextCalculation(textCalculation);
        saveTextView.setTextResult(textResult);
        instanceState.putParcelable(parcelable_tag, saveTextView);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle instanceState) {
        super.onRestoreInstanceState(instanceState);
        SaveTextViews saveTextView = new SaveTextViews(textCalculation, textResult);
        saveTextView = instanceState.getParcelable(parcelable_tag);
        textCalculation.setText(saveTextView.getTextCalculation().getText());
        textResult.setText(saveTextView.getTextResult().getText());
    }

    public void equallySetOnClickListener(Button btn) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence incomingCharSequence;
                incomingCharSequence = textCalculation.getText();

                int iCharSequence = 0;
                for (int i = 0; i < incomingCharSequence.length(); i++) {
                    if (incomingCharSequence.charAt(i) == '+'
                            || incomingCharSequence.charAt(i) == '-'
                            || incomingCharSequence.charAt(i) == '/'
                            || incomingCharSequence.charAt(i) == 'x') {
                        iCharSequence = i;
                    }
                }
                numberOne = Double.parseDouble(String.valueOf(incomingCharSequence.subSequence(0, iCharSequence)));
                numberTwo = Double.parseDouble(String.valueOf(incomingCharSequence.subSequence(iCharSequence + 1, incomingCharSequence.length())));
                determinationOperator(incomingCharSequence);
                textResult.setText(String.valueOf(Math.round(result * 100.0) / 100.0));


            }
        });
    }

    public void deleteSetOnClickListener(Button btn) {
        btn.setOnClickListener(v -> textCalculation.setText(String.valueOf("")));
    }

    public void mySetOnClickListener(Button btn) {
        btn.setOnClickListener(v -> textCalculation.setText((textCalculation.getText()) + String.valueOf(btn.getText())));
    }

    public void determinationOperator(CharSequence charSequence) {
        for (int i = 0; i < charSequence.length(); i++) {
            if (charSequence.charAt(i) == '+') {
                result = numberOne + numberTwo;

            } else if (charSequence.charAt(i) == '-') {
                result = numberOne - numberTwo;

            } else if (charSequence.charAt(i) == '/') {
                result = numberOne / numberTwo;

            } else if (charSequence.charAt(i) == 'x') {
                result = numberOne * numberTwo;

            }
        }
    }
}


