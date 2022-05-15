package com.geekbrains.calculator2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.google.android.material.radiobutton.MaterialRadioButton;

import static com.geekbrains.calculator2.BaseActivity.AppThemeLight;
import static com.geekbrains.calculator2.BaseActivity.MyDarkTheme;

public class SettingsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        initThemeChooser();
    }
    private void initThemeChooser() {
        initRadioButton(findViewById(R.id.radioButtonAppThemeLight), AppThemeLight);
        initRadioButton(findViewById(R.id.radioButtonMyDarkTheme), MyDarkTheme);

        RadioGroup rg = findViewById(R.id.radioButtons);
        ((MaterialRadioButton) rg.getChildAt(getCodeStyle(AppThemeLight))).setChecked(true);
    }

    private void initRadioButton(View button, final int codeStyle) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAppTheme(codeStyle);
                recreate();
            }
        });
    }
}