package com.example.przelicznik;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    RadioGroup radioUnitsGroup;
    RadioButton selectedButton;
    EditText usersInput;
    EditText theResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void convertNumber (View view) {
        radioUnitsGroup = findViewById(R.id.radioUnitGroup);
        usersInput = findViewById(R.id.userInput);
        theResult = findViewById(R.id.numberOutput);

        int selectedUnit = radioUnitsGroup.getCheckedRadioButtonId();
        selectedButton = findViewById(selectedUnit);

        String metersInput = usersInput.getText().toString();
        if (metersInput.trim().length() <= 0) metersInput = "0";

        double numberInMeters = Double.parseDouble(metersInput);
        double result;

        switch (selectedUnit) {
            case R.id.radioCm:
                result = numberInMeters * 100;
                break;
            case R.id.radioKm:
                result = numberInMeters /1000;
                break;
            case R.id.radioMile:
                result = numberInMeters * 0.000621371192;
                break;
            case R.id.radioLy:
                result = numberInMeters * 1.0570008340247e-16;
                break;
            default:
                result = 0;
        }
        theResult.setText(Double.toString(result));

    }
}